import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConfigService } from 'src/app/config/config.service';
import {Camp} from '../adding-camps/adding-camps.model'

@Component({
  selector: 'app-editing-camps',
  templateUrl: './editing-camps.component.html',
  styleUrls: ['./editing-camps.component.css']
})
export class EditingCampsComponent implements OnInit {
  camp=new Camp();
  id:string
  constructor(private httpClient:HttpClient,private route: ActivatedRoute,private configService:ConfigService){}
  ngOnInit(): void {
    this.id = (this.route.snapshot.paramMap.get('id'));
    console.log(this.id);
    this.httpClient.get<Camp>("http://localhost:8080/campsite/"+this.id).subscribe(
      
      (response: Camp) => {
        this.camp = response;
        console.log(this.camp);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      
    );
      }

submit()
{
  console.log(this.camp);
  this.httpClient.post<any>("http://localhost:8080/campsite/edit/"+this.id,this.camp)
.subscribe(res=>{
  console.log(this.camp);
})
window.location.href = "http://localhost:4200/campsites";
}

}
