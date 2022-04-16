import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products : any= []

  constructor (private _productService: ProductService) { }

  ngOnInit(){
    this._productService.getProducts()
    .subscribe(
      res => this.products = res,
      err => console.log(err)
    )
  }

}
