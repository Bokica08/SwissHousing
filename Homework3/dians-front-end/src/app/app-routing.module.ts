import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlpinehutComponent } from './components/alpinehut/alpinehut.component';
import { CampsiteComponent } from './components/campsite/campsite.component';
import { GuesthouseComponent } from './components/guesthouse/guesthouse.component';
import { HomeComponent } from './components/home/home.component';
import { ListComponent } from './components/list/list.component';
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
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
