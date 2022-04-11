import { HttpClient, HttpParams } from '@angular/common/http';
import { ErrorHandler, Injectable } from '@angular/core';
import { Router } from 'express';
import { Observable, throwError } from 'rxjs';
import { Product } from 'src/app/models/product';
import { AuthService } from '../auth/auth.service';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private url = `http://localhost:3000/products`;
  private errorHandler: ErrorHandler = new ErrorHandler();

  constructor(private http: HttpClient, private authService: AuthService,
              private router: Router) {
  }

  getProducts(): Observable<Product[]> {

      return this.http.get<Product[]>(this.url).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

  getProductById(id: number): Observable<Product> {
    
      const urlById = `${this.url}/${id}`;
      return this.http.get<Product>(urlById).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

  insertToCart(productId: number, cartItemId: number, cartQuantity: number): Observable<Product> {
    
      const params = new HttpParams().set('quantity', cartQuantity.toString());
      const urlById = `${this.url}/${productId}/addtocart/${cartItemId}`;
      return this.http.post<Product>(urlById, null, {
        params
      }).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

  updateProductCartQuantity(productId: number, cartQuantity: number): Observable<void> {
    
      const params = new HttpParams().set('cartQuantity', cartQuantity.toString());
      const urlById = `${this.url}/${productId}/update-quantity`;
      return this.http.patch<void>(urlById, null, {
        params
      }).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }
}
 


