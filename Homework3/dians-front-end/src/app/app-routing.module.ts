import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddingGuestshousesComponent } from './components/adding-guestshouses/adding-guestshouses.component';
import { AlpinehutComponent } from './components/alpinehut/alpinehut.component';
import { CampsiteComponent } from './components/campsite/campsite.component';
import { EditingGuesthousesComponent } from './components/editing-guesthouses/editing-guesthouses.component';
import { GuesthouseComponent } from './components/guesthouse/guesthouse.component';
import { HomeComponent } from './components/home/home.component';
import { ListComponent } from './components/list/list.component';
import { LoginComponent } from './components/login/login.component';
import { MapComponentComponent } from './components/map-component/map-component.component';
import { SignupComponent } from './components/signup/signup.component';
import { dataResolverService, dataResolverServiceCamp, dataResolverServiceHouse, dataResolverServiceHut } from './resolver/dataResolverService';

const routes: Routes = [
  {
    path: 'map', component: MapComponentComponent,resolve:{data:dataResolverService,data2:dataResolverServiceHut,
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
    path:'edit-guesth/:id',component:EditingGuesthousesComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
