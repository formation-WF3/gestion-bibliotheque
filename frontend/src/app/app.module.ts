import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { httpInterceptorProviders } from './_helpers/http.interceptor';
import { UnderConstructionComponent } from './under-construction/under-construction.component';
import { HeaderComponent } from './header/header.component';
import { AdvancedSearchComponent } from './advanced-search/advanced-search.component';
import { MainBoardComponent } from './main-board/main-board.component';
import { ValidationButtonsComponent } from './validation-buttons/validation-buttons.component';
import { NavButtonsComponent } from './nav-buttons/nav-buttons.component';
import { LoanTabComponent } from './loan-tab/loan-tab.component';
import { PenaltyTabComponent } from './penalty-tab/penalty-tab.component';
import { BookSearchComponent } from './book-search/book-search.component';
import { RegisterConfirmationComponent } from './register-confirmation/register-confirmation.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { BookSearchResultsComponent } from './book-search-results/book-search-results.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { ErrorComponent } from './error/error.component';

import { ListLoanComponent } from './list-loan/list-loan.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    UnderConstructionComponent,
    AdvancedSearchComponent,
    MainBoardComponent,
    ValidationButtonsComponent,
    NavButtonsComponent,
    LoanTabComponent,
    PenaltyTabComponent,
    BookSearchComponent,
    RegisterConfirmationComponent,
    BookListComponent,
    BookDetailComponent,
    BookSearchResultsComponent,
    ErrorComponent,
    ListLoanComponent 

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
