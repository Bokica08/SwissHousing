import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConfigService } from 'src/app/config/config.service';
import { Hotel } from '../adding-hotels/adding-hotels.model';

@Component({
  selector: 'app-details-hotels',
  templateUrl: './details-hotels.component.html',
  styleUrls: ['./details-hotels.component.css']
})
export class DetailsHotelsComponent implements OnInit{
  hotel=new Hotel();
  id:string
  constructor(private httpClient:HttpClient,private route: ActivatedRoute,private configService:ConfigService){}
  ngOnInit(): void {
    this.id = (this.route.snapshot.paramMap.get('id'));
    console.log(this.id);
    this.httpClient.get<Hotel>("http://localhost:8080/hotel/"+this.id).subscribe(
      
      (response: Hotel) => {
        this.hotel = response;
        console.log(this.hotel);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      
      
    );
      }
}
