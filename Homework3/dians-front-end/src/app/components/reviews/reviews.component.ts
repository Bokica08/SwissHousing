import { Component, OnInit } from '@angular/core';
import {Review} from './review.model'
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-adding-huts',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit{
  review=new Review()
  constructor(private httpClient:HttpClient, private route: ActivatedRoute){}
  ngOnInit(): void {
  }
submit()
{
  console.log(this.review);
  this.review.locationId=(Number)(this.route.snapshot.paramMap.get('id'))
  console.log(this.review);
  this.httpClient.post<any>("http://localhost:8080/review/add",this.review)
.subscribe(res=>{
  console.log(this.review);
  window.location.href="/"+(this.route.snapshot.queryParamMap.get('type'))+"/"+this.review.locationId;
})
}
}