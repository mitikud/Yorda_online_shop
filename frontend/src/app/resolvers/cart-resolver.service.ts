import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { Cart } from '../models/cart';
import { AuthService } from '../services/auth/auth.service';
import { CartService } from '../services/cart/cart.service';
import { ErrorHandler } from 'src/app/shared/error-handler';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CartResolverService implements Resolve<Cart>{

  constructor(private cartService: CartService, private authService: AuthService) { }
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Cart> | any{
    if(this.authService.profile){
      return this.cartService.getCart(this.authService.profile.cartId);
    }
  }
}
