import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { StorageService } from './storage.service';
import { UserService } from './user.service';
import { Book } from '../models/book';

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

//   createBorrow(utilisateur:StorageService,book: Book) {
    
//     return this.http.post(`${this.baseUrl}/create`, {
//       utilisateur,
//       book,
//     });
//   }

}