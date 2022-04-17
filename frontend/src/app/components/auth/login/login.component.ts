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

  loginUserData : any = {}
  isLoading: boolean = false;  
  constructor(public authService: AuthService, private _router: Router) { }

  onLogin(form: NgForm){
    this.isLoading = true;
    if(!form.valid){
      return;
    }
    this.authService.login(this.loginUserData)
    .subscribe(
      res => {
        console.log(res)
        localStorage.setItem('token',res.token)
        this._router.navigate(['/special'])
      },
      err => console.log(err)
    )

  }
  ngOnInit(): void {
  }

}
