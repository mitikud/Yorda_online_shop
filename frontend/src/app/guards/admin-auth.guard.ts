import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router:Router){}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean  {
      if(this.authService.isLoggedIn() && this.authService.currentUser && this.authService.currentUser.isAdmin){
        return true;
      }else{
        this.router.navigate(['/auth/login'], {
          queryParams: {returnUrl: state.url}
        });
        return false;
      }
  }
  
}
