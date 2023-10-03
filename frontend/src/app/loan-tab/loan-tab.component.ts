import { Component } from '@angular/core';
import { Book } from '../models/book';
import { BookService } from '../_services/book.service';
import { ActivatedRoute } from '@angular/router';
import { StorageService } from '../_services/storage.service';
import { Location } from '@angular/common';
import { HttpClient } from '@angular/common/http';



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
  messageItemsError: string = '';
  totalItems!: number;
  
  constructor(
    private http: HttpClient,
    private bookService: BookService,
    private route: ActivatedRoute,
    private storageService: StorageService,
    private location: Location,
)
   {}

   ngOnInit(): void {
    this.getBook();
    this.currentUser = this.storageService.getUser();
    this.Items();
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
      // this.reloadPage();
    },
    (error) => {
      // console.error('Erreur lors de l\'enregistrement de l\'emprunt :', error);
      this.messageError = 'Erreur lors de l\'enregistrement de l\'emprunt  :';
    }
  );
  
}

 Items() {
  const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.bookService.getAllItemsByBook().subscribe(
      (total) => {
        this.totalItems = total;
      },
      (error) => {
        console.error('Erreur lors de la récupération du total d\'exemplaires disponibles', error);
        this.messageItemsError = 'Plus d\'exemplaire disponible';
        
      }
    );
  }
  
reloadPage(): void {
  window.location.replace("/main-board");
}
}
