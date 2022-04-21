/*The following code done by Mitiku and Aboneh */

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from "src/app/services/productm.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  allproducts!: Product[];
  searchKey: string = "";
  //currentCategoryId!: number;

  constructor(private productService: ProductService, private route: ActivatedRoute,
    private cartService : CartService) { }

  ngOnInit()
   {
     this.route.paramMap.subscribe(() => {
      this.listAllProducts();
     })
    
  }

  listAllProducts() {
    this.productService.getAllProductList().subscribe((data) => {
      this.allproducts = data;
    });
    this.cartService.search.subscribe((val: any) => {
      this.searchKey = val;
    })
  }

  /*The following code done by Aboneh */
  addtocart(item: any){
    this.cartService.addtoCart(item);
  }
  
}

