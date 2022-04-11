import { HttpClient } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';
import { Cart } from 'src/app/models/cart';
import { CartItem } from 'src/app/models/cart-item';
import { Profile } from 'src/app/models/profile';
import { User } from 'src/app/models/user';
import { UserData } from 'src/app/models/user-data';
import { ErrorHandler } from 'src/app/shared/error-handler';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  getToken() {
    throw new Error('Method not implemented.');
  }

  constructor(private http: HttpClient, private router: Router, private route:ActivatedRoute) { }

  _registerUrl = `http://localhost:3000/auth/register`;
  _loginUrl = `http://localhost:3000/auth/login`;
  _userUrl = `http://localhost:3000/auth/current-user`;
  _profileUrl = `http://localhost:3000/profile`;
  private _usersURL = `http://localhost:3000/auth/system-users`;
  private _userDataURL = `http://localhost:3000/auth/user-main-data`;
  private imageChangeUrl = `http://localhost:3000/profile/userprofile/changeprofileimage`;
  private newImageUrl = `http://localhost:3000/profile/userprofile/setprofileimage`;
  private contactUrl = `http://localhost:3000/contacts/new-mail`;
  private errorHandler: ErrorHandler = new ErrorHandler();

  public username: string | undefined;
  public cart: Cart | undefined;
  public cartItem: CartItem | undefined;
  public profile: Profile | undefined ;
  public currentUser: User | undefined;

  register(data: any): Observable<any>{
  
      return this.http.post<any>(this._registerUrl, data).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

  pUserData() {
    if (this.isLoggedIn()) {
      this.prepareUserData().subscribe((uData: UserData) => {
        this.profile = uData.profile;
        this.username = `${uData.profile?.firstname} ${uData.profile?.lastname}`;
        this.cart = uData.cart;
        this.cartItem = uData.cartItem;
      });
      this.getCurrentUser().subscribe(resUser => {
        this.currentUser = resUser;
      });
    }
  }
  
  
  
  login(user: any): Observable<any> {
  
      return this.http.post<any>(this._loginUrl, user).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

  userLogout() {
    localStorage.removeItem('token');
    this.router.navigate(['/home']);
  }

  
  getUserData(): Observable<UserData> {
    
      return this.http.get<any>(this._userDataURL).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

  prepareUserData(): Observable<UserData> {
    
      return this.http.get<UserData>(this._userDataURL).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

  // messageContact(messageForm: any): Observable<void> {
    
  //     return this.http.post<void>(this.contactUrl, messageForm).pipe(
  //       catchError((error: any)=>{
  //         return throwError(this.errorHandler.handleError(error))
  //       })
  //     )
  // }

  getCurrentUser(): Observable<any> {
    
      return this.http.get<any>(this._userUrl).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

  // getSystemUsers(): Observable<User[]> {
   
  //     return this.http.get<User[]>(this._userUrl).pipe(
  //       catchError((error: any)=>{
  //         return throwError(this.errorHandler.handleError(error))
  //       })
  //     )
  // }

  // getToken() {
  //   return localStorage.getItem('token');
  // }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  getUserProfile(): Observable<Profile> {
    
      return this.http.get<Profile>(this._profileUrl).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

}
