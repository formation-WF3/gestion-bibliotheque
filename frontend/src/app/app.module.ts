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
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';

import { httpInterceptorProviders } from './_helpers/http.interceptor';
import { UnderConstructionComponent } from './under-construction/under-construction.component';
import { HeaderComponent } from './header/header.component';
import { AdvancedSearchComponent } from './advanced-search/advanced-search.component';
import { MainBoardComponent } from './main-board/main-board.component';
import { NavBoardComponent } from './nav-board/nav-board.component';
import { ValidationButtonsComponent } from './validation-buttons/validation-buttons.component';

@NgModule({
  declarations: [
    AppComponent,
   HeaderComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    UnderConstructionComponent,
    AdvancedSearchComponent,
    MainBoardComponent,
    NavBoardComponent,
    ValidationButtonsComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
