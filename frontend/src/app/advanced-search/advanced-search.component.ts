import { Component, OnInit } from '@angular/core';
import { BookService } from '../_services/book.service';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../_services/storage.service';
import { Observable, Subject, debounceTime, distinctUntilChanged, switchMap } from 'rxjs';
import { Book } from '../models/book';
@Component({
  selector: 'app-advanced-search',
  templateUrl: './advanced-search.component.html',
  styleUrls: ['./advanced-search.component.css']
})
export class AdvancedSearchComponent implements OnInit{
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
