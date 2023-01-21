import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConfigService } from 'src/app/config/config.service';
import { Guest } from '../adding-guestshouses/adding-guesthouses.model';
import { ListReview } from 'src/app/list-reviews.model';


@Component({
  selector: 'app-details-guesthouses',
  templateUrl: './details-guesthouses.component.html',
  styleUrls: ['./details-guesthouses.component.css']
})
export class DetailsGuesthousesComponent implements OnInit{
  guest=new Guest();
  public reviews:ListReview[] | undefined;
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
    this.getReviews();
  }

    addReview(id:string)
    {
      console.log(id);
      window.location.href = "http://localhost:4200/review/add/"+id+"?type=house-details";
    }

    public getReviews(): void {
  
      this.configService.getReviewsByLocation((Number)(this.id)).subscribe(
        
        (response: ListReview[]) => {
          this.reviews = response;
          console.log(this.reviews);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
        
      );
    }

}
