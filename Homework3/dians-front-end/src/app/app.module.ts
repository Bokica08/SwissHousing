import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, } from '@angular/router';
import { AppComponent } from './components/app-component/app.component';
import { ConfigService } from './config/config.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MapComponentComponent } from './components/map-component/map-component.component';
import { AppRoutingModule } from './app-routing.module';
import { ListComponent } from './components/list/list.component';
import { HomeComponent } from './components/home/home.component';
import { AlpinehutComponent } from './components/alpinehut/alpinehut.component';
import { GuesthouseComponent } from './components/guesthouse/guesthouse.component';
import { CampsiteComponent } from './components/campsite/campsite.component';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
const routes:Routes=[


];
@NgModule({
  declarations: [
    AppComponent,
    MapComponentComponent,
    ListComponent,
    HomeComponent,
    AlpinehutComponent,
    GuesthouseComponent,
    CampsiteComponent,
    SignupComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ConfigService],
  bootstrap: [AppComponent]
})
export class AppModule { }