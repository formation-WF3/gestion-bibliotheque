import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { MessageService } from './MessageService';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Book } from '../models/book';
import { StorageService } from './storage.service';
import { identifierName } from '@angular/compiler';

const API_URL = "http://localhost:8080/api/";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class BookService {
  currentUser: any;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor( private http: HttpClient,  private messageService: MessageService,private storageService: StorageService) { 
  }
getCurrentUserID(): number {
    this.currentUser = this.storageService.getUser();
    return this.currentUser; // Exemple d'ID d'utilisateur
  }
ngOnInit(): void {
  this.getCurrentUserID();
  }
  
getAll(): Observable<any[]>{ 
    return this.http.get<Book[]>(API_URL + 'books/list')
  }

getById(id: number): Observable<Book> {
    const url = `${API_URL}books/id/${id}`;
    // équivalent  const url = (API_URL + 'books/' + id);
    return this.http.get<Book>(url).pipe(
      tap(_ => this.log(`fetched book id=${id}`)),
      catchError(this.handleError<Book>(`getById id=${id}`))
    );
}

getByTitle(title: string): Observable<any>{
    return this.http.get<Book>(`${API_URL}books/title/${title}`);
}
  
searchbooks(term: string): Observable<Book[]> {
  if (!term.trim()) {
      // if not search term, return empty book array.
    return of([]);
  }
    return this.http.get<Book[]>(`${API_URL}books/term/${term}`).pipe(
      tap(x => x.length ?
         this.log(`found books matching "${term}"`) :
         this.log(`no books matching "${term}"`)),
      catchError(this.handleError<Book[]>('searchbooks', []))
  );
}

updateBook(book: Book): Observable<any> {
  return this.http.put(`${API_URL}books/${book}`, book, this.httpOptions).pipe(
    tap(_ => this.log(`updated book id=${book.id}`)),
    catchError(this.handleError<any>('updateBook'))
  );
}


  /**
   * Handle Http operation that failed.
   * Let the app continue.
   *
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a BookService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`bookService: ${message}`);
  }
}
