import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConfigService } from 'src/app/config/config.service';
import { ListReview } from 'src/app/list-reviews.model';
import { Hut } from '../adding-huts/adding-huts.model';

@Component({
  selector: 'app-details-alpinehut',
  templateUrl: './details-alpinehut.component.html',
  styleUrls: ['./details-alpinehut.component.css']
})
export class DetailsAlpinehutComponent implements OnInit{
  public reviews:ListReview[] | undefined;
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
    this.getReviews();
      }
    addReview(id:string)
    {
      console.log(id);
      window.location.href = "http://localhost:4200/review/add/"+id+"?type=hut-details";
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
