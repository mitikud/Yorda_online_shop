import { Component } from '@angular/core';
import { AuthService } from './services/auth/auth.service';
import { CartService } from './services/cart.service';
import { SearchService } from './services/search.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'e-commerce';

  constructor(public _authService: AuthService, 
              public _searchSearvice: SearchService,
              public _cartService: CartService){

  }
}
