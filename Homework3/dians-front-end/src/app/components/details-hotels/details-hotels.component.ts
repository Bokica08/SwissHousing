import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConfigService } from 'src/app/config/config.service';
import { Hotel } from '../adding-hotels/adding-hotels.model';
import { ListReview } from 'src/app/list-reviews.model';


@Component({
  selector: 'app-details-hotels',
  templateUrl: './details-hotels.component.html',
  styleUrls: ['./details-hotels.component.css']
})
export class DetailsHotelsComponent implements OnInit{
  public reviews:ListReview[] | undefined;
  public avg:any | undefined;
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
    this.getReviews();
    this.configService.getAvgGrade(this.id).subscribe(
      res=>{
        this.avg=res;
        console.log(this.avg);
      }
    );
  }

    addReview(id:string)
    {
      console.log(id);
      window.location.href = "http://localhost:4200/review/add/"+id+"?type=hotel-details";
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
