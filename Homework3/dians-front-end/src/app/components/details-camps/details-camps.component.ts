import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConfigService } from 'src/app/config/config.service';
import { Camp } from '../adding-camps/adding-camps.model';
import { Hut } from '../adding-huts/adding-huts.model';
import { ListReview } from 'src/app/list-reviews.model';


@Component({
  selector: 'app-details-camps',
  templateUrl: './details-camps.component.html',
  styleUrls: ['./details-camps.component.css']
})
export class DetailsCampsComponent implements OnInit{
  camp=new Camp();
  public reviews:ListReview[] | undefined;
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
    this.getReviews();
      }
    
    addReview(id:string)
    {
      console.log(id);
      window.location.href = "http://localhost:4200/review/add/"+id+"?type=camp-details";
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
