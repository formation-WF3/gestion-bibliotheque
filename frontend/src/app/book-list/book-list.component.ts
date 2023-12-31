
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { BookService } from '../_services/book.service';
import { Book } from '../models/book';


@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
})
export class BookListComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookService: BookService) {}

  ngOnInit() {
    this.bookService.getAll().subscribe((books) => (this.books = books));
  }

  // @Output() selectEvent:EventEmitter<string> = new EventEmitter<string>();
  // goToSelectEvent(value:string ) {

  //   this.selectEvent.emit(value);
  //   console.log(value)

  // }
}
