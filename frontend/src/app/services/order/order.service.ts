import {Injectable} from '@angular/core';
import {ErrorHandler} from "../../shared/error-handler";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import {Order} from "../../models/order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private errorHandler: ErrorHandler = new ErrorHandler();
  private orderUrl = 'http://localhost:3000/orders/user-orders';

  constructor(private http: HttpClient) {
  }

  // for admin staff
  getOrders(): Observable<Order[]> {
    
      return this.http.get<Order[]>(this.orderUrl).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }
  // for user staff
  getUserOrder(orderId: number): Observable<Order> {
    
      return this.http.get<Order>(`${this.orderUrl}/${orderId}`).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }
}