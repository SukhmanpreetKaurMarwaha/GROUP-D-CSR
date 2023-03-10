import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { MyComponentComponent } from './Component/my-component/my-component.component';
import { UserComponentComponent } from './Component/user-component/user-component.component';
import { HomeComponentComponent } from './Component/home-component/home-component.component';

@NgModule({
  declarations: [
    AppComponent,
    MyComponentComponent,
    UserComponentComponent,
    HomeComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
