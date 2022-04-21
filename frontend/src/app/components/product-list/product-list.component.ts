import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Product } from "src/app/models/product";
import { CartService } from "src/app/services/cart.service";
import { ProductService } from "src/app/services/productm.service";
import { SearchService } from "src/app/services/search.service";

@Component({
  selector: "app-product-list",
  // templateUrl: './product-list.component.html',
  //templateUrl: "./product-list-table.component.html",
  templateUrl: "./product-list-grid.component.html",
  styleUrls: ["./product-list.component.css"],
})
export class ProductListComponent implements OnInit {
  products!: Product[];
  currentCategoryId!: number;
  searchKey: string = "";

  constructor(private productService: ProductService, private route: ActivatedRoute, 
              private cartService : CartService, private searchService: SearchService) { }

  ngOnInit()
   {
     this.route.paramMap.subscribe(() => {
      this.listProducts();
     })
    
  }

  // listProducts() {
  //   this.productService.getProductList().subscribe((data) => {
  //     this.products = data;
  //   });
  // }
  listProducts() {
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');

    if (hasCategoryId) {
      // get the "id" param string. convert string to a number using the "+" symbol
      //this.currentCategoryId = +this.route.snapshot.paramMap.get('id');
      this.currentCategoryId = this.route.snapshot.params['id'];
    }
    else {
      // not category id available ... default to category id 1
      this.currentCategoryId = 1;
    }
    this.productService.getProductList(this.currentCategoryId).subscribe((data) => {
      this.products = data;
    });

    this.cartService.search.subscribe((val: any) => {
      this.searchKey = val;
    })
  }

  addtocart(item: any){
    this.cartService.addtoCart(item);
  }

}
