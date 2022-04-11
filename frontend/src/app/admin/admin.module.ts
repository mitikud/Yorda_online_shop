import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ManageCategiriesComponent } from './components/manage-categiries/manage-categiries.component';
import { ManageOrdersComponent } from './components/manage-orders/manage-orders.component';
import { ManageUsersComponent } from './components/manage-users/manage-users.component';



@NgModule({
  declarations: [ManageCategiriesComponent, ManageOrdersComponent, ManageUsersComponent],
  imports: [
    CommonModule
  ]
})
export class AdminModule { }
