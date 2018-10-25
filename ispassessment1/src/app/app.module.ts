import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';


import { AppComponent } from './app.component';
import { PackagedetailsComponent } from './packagedetails/packagedetails.component';
import { OrderformComponent } from './orderform/orderform.component';
import { SuccesspageComponent } from './successpage/successpage.component';


const paths: Routes = [
  { path: '', component: PackagedetailsComponent },
  { path: 'listplans', component: PackagedetailsComponent },
  { path: 'addOrder', component: OrderformComponent },
  { path: 'addOrder/:title', component: OrderformComponent },
  { path: 'successOrder', component: SuccesspageComponent },
  { path: 'successOrder/:orderId', component: SuccesspageComponent }
];
@NgModule({
  declarations: [
    AppComponent,
    PackagedetailsComponent,
    OrderformComponent,
    SuccesspageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,

    RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
