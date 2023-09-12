import { Component, Input } from '@angular/core';
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
  
 
  
}
