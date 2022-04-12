import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { DashboardComponent } from './admin/components/dashboard/dashboard.component';
import { ManageCategiriesComponent } from './admin/components/manage-categiries/manage-categiries.component';
import { ManageOrdersComponent } from './admin/components/manage-orders/manage-orders.component';
import { ManageUsersComponent } from './admin/components/manage-users/manage-users.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { CartComponent } from './components/cart/cart.component';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { CategoryDetailsComponent } from './components/category-details/category-details.component';
import { ContactComponent } from './components/contact/contact.component';
import { OrderComponent } from './components/order/order.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProductFilterPipe } from './pipes/product-filter.pipe';
import { AlertComponent } from './shared/alert/alert.component';
import { ApplicationErrorComponent } from './shared/application-error/application-error.component';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { ResourceNotFoundComponent } from './shared/resource-not-found/resource-not-found.component';
import { MaterialModule } from './shared/material/material.module';
import { AdminModule } from './admin/admin.module';
import { NgxModule } from './shared/ngx/ngx.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FilesModule } from './shared/files/files.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import { AccordionModule } from 'ngx-bootstrap/accordion';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { ModalModule } from 'ngx-bootstrap/modal';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import { PopoverModule } from 'ngx-bootstrap/popover';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthService } from './services/auth/auth.service';
import { TokenInterceptorService } from './services/auth/token-interceptor.service';
import { ErrorInterceptorService } from './services/auth/error-interceptor.service';
import { ProfileComponent } from './components/profile/profile.component';
import { DashboardComponent } from './admin/components/dashboard/dashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    CartComponent,
    CategoryListComponent,
    CategoryDetailsComponent,
    ContactComponent,
    OrderComponent,
    ProductListComponent,
    ProductDetailsComponent,
    ProductFilterPipe,
    AlertComponent,
    ApplicationErrorComponent,
    PageNotFoundComponent,
    ResourceNotFoundComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    AdminModule,
    FormsModule,
    ReactiveFormsModule,
    FilesModule,
    HttpClientModule,
    CarouselModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    PopoverModule.forRoot(),
    AccordionModule.forRoot(),
    PaginationModule.forRoot(),
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptorService,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptorService,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
