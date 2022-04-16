import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-special-product',
  templateUrl: './special-product.component.html',
  styleUrls: ['./special-product.component.css']
})
export class SpecialProductComponent implements OnInit {

  specialProducts : any= []
  constructor(private _productService: ProductService) { }

  ngOnInit(): void {
    this._productService.getSpecial()
    .subscribe(
      res => this.specialProducts = res,
      err => console.log(err)
    )
  }

}
