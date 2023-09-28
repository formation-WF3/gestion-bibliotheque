import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { StorageService } from './storage.service';
import { UserService } from './user.service';
import { Book } from '../models/book';

import { ActivatedRoute } from '@angular/router';
import { BookService } from './book.service';
import { Observable } from 'rxjs';
import { Loan } from '../models/Loan';
import { AuthService } from './auth.service';

const API_URL = "http://localhost:8080/api/";


@Injectable({
  providedIn: 'root',
})
export class LoanService {
  private baseUrl = 'http://localhost:8080/api/loans'; // L'URL backend Spring Boot

  currentUser: any;
  constructor(private http: HttpClient, private storageService: StorageService) {}

  ngOnInit(): void {
    this.getCurrentUserID();
  }

  getCurrentUserID(): number {
    this.currentUser = this.storageService.getUser();
    return this.currentUser; // Exemple d'ID d'utilisateur
  }
  getAll(): Observable<any[]>{ 

    return this.http.get<Loan[]>(API_URL + 'loans/list')
  }
//   createBorrow(utilisateur:StorageService,book: Book) {
    
//     return this.http.post(`${this.baseUrl}/create`, {
//       utilisateur,
//       book,
//     });
//   }

//Trouver les emprunts pour un user specifique 
getLoanByUser(): Observable<Loan[]>{
  const token = this.storageService.getToken();
  const headers = new HttpHeaders().set('Authorization','Bearer '+token);
return this.http.get<Loan[]>(API_URL + 'loans/my-loans', { headers:headers});
}


}