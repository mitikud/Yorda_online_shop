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


const routes: Routes = [
  {
    path: '',
    canActivate: [UserAuthGuard],
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent,
        canActivate: [UserAuthGuard]
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
            canActivate: [UserAuthGuard]
          },
          {
            path: 'manage-users',
            component: ManageUsersComponent,
            // resolve: {
            //   allUsers: UserResolverService
            // },
            canActivate: [UserAuthGuard]
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
