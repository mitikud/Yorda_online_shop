import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ManageCategiriesComponent } from './components/manage-categiries/manage-categiries.component';
import { ManageUsersComponent } from './components/manage-users/manage-users.component';
import { Router } from 'express';
import { CategoryResolverService } from '../resolvers/category-resolver.service';
import { UserAuthGuard } from '../guards/user-auth.guard';
import { UserResolverService } from '../resolvers/user-resolver.service';
import { AdminAuthGuard } from '../guards/admin-auth.guard';


const routes: Routes = [
  {
    path: '',
    canActivate: [AdminAuthGuard],
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent,
        canActivate: [AdminAuthGuard]
      },
      {
        path: 'management',
        children: [
          {
            path: 'manage-categories',
            component: ManageCategiriesComponent,
            // resolve: {
            //   categories: CategoryResolverService
            // },
            canActivate: [AdminAuthGuard]
          },
          {
            path: 'manage-users',
            component: ManageUsersComponent,
            // resolve: {
            //   allUsers: UserResolverService
            // },
            canActivate: [AdminAuthGuard]
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
