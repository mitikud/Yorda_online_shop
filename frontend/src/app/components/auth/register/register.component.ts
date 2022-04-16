import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userType: string = "";
  userTypes: string[] = ['vendor', 'customer'];
  isLoading: boolean = false;

  registerUserData :any= {}
  constructor(public authService: AuthService) { }

  ngOnInit(): void {
  }

  onSignup(form: NgForm){
    if(form.invalid){
      return;
    }
    this.isLoading = true;
    this.authService.createUser(

      form.value.firstName,
      form.value.lastName,
      form.value.email,
      form.value.password,
      form.value.roles
    ).subscribe(
      res => console.log(res),
      err => console.log(err)
    )
    
  }
  

}
