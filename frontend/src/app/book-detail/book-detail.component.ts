import { Component } from '@angular/core';
import { Book } from '../models/book';
import { ActivatedRoute } from '@angular/router';
import { BookService } from '../_services/book.service';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../_services/storage.service';
const API_URL = "http://localhost:8080/api/";

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent {
  book: Book | undefined;
  currentUser: any;
  message: string = '';
  messageError: string = '';
  constructor(
    private http: HttpClient,
    private route: ActivatedRoute,
    private bookService: BookService,
    private location: Location,
    private storageService: StorageService
    
  ) {}

  ngOnInit(): void {
    this.currentUser = this.storageService.getUser();
    this.getBook();
  }

  getBook(): void {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.bookService.getById(id)
      .subscribe(book => this.book = book);
  }
  
  goBack(): void {
    this.location.back();
  }

  save(): void {
    if (this.book) {
      this.bookService.updateBook(this.book)
        .subscribe(() => this.goBack());
    }
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
        this.reloadPage();
      },
      (error) => {
        // console.error('Erreur lors de l\'enregistrement de l\'emprunt :', error);
        this.messageError = 'Erreur lors de l\'enregistrement de l\'emprunt  :';
      }
    );
  
  }

  reloadPage(): void {
    window.location.replace("/main-board");
  }
}