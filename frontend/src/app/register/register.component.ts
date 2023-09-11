import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form = {
    username:"",
    lastname:"",
    firstname: "",
    email: "",
    password: "",
    confirmPassword:"",
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
username: any;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const {username, lastname, firstname, email, password } = this.form;

    this.authService.register(username, lastname, firstname, email, password).subscribe({
      next: data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.reloadPage();
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    });;
  }
  onReset(form: NgForm): void {
    form.reset();
  }
  reloadPage(): void {
    window.location.replace("/home");
  }
}

