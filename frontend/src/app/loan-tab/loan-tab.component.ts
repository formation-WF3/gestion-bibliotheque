import { Component } from '@angular/core';
import { LoanService } from '../_services/loan.service';
import { Book } from '../models/book';
import { BookService } from '../_services/book.service';
import { ActivatedRoute } from '@angular/router';
import { StorageService } from '../_services/storage.service';
import { Location } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = "http://localhost:8080/api/";

@Component({
  selector: 'app-loan-tab',
  templateUrl: './loan-tab.component.html',
  styleUrls: ['./loan-tab.component.css']
})
export class LoanTabComponent {
  user_id!: number;
  book!: Book;
  book_id = Observable<Book>;
  currentUser: any;
  currentUserID: number;

  
  constructor(
    private http: HttpClient,
    // private loanService: LoanService,
    private bookService: BookService,
    private route: ActivatedRoute,
    private storageService: StorageService,
    private location: Location
)
   {this.currentUserID = this.bookService.getCurrentUserID();this.book_id}

   ngOnInit(): void {
    this.getBook();
    this.currentUser = this.storageService.getUser();
  }

  // submitLoan() {
  //   // Envoyer les données au service pour les traiter et les envoyer au backend
  //   this.loanService.createLoan({
  //     userId: this.currentUser,
  //     bookId: this.getBook(),
  //     startDate: this.startDate,
  //     endDate: this.endDate,
  //   });
  // }
  getBook():undefined {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.bookService.getById(id)
      .subscribe(book => this.book = book);
  }

  goBack(): void {
    this.location.back();
  }

  enregistrerEmprunt() {
    const url = `${API_URL}loans/create`;
    const empruntData = {
      userID: this.currentUserID,
      bookID: this.book_id,
  };
 
  this.http.post(url, empruntData).subscribe(
   
    (response) => {
      console.log('Emprunt enregistré avec succès :', response);
    },
    (error) => {
      console.error('Erreur lors de l\'enregistrement de l\'emprunt :', error);
    }
  );
}
}
