import {Component} from '@angular/core';
import {Book} from '../models/book';
import {ActivatedRoute} from '@angular/router';
import {BookService} from '../_services/book.service';
import {Location} from '@angular/common';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent {
  book: Book | undefined;

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute,
    private bookService: BookService,
    private location: Location
  ) {
  }

  ngOnInit(): void {
    this.getBook();
  }

  getBook(): void {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.bookService.getById(id)
      .subscribe(book => this.book = book);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    if (this.book) {
      this.bookService.updateBook(this.book)
        .subscribe(
          () => this.goBack()
        );
    }
  }
}
