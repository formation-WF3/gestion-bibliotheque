import { Injectable } from '@angular/core';
import jwt_decode from 'jwt-decode';

const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root',
})
export class StorageService {
  userRole: string[] = ['ROLE_USER', 'ROLE_ADMIN'];

  getUserInfo(role: string): boolean {
    return this.userRole.includes(role);
  }
  constructor() {}

  clean(): void {
    window.sessionStorage.clear();
  }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }

    return {};
  }

  public isLoggedIn(): boolean {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return true;
    }
    return false;
  }

  public getToken(): string | null {
    return localStorage.getItem('accessToken');
  }

public  hasRole(role: string): boolean {
    const userRole = this.getUser();
    if (!userRole) {
      console.log('No token');
      return false;
    }

    return userRole.roles.includes(role);
  }
}
