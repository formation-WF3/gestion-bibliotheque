import { Component } from '@angular/core';
import { Observable, Subject, debounceTime, distinctUntilChanged, switchMap } from 'rxjs';
import { Book } from '../models/book';
import { BookService } from '../_services/book.service';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../_services/storage.service';

@Component({
  selector: 'app-book-search-results',
  templateUrl: './book-search-results.component.html',
  styleUrls: ['./book-search-results.component.css']
})
export class BookSearchResultsComponent {
  books$!: Observable<Book[]>;
  private searchTerms = new Subject<string>();

  isLoggedIn = false;
  constructor(private bookService: BookService, private http: HttpClient, private storageService: StorageService) {}

  search(term: string): void {
    this.searchTerms.next(term);
  }
  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.books$ = this.searchTerms.pipe(
        // wait 300ms after each keystroke before considering the term
        debounceTime(300),
  
        // ignore new term if same as previous term
        distinctUntilChanged(),
  
        // switch to new search observable each time the term changes
        switchMap((term: string) => this.bookService.searchBook(term)),
        );
    }
  }
  
}
