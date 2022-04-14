import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { ErrorHandler } from 'src/app/shared/error-handler';
import { catchError, retry } from 'rxjs/operators';
import { Category } from 'src/app/models/category';
import { Product } from 'src/app/models/product';


@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  getCategories(): Observable<Category[]> {
    throw new Error('Method not implemented.');
  }
//   private categoryUrl = `http://localhost:3000/categories`;

//   constructor(private http: HttpClient) { }

//   private errorHandler: ErrorHandler = new ErrorHandler();

//   getCategories(): Observable<Category[]> {

//       return this.http.get<Category[]>(this.categoryUrl).pipe(
//         catchError((error: any)=>{
//           return throwError(this.errorHandler.handleError(error))
//         })
//       )
//   }

//   getCategoryById(id: number): Observable<Category> {
    
//       const urlOfCategory = `${this.categoryUrl}/${id}`;
//       return this.http.get<Category>(urlOfCategory).pipe(
//         catchError((error: any)=>{
//           return throwError(this.errorHandler.handleError(error))
//         })
//       )
//   }

//   createCategory(createCategoryDto: any): Observable<Category> {
  
//       return this.http.post<Category>(this.categoryUrl, createCategoryDto).pipe(
//         catchError((error: any)=>{
//           return throwError(this.errorHandler.handleError(error))
//         })
//       )
//   }

//   updateCategory(categoryId: number, updateCategoryDto: any): Observable<void> {
    
//       const urlById = `${this.categoryUrl}/${categoryId}`;
//       return this.http.put<void>(urlById, updateCategoryDto).pipe(
//         catchError((error: any)=>{
//           return throwError(this.errorHandler.handleError(error))
//         })
//       )
//   }
//   updateProduct(
//     categoryId: number,
//     productId: number,
//     updateProductDto: any
//   ): Observable<void> {
    
//       const urlOfProductOfCategory = `${this.categoryUrl}/${categoryId}/products/${productId}`;
//       return this.http.put<void>(urlOfProductOfCategory, updateProductDto).pipe(
//         catchError((error: any)=>{
//           return throwError(this.errorHandler.handleError(error))
//         })
//       )
//   }

//   deleteCategory(categoryId: number): Observable<any> {
  
//       const urlOfCategory = `${this.categoryUrl}/${categoryId}`;
//       return this.http.delete<void>(urlOfCategory).pipe(
//         catchError((error: any)=>{
//           return throwError(this.errorHandler.handleError(error))
//         })
//       )
//   }

//   getCategoryProducts(id: number): Observable<Product[]> {
 
//       return this.http.get<Product[]>(`${this.categoryUrl}/products`).pipe(
//         catchError((error: any)=>{
//           return throwError(this.errorHandler.handleError(error))
//         })
//       )
//   }

//   deleteProduct(categoryId: number, productId: number) {
  
//       const urlOfProductOfCategory = `${this.categoryUrl}/${categoryId}/products/${productId}`;
//       return this.http.delete<void>(urlOfProductOfCategory).pipe(
//         catchError((error: any)=>{
//           return throwError(this.errorHandler.handleError(error))
//         })
//       )
//   }

//   addProduct(categoryId: number, createProductDto: any): Observable<void> {
    
//       const urlOfCategory = `${this.categoryUrl}/products`;
//       return this.http.post<void>(urlOfCategory, createProductDto).pipe(
//         catchError((error: any)=>{
//           return throwError(this.errorHandler.handleError(error))
//         })
//       )
// }
}
