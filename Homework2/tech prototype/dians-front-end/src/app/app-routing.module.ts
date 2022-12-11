import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ListComponent } from './components/list/list.component';
import { MapComponentComponent } from './components/map-component/map-component.component';
import { dataResolverService } from './resolver/dataResolverService';

const routes: Routes = [
  {
    path: 'map', component: MapComponentComponent,resolve:{data:dataResolverService}
  },
  {
    path: 'list', component: ListComponent
  },
  {
    path:'home',component:HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
