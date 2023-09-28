import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { StorageService } from './storage.service';
import { UserService } from './user.service';
import { Book } from '../models/book';
import { ActivatedRoute } from '@angular/router';
import { BookService } from './book.service';
import { Observable } from 'rxjs';
import { Loan } from '../models/Loan';

const API_URL = "http://localhost:8080/api/";

@Injectable({
  providedIn: 'root',
})
export class LoanService {
  private baseUrl = 'http://localhost:8080/api/loans'; // L'URL backend Spring Boot

  currentUser: any;
  CurrentBook: any;
  book: Book | undefined;

  constructor(private http: HttpClient, private storageService: StorageService,private route: ActivatedRoute,
    private bookService: BookService,) {}

  ngOnInit(): void {
   
  }
  getBookByid(): number{
    this.CurrentBook = this.getBook();
    return this.CurrentBook; // Exemple d'ID Book
  }

  public getBook(): any {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    const book_id = this.bookService.getById(id)
      .subscribe(book => this.book = book);
      return book_id;
  }
  getAll(): Observable<any[]>{ 
    return this.http.get<Loan[]>(API_URL + 'loans/list/{id}')
  }
 
//   createBorrow(utilisateur:StorageService,book: Book) {
    
//     return this.http.post(`${this.baseUrl}/create`, {
//       utilisateur,
//       book,
//     });
//   }

}