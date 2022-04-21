import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  profile : any= []

  constructor (private _adminService: AdminService) { }

  ngOnInit(){
    this._adminService.getProducts()
    .subscribe(
      res => this.profile = res,
      err => console.log(err)
    )
  }

}
