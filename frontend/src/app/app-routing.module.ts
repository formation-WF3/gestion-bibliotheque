import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { UnderConstructionComponent } from './under-construction/under-construction.component';
import { MainBoardComponent } from './main-board/main-board.component';
import { BookSearchComponent } from './book-search/book-search.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailComponent } from './book-detail/book-detail.component';




const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'under-construction', component: UnderConstructionComponent},
  { path: 'main-board', component:MainBoardComponent},
  { path:'book-search', component:BookSearchComponent },
  { path:'book-list', component:BookListComponent },
  { path: 'book-detail/:id', component: BookDetailComponent },
  { path: 'book-detail', component: BookDetailComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

