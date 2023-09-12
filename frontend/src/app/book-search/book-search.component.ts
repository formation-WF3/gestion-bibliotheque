import { Component, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

@Component({
  selector: 'app-book-search',
  templateUrl: './book-search.component.html',
  styleUrls: ['./book-search.component.css']
})
export class BookSearchComponent {

  @Input() title: Observable<Book[]> | undefined;
}
