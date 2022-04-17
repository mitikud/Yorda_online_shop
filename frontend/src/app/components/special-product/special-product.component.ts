import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-special-product',
  templateUrl: './special-product.component.html',
  styleUrls: ['./special-product.component.css']
})
export class SpecialProductComponent implements OnInit {

  specialProducts : any= []
  constructor(private _productService: ProductService,
              private _router: Router) { }

  ngOnInit(): void {
    this._productService.getSpecial()
    .subscribe(
      res => this.specialProducts = res,
      err => {
        if(err instanceof HttpErrorResponse){
          if(err.status === 401)
          this._router.navigate(['auth/login'])
        }
      }
    )
  }

}
