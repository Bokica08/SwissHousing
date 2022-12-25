import { Component, OnInit } from '@angular/core';
import {Camp} from './adding-camps.model'
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-adding-camps',
  templateUrl: './adding-camps.component.html',
  styleUrls: ['./adding-camps.component.css']
})
export class AddingCampsComponent implements OnInit {
  camp=new Camp()
  constructor(private httpClient:HttpClient){}
  ngOnInit(): void {
  }
submit()
{
  console.log(this.camp);
  this.httpClient.post<any>("http://localhost:8080/campsite/add",this.camp)
.subscribe(res=>{
  console.log(this.camp);
  window.location.href="/camps"
  
})
}
}
