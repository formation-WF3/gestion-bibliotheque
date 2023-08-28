import { Component } from '@angular/core';

type Book = Array<{
  id: number;
  title: string;
  author: string;
  genre: string;
  total: number;
  totalLeft: number;
}>;
@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
})
export class BookListComponent {
  books: Book = [
    {
      id: 1,
      title: 'Dune',
      author: 'Herbert Franck',
      genre: 'Science Fiction',
      total: 10,
      totalLeft: 8,
    },
    {
      id: 2,
      title: 'Les Contemplations',
      author: 'Hugo Victor',
      genre: 'Poesies',
      total: 10,
      totalLeft: 8,
    },
    {
      id: 3,
      title: 'La Route',
      author: 'Mc Carthy Cormack',
      genre: 'Roman',
      total: 10,
      totalLeft: 7,
    },
    {
      id: 4,
      title: 'Terreur',
      author: 'Dan Simmons',
      genre: 'Roman',
      total: 10,
      totalLeft: 8,
    },
    {
      id: 5,
      title: 'L.A Confidential',
      author: 'Ellroy James',
      genre: 'Policier',
      total: 10,
      totalLeft: 3,
    },
    {
      id: 6,
      title: 'Les Misérables',
      author: 'Hugo Victor',
      genre: 'Roman',
      total: 10,
      totalLeft: 1,
    },
    {
      id:7,
      title: 'Substance Mort',
      author: 'Dick Philip K. ',
      genre: 'Science Fiction',
      total: 10,
      totalLeft: 6,
    },
    {
      id: 8,
      title: "L'Eté Meurtrier",
      author: 'Japrisot Franck',
      genre: 'Policier',
      total: 10,
      totalLeft: 9,
    },
    {
      id: 9,
      title: 'La Horde Du Contrevent',
      author: 'Damasio Alain',
      genre: 'Science Fiction',
      total: 10,
      totalLeft:2,
    },
    {
      id:10,
      title: 'Alcools',
      author: 'Apollinaire Guilleaume',
      genre: 'Poesie',
      total: 10,
      totalLeft: 7,
    },
    {
      id: 11,
      title: 'Au Coeur des Ténèbres',
      author: 'Conrad James',
      genre: 'Roman',
      total: 10,
      totalLeft: 4,
    },
  ];
}
