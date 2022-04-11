import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Cart } from 'src/app/models/cart';
import { CartItem } from 'src/app/models/cart-item';
import { ErrorHandler } from 'src/app/shared/error-handler';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) { 

  }
  private _cartUrl = `http://localhost:300/cart`;
  private _cartItemUrl = `http://localhost:300/cart_Items`;
  private errorHandler: ErrorHandler = new ErrorHandler();

  getCart(id: number): Observable<Cart>{
    
      return this.http.get<Cart>(this._cartUrl).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

  getCartItem(id: number): Observable<CartItem>{
    
    return this.http.get<CartItem>(this._cartItemUrl).pipe(
      catchError((error: any)=>{
        return throwError(this.errorHandler.handleError(error))
      })
    )
  }

  clearCartProducts(cartItemId: number): Observable<CartItem>{
    
      const clearUrl = `${this._cartItemUrl}/${cartItemId}/products/clear-products`
      return this.http.delete<CartItem>(clearUrl).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

  placeOrder(cartItemId: number, productId: number, createOrderDto: any): Observable<void>{
    
      const orderUrl = `${this._cartItemUrl}/${cartItemId}/products/${productId}/placeorder`;
      return this.http.post<void>(orderUrl, createOrderDto).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }

    // checkOut(cartItemId: number, createOrderDto: any): Observable<void>{
      
    //     const ocheckOutUrl = `${this._cartItemUrl}/${cartItemId}/checkOut`;
    //     return this.http.post<void>(ocheckOutUrl, createOrderDto).pipe(
    //       catchError((error: any)=>{
    //         return throwError(this.errorHandler.handleError(error))
    //       })
    //     )
    // }

    // removeFromProduct(cartItemId: number, productId: number): Observable<CartItem>{
    
    //     const removeUrl = `${this._cartItemUrl}/${cartItemId}/products/${productId}/remove-from-cart`
    //     return this.http.delete<CartItem>(removeUrl).pipe(
    //       catchError((error: any)=>{
    //         return throwError(this.errorHandler.handleError(error))
    //       })
    //     )
      
    // }
}
