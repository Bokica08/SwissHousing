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
import { AddingGuestshousesComponent } from './components/adding-guestshouses/adding-guestshouses.component';
import { EditingGuesthousesComponent } from './components/editing-guesthouses/editing-guesthouses.component';
import { AddingHotelsComponent } from './components/adding-hotels/adding-hotels.component';
import { AddingCampsComponent } from './components/adding-camps/adding-camps.component';
import { AddingHutsComponent } from './components/adding-huts/adding-huts.component';
import { EditingCampsComponent } from './components/editing-camps/editing-camps.component';
import { EditingHotelsComponent } from './components/editing-hotels/editing-hotels.component';
import { EditingHutsComponent } from './components/editing-huts/editing-huts.component';
import { DetailsAlpinehutComponent } from './components/details-alpinehut/details-alpinehut.component';
import { DetailsGuesthousesComponent } from './components/details-guesthouses/details-guesthouses.component';
import { DetailsCampsComponent } from './components/details-camps/details-camps.component';
import { DetailsHotelsComponent } from './components/details-hotels/details-hotels.component';
import { httpInterceptorProviders } from './_helpers/http.interceptor';
import { ApproveAdminComponent } from './components/approve-admin/approve-admin.component';
import { ViewFavoritesComponent } from './components/view-favorites/view-favorites/view-favorites.component';
import { ViewVisitedComponent } from './components/view-visited/view-visited/view-visited.component';
import { ReviewsComponent } from './components/reviews/reviews.component';
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
    LoginComponent,
    AddingGuestshousesComponent,
    EditingGuesthousesComponent,
    AddingHotelsComponent,
    AddingCampsComponent,
    AddingHutsComponent,
    EditingCampsComponent,
    EditingHotelsComponent,
    EditingHutsComponent,
    DetailsAlpinehutComponent,
    DetailsGuesthousesComponent,
    DetailsCampsComponent,
    DetailsHotelsComponent,
    ApproveAdminComponent,
    ViewFavoritesComponent,
    ViewVisitedComponent,
    ReviewsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ConfigService, httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }