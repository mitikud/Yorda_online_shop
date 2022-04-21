import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Subject } from "rxjs";
import {MatSnackBar} from '@angular/material/snack-bar';

import { AuthData } from "../../models/auth-data.model";
import { LoginData } from "../../models/login-data.model";
@Injectable({ providedIn: 'root' })
export class AuthService{
  userId: string = '';
  role: string = '';
  isAuthenticated = false;
  private tokenTimer: any;
  private tokenData: string = '';
  private authStatusListner = new Subject<boolean>();
  private _registerURL = 'http://localhost:3000/api/register';
  private _loginURL = 'http://localhost:3000/api/login';

  constructor(private http: HttpClient, private router: Router, private _snackBar: MatSnackBar){
  }

  getAuthStatusListner(){
    return this.authStatusListner.asObservable();
  }

  getToken(){
    return localStorage.getItem('token');
  }

  getAuth(){
    return this.isAuthenticated;
  }

  createUser(firstName:string, lastName:string, email: string, password: string, role: string){
    const authData: AuthData = {
      firstName: firstName,
      lastName: lastName,
      email: email,
      password: password, 
      role: role,
      
    };
    return this.http.post<any>(this._registerURL, authData)
    
  }

  login(email: string, password: string){
    const loginData: LoginData = {email: email, password: password }
    this.http.post<{
      token: string,
      role: string
    }>(this._loginURL, loginData).subscribe((res) => {
      const token = res.token;
      if(token){
        console.log(res)
        this.role = res.role;

        this.saveAuthData(token, this.role);
        if(res.role == "CUSTOMER"){
          this.router.navigate(['/products'])
         }
          if(res.role == "VENDOR"){
            this.router.navigate(['/product'])
          }
          if(res.role == "ADMIN"){
            this.router.navigate(['/admin'])
          }

      }
    })
  }

  private saveAuthData(token: string, role: string){
    localStorage.setItem('token', token);
    localStorage.setItem('role', role)
  }
  // login(user: any){
  //   return this.http.post<any>(this._loginURL, user)
  // }

  loggedIn(){
    return !!localStorage.getItem('token')
  }

  logoutUser(){
    localStorage.removeItem('token')
    this.router.navigate(['/products'])
  }

  private setAuthTimer(duration: number){
    this.tokenTimer = setTimeout(() => {
      this.logout();
    }, duration * 1000)
  }

  autoAuthUser(){
    const authInfo = this.getAuthData();
    if(!authInfo){
      return;
    }
    const now = new Date();
    if(authInfo != undefined){
      const expiresIn = authInfo.expirationDate.getTime() - now.getTime();
      if(expiresIn > 0){
        this.tokenData = authInfo.token;
        this.isAuthenticated = true;
        this.setAuthTimer(expiresIn / 1000);
        this.authStatusListner.next(true);
      }
    }
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }



  // login(email: string, password: string){
  //   const loginData: LoginData = { email: email, password: password }
  //   this.http.post<{
  //     token: string,
  //     expiresIn: number,
  //     userId: string,
  //     userType: string
  //    }>(this._registerURL, loginData).subscribe((response) => {
  //     const token = response.token;
  //     if(token){
  //       console.log(response)
  //       this.setAuthTimer(response.expiresIn);
  //       this.userId = response.userId;
  //       this.userType = response.userType;
  //       this.tokenData = token;
  //       this.isAuthenticated = true;
  //       this.authStatusListner.next(true);
  //       const now = new Date();
  //       const expirationDate = new Date(now.getTime() + response.expiresIn * 1000);
  //       this.saveAuthData(token, expirationDate, this.userId, this.userType);
  //       if(response.userType == "customer"){
  //         this.router.navigate(['/customer'])
  //         this.openSnackBar('Logged in', 'Dismiss')
  //       }
  //       if(response.userType == "vendor"){
  //         this.router.navigate(['/vendor'])
  //         this.openSnackBar('Logged in', 'Dismiss')
  //       }
  //       if(response.userType == "admin"){
  //         this.router.navigate(['/admin']);
  //         this.openSnackBar('Logged in', 'Dismiss')
  //       }
  //     }
  //   })
  // }

  logout(){
    this.tokenData = '';
    this.isAuthenticated = false;
    this.authStatusListner.next(false);
    clearTimeout(this.tokenTimer);
    this.router.navigate(['/login']);
    this.clearAuthData();
    this.openSnackBar('Logged out', 'Dismiss')
  }

  // private saveAuthData(token: string, expirationDate: Date, userId: string, userType: string){
  //   localStorage.setItem('token', token);
  //   localStorage.setItem('expiration', expirationDate.toISOString());
  //   localStorage.setItem('userId', userId);
  //   localStorage.setItem('userType', userType)
  // }

  private clearAuthData(){
    localStorage.removeItem('token');
    localStorage.removeItem('expiration');
  }

  private getAuthData(){
    const token = localStorage.getItem("token");
    const expirationDate = localStorage.getItem("expiration");
    const userId = localStorage.getItem("userId");
    const userType = localStorage.getItem("userType");
    if(!token || !expirationDate){
      return;
    }
    return {
      token: token,
      expirationDate: new Date(expirationDate),
      userId: userId,
      userType: userType
    }
  }

  getUserId(){
    return localStorage.getItem("userId");
  }

  getUserType(){
    return localStorage.getItem("userType");
  }
}
