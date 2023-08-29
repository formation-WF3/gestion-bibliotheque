import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  API_URL = "http://localhost:8080/api";

  constructor( private httpClient: HttpClient) { 
  }

  getAll(): Observable<Book[]>{ 

    return this.httpClient.get<Book[]>(`${this.API_URL}/books`)
    
   }

}
