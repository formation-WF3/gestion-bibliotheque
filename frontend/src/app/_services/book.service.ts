import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

const API_URL = "http://localhost:8080/api/";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class BookService {

 

  constructor( private http: HttpClient) { 
  }

  getAll(): Observable<any[]>{ 

    return this.http.get<Book[]>(API_URL + 'books')
    
   }

}
