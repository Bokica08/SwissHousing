import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlpinehutComponent } from './components/alpinehut/alpinehut.component';
import { CampsiteComponent } from './components/campsite/campsite.component';
import { GuesthouseComponent } from './components/guesthouse/guesthouse.component';
import { HomeComponent } from './components/home/home.component';
import { ListComponent } from './components/list/list.component';
import { MapComponentComponent } from './components/map-component/map-component.component';
import { dataResolverService } from './resolver/dataResolverService';

const routes: Routes = [
  {
    path: 'map', component: MapComponentComponent,resolve:{data:dataResolverService}
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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
