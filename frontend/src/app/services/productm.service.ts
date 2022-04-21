import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Product } from "../models/product"
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { CartService } from "./cart.service";

@Injectable({
  providedIn: "root",
})

export class ProductService {

  private baseUrl = 'http://localhost:8080/api/products';

  constructor(private httpClient: HttpClient, private cartService : CartService) { }

  getProductList(theCategoryId: number): Observable<Product[]> {

    // need to build URL based on category id 
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`;

    return this.httpClient.get<GetResponse>(searchUrl).pipe(
      map(response => response._embedded.products)
    );
  }

  getAllProductList(): Observable<Product[]> {
    return this.httpClient
      .get<GetResponse>(this.baseUrl)
      .pipe(map((response) => response._embedded.products));
  }

  addtocart(item: any){
    this.cartService.addtoCart(item);
  }

}


// export class ProductService {
//   private baseUrl = "http://localhost:8080/api/products?size=100";

//   constructor(private httpClient: HttpClient) { }

  

//   getProductList(theCategoryId: number): Observable<Product[]> {
//     const url = `${this.baseUrl}/search/findByCathegoryId?id=${theCategoryId}/`
//     return this.httpClient
//       .get<GetResponse>(this.baseUrl)
//       .pipe(map((response) => response._embedded.products));
//   }
// }



interface GetResponse {
  _embedded: {
    products: Product[];
  };
}
