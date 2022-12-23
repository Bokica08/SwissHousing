import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddingGuestshousesComponent } from './components/adding-guestshouses/adding-guestshouses.component';
import { AddingHotelsComponent } from './components/adding-hotels/adding-hotels.component';
import { AddingCampsComponent } from './components/adding-camps/adding-camps.component';
import { AddingHutsComponent } from './components/adding-huts/adding-huts.component';
import { AlpinehutComponent } from './components/alpinehut/alpinehut.component';
import { CampsiteComponent } from './components/campsite/campsite.component';
import { EditingGuesthousesComponent } from './components/editing-guesthouses/editing-guesthouses.component';
import { GuesthouseComponent } from './components/guesthouse/guesthouse.component';
import { HomeComponent } from './components/home/home.component';
import { ListComponent } from './components/list/list.component';
import { LoginComponent } from './components/login/login.component';
import { MapComponentComponent } from './components/map-component/map-component.component';
import { SignupComponent } from './components/signup/signup.component';
import {dataResolverServiceHotel,dataResolverServiceCamp, dataResolverServiceHouse, dataResolverServiceHut } from './resolver/dataResolverService';
import { EditingCampsComponent } from './components/editing-camps/editing-camps.component';
import { EditingHotelsComponent } from './components/editing-hotels/editing-hotels.component';
import { EditingHutsComponent } from './components/editing-huts/editing-huts.component';
import { DetailsAlpinehutComponent } from './components/details-alpinehut/details-alpinehut.component';
import { DetailsGuesthousesComponent } from './components/details-guesthouses/details-guesthouses.component';
import { DetailsCampsComponent } from './components/details-camps/details-camps.component';
import { DetailsHotelsComponent } from './components/details-hotels/details-hotels.component';

const routes: Routes = [
  {
    path: 'map', component: MapComponentComponent,resolve:{data:dataResolverServiceHotel,data2:dataResolverServiceHut,
      data3:dataResolverServiceCamp,data4:dataResolverServiceHouse}
  },
  {
    path: 'hotels', component: ListComponent
  },
  {
    path:'home',component:HomeComponent
  },
  {
    path:'huts',component:AlpinehutComponent
  },
  {
    path:'guesthouses',component:GuesthouseComponent
  },
  {
    path:'campsites',component:CampsiteComponent
  },
  {
    path:'register',component:SignupComponent
  },
  {
    path:'login',component:LoginComponent
  },
  {
    path:'add-guesth',component:AddingGuestshousesComponent
  },
  {
    path:'add-hotel',component:AddingHotelsComponent
  },
  {
    path:'add-camp',component:AddingCampsComponent
  },
  {
    path:'add-hut',component:AddingHutsComponent
  },
  {
    path:'edit-guesth/:id',component:EditingGuesthousesComponent
  },
  {
    path:'edit-camp/:id',component:EditingCampsComponent
  },
  {
    path:'edit-hotel/:id',component:EditingHotelsComponent
  },
  {
    path:'edit-hut/:id',component:EditingHutsComponent
  },
  {
    path:'hut-details/:id',component:DetailsAlpinehutComponent
  },
  {
    path:'house-details/:id',component:DetailsGuesthousesComponent
  },
  {
    path:'camp-details/:id',component:DetailsCampsComponent
  },
  {
    path:'hotel-details/:id',component:DetailsHotelsComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
