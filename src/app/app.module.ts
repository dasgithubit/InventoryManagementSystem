import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrderComponent } from './order/order.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductCategoryComponent } from './product-category/product-category.component';
import { CartDetailsComponent } from './cart-details/cart-details.component';
import { CartStatusComponent } from './cart-status/cart-status.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SearchComponent } from './search/search.component';
import { RegistrationComponent } from './registration/registration.component';
import { CustomerRegistrationService } from './customer-registration.service';

@NgModule({
  declarations: [
    AppComponent,
    OrderComponent,
    ProductDetailsComponent,
    ProductCategoryComponent,
    CartDetailsComponent,
    CartStatusComponent,
    PageNotFoundComponent,
    SearchComponent,
    RegistrationComponent
  ],
  imports: [
      BrowserModule,
			AppRoutingModule,
			HttpClientModule, //inserting for RestAPI, import package above
			FormsModule // to insert html forms
  ],
  providers: [CustomerRegistrationService], // need to register service here
  bootstrap: [AppComponent]
  
})
export class AppModule { }
