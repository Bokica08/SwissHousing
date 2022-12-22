import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConfigService } from 'src/app/config/config.service';
import { Guest } from '../adding-guestshouses/adding-guesthouses.model';

@Component({
  selector: 'app-details-guesthouses',
  templateUrl: './details-guesthouses.component.html',
  styleUrls: ['./details-guesthouses.component.css']
})
export class DetailsGuesthousesComponent implements OnInit{
  guest=new Guest();
  id:string
  constructor(private httpClient:HttpClient,private route: ActivatedRoute,private configService:ConfigService){}
  ngOnInit(): void {
    this.id = (this.route.snapshot.paramMap.get('id'));
    console.log(this.id);
    this.httpClient.get<Guest>("http://localhost:8080/guesthouse/"+this.id).subscribe(
      
      (response: Guest) => {
        this.guest = response;
        console.log(this.guest);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      
      
    );
      }

}
