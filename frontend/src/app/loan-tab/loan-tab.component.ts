import { Component } from '@angular/core';
import { LoanService } from '../_services/loan.service';
import { Book } from '../models/book';
import { BookService } from '../_services/book.service';
import { ActivatedRoute } from '@angular/router';
import { StorageService } from '../_services/storage.service';
import { Location } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Loan } from '../models/Loan';


const API_URL = "http://localhost:8080/api/";

@Component({
  selector: 'app-loan-tab',
  templateUrl: './loan-tab.component.html',
  styleUrls: ['./loan-tab.component.css']
})
export class LoanTabComponent {
 
  book: Book | undefined;
  currentUser: any;
  message: string = '';
  messageError: string = '';
  
  constructor(
    private http: HttpClient,
    private loanService: LoanService,
    private bookService: BookService,
    private route: ActivatedRoute,
    private storageService: StorageService,
    private location: Location
)
   {}

   ngOnInit(): void {
    this.getBook();
    this.currentUser = this.storageService.getUser();
  }

  getBook():void {

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

      user_id: this.currentUser.id,
      book_id: this.book?.id
  };
  this.http.post(url, empruntData).subscribe(
   
    (response) => {
      // console.log('Emprunt enregistré avec succès :', response);
      this.message = 'Emprunt enregistré avec succès :';
    },
    (error) => {
      // console.error('Erreur lors de l\'enregistrement de l\'emprunt :', error);
      this.messageError = 'Erreur lors de l\'enregistrement de l\'emprunt  :';
    }
  );
  

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
