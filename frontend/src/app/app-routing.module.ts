import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './admin/components/dashboard/dashboard.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { CartComponent } from './components/cart/cart.component';
import { HomeComponent } from './components/home/home.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductComponent } from './components/product/product.component';
import { UserAuthGuard } from './guards/user-auth.guard';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'products',
    component: ProductComponent
  },
  {path: 'category/:id', 
  component: ProductListComponent},
  {path: 'category',
   component: ProductListComponent},
  
  {
    path: 'cart',
    component: CartComponent
  },
  {
    path : 'admin',
    component: DashboardComponent
  },
  {
    path: 'auth',
    children: [
      {
      path: 'login',
      component: LoginComponent
      },
      {
        path: 'register',
        component: RegisterComponent
        },
    ]
  },
  {
    path: '',
    redirectTo: 'products',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
