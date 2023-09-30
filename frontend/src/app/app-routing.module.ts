import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { MainBoardComponent } from './main-board/main-board.component';
import { BookSearchComponent } from './book-search/book-search.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { LoanTabComponent } from './loan-tab/loan-tab.component';
import { ListLoanComponent } from './list-loan/list-loan.component';





const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'main-board', component:MainBoardComponent},
  { path:'book-search', component:BookSearchComponent },
  { path:'books', component:BookListComponent },
  { path: 'book-detail/:id', component: BookDetailComponent },
  { path: 'loans/list', component: ListLoanComponent },
  { path: 'loans/:id', component: LoanTabComponent },

  { path: '', redirectTo: 'home', pathMatch: 'full' }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

