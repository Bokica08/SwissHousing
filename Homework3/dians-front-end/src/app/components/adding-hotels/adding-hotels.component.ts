import { Component, OnInit } from '@angular/core';
import {Hotel} from './adding-hotels.model'
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-adding-hotels',
  templateUrl: './adding-hotels.component.html',
  styleUrls: ['./adding-hotels.component.css']
})
export class AddingHotelsComponent implements OnInit{
  hotel=new Hotel()
  constructor(private httpClient:HttpClient){}
  ngOnInit(): void {
  }
submit()
{
  console.log(this.hotel);
  this.httpClient.post<any>("http://localhost:8080/hotel/add",this.hotel)
.subscribe(res=>{
  console.log(this.hotel);
  
})
}
}
