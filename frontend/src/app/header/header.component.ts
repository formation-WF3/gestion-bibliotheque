import { Component } from '@angular/core';
import { StorageService } from '../_services/storage.service';
import { AuthService } from '../_services/auth.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  content?: string;
  isLoggedIn = false;
  showUser = false;
  username?: string;
  currentUser: any;
  private roles: string[] = [];
  public isCollapsed = true;

  constructor(private storageService: StorageService, private authService: AuthService,private userService: UserService) { }

  ngOnInit(): void {
    
    this.currentUser = this.storageService.getUser();
    this.isLoggedIn = this.storageService.isLoggedIn();

    if (this.isLoggedIn) {
      const user = this.storageService.getUser();
      this.roles = user.roles;

      this.showUser = this.roles.includes('ROLE_USER');
      this.userService.getPublicContent().subscribe({
      next: data => {
        this.content = data;
      },
      error: err => {console.log(err)
        if (err.error) {
          this.content = JSON.parse(err.error).message;
        } else {
          this.content = "Error with status: " + err.status;
        }
      }
    });
  }
}
  logout(): void {
    this.authService.logout().subscribe({
      next: res => {
        console.log(res);
        this.storageService.clean();

        window.location.replace("/login");
      },
      error: err => {
        console.log(err);
      }
    });
  }
}
