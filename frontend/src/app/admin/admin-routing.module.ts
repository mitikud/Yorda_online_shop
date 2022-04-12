import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ManageCategiriesComponent } from './components/manage-categiries/manage-categiries.component';
import { ManageUsersComponent } from './components/manage-users/manage-users.component';
import { Router } from 'express';
import { CategoryResolverService } from '../resolvers/category-resolver.service';


const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'management',
        children: [
          {
            path: 'manage-categories',
            component: ManageCategiriesComponent,
            // resolve: {
            //   categories: CategoryResolverService
            // }
          },
          {
            path: 'manage-users',
            component: ManageUsersComponent
          },
        ]
      },
    ]
  },
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AdminRoutingModule { }