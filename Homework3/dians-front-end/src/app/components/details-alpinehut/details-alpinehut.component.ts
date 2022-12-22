import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConfigService } from 'src/app/config/config.service';
import { Hut } from '../adding-huts/adding-huts.model';

@Component({
  selector: 'app-details-alpinehut',
  templateUrl: './details-alpinehut.component.html',
  styleUrls: ['./details-alpinehut.component.css']
})
export class DetailsAlpinehutComponent implements OnInit{
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
}
