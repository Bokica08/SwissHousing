import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConfigService } from 'src/app/config/config.service';
import {Hut} from '../adding-huts/adding-huts.model'


@Component({
  selector: 'app-editing-huts',
  templateUrl: './editing-huts.component.html',
  styleUrls: ['./editing-huts.component.css']
})
export class EditingHutsComponent implements OnInit{
  hut=new Hut();
  id:string
  constructor(private httpClient:HttpClient,private route: ActivatedRoute,private configService:ConfigService){}
  ngOnInit(): void {
    this.id = (this.route.snapshot.paramMap.get('id'));
    console.log(this.id);
    this.httpClient.get<Hut>("http://localhost:8080/alpinehut/"+this.id).subscribe(
      
      (response: Hut) => {
        this.hut = response;
        console.log(this.hut);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      
    );
      }

submit()
{
  console.log(this.hut);
  this.httpClient.post<any>("http://localhost:8080/alpinehut/edit/"+this.id,this.hut)
.subscribe(res=>{
  console.log(this.hut);
})
window.location.href = "http://localhost:4200/huts";
}
}
