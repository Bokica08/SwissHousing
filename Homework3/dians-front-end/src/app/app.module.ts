import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './components/app-component/app.component';
import { ConfigService } from './config/config.service';
import { HttpClientModule } from '@angular/common/http';import { FormsModule } from '@angular/forms';
import { MapComponentComponent } from './components/map-component/map-component.component';
import { AppRoutingModule } from './app-routing.module';
import { ListComponent } from './components/list/list.component';
import { HomeComponent } from './components/home/home.component';
import { AlpinehutComponent } from './components/alpinehut/alpinehut.component';
import { GuesthouseComponent } from './components/guesthouse/guesthouse.component';
import { CampsiteComponent } from './components/campsite/campsite.component';

@NgModule({
  declarations: [
    AppComponent,
    MapComponentComponent,
    ListComponent,
    HomeComponent,
    AlpinehutComponent,
    GuesthouseComponent,
    CampsiteComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [ConfigService],
  bootstrap: [AppComponent]
})
export class AppModule { }