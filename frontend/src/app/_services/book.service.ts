import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { MessageService } from './MessageService';
// import { Book } from '../models/book';
import { ActivatedRoute } from '@angular/router';
import { Book } from '../models/book';
import { StorageService } from './storage.service';


const API_URL = "http://localhost:8080/api/";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class BookService {
  currentUser: any;

  book: Book | undefined;


  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor( private http: HttpClient,  private messageService: MessageService,private storageService: StorageService, private route: ActivatedRoute,) { 
  }
getCurrentUserID(): number {
    this.currentUser = this.storageService.getUser();
    return this.currentUser; // Exemple d'ID d'utilisateur
  }
ngOnInit(): void {
  
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
  
searchBook(term: string): Observable<Book[]> {
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

getBook(): void {
  const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
  this.getById(id)
    .subscribe(book => this.book = book);
}

updateBook(book: Book): Observable<any> {
  return this.http.put(`${API_URL}books/update/${book.id}`, book, this.httpOptions).pipe(
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
