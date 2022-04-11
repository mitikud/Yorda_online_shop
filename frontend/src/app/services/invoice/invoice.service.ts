import {Injectable} from '@angular/core';
import {ErrorHandler} from "../../shared/error-handler";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import {Invoice} from "../../models/invoice";


@Injectable({
  providedIn: 'root'
})
export class InvoiceService {
  private invoiceUrl = `http://localhost:3000/invoices`;
  private errorHandler: ErrorHandler = new ErrorHandler();

  constructor(private http: HttpClient) {
  }

  getUserInvoice(id: number): Observable<Invoice> {
    
      return this.http.get<Invoice>(`${this.invoiceUrl}/${id}`).pipe(
        catchError((error: any)=>{
          return throwError(this.errorHandler.handleError(error))
        })
      )
  }
}