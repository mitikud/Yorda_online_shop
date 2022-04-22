import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private tokenData: string = '';
  role: string = '';

  loginUserData : any = {}
  isLoading: boolean = false;  
  constructor(public authService: AuthService, private _router: Router) { }

  onLogin(form: NgForm){
    this.isLoading = true;
    if(!form.valid){
      return;
    }
    this.authService.login(form.value.email, form.value.password)

  }
  

  private saveAuthData(token: string, role: string){
    localStorage.setItem('token', token);
    localStorage.setItem('role', role)
  }

  ngOnInit(): void {
  }

}
