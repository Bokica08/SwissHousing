import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ConfigService } from 'src/app/config/config.service';
import { GuestHouse } from 'src/app/guest-house.model';

@Component({
  selector: 'app-guesthouse',
  templateUrl: './guesthouse.component.html',
  styleUrls: ['./guesthouse.component.css']
})
export class GuesthouseComponent implements OnInit{
  public guesthouses:GuestHouse[] | undefined;
  filterBy;
  dropDownResult;
  showNoResult;


  title(title: any) {
    throw new Error('Method not implemented.');
  }


  constructor(private configService:ConfigService){}
  ngOnInit(): void {
    this.getHouses();
  }



  addHouse(){

  }
  deleteHouse(){

  }
  public getHouses(): void {
  
    this.configService.getHouses().subscribe(
      
      (response: GuestHouse[]) => {
        this.guesthouses = response;
        console.log(this.guesthouses);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      
    );
  }
  filter(){
    console.log("hey")
    console.log(this.filterBy!=null)
    console.log(this.dropDownResult);
    // ako e 
    if(this.filterBy==null || this.filterBy.length==0){
      console.log("Prv if")
      this.configService.getHouses().subscribe(
      
        (response: GuestHouse[]) => {
          this.guesthouses = response;
          console.log(this.guesthouses);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
        
      );
      if(this.guesthouses.length==0){
        this.showNoResult=true;
      }else{
        this.showNoResult=false;
      }
      // ako e selektirano da bara po city
    }else if(this.dropDownResult==='city'){
      console.log("Vtor if")
    this.configService.getByCityHouse(this.filterBy).subscribe(
      (response: GuestHouse[]) => {
        this.guesthouses = response;
        console.log(this.guesthouses);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
    this.showNoResult=false;
    // ako e selektirano da bara po ime
    }else if(this.dropDownResult==='name'){
      console.log("Tret elif")
      this.configService.getByNameHouse(this.filterBy).subscribe(
        (response:GuestHouse[])=>{
          this.guesthouses=response;
        },
        (error:HttpErrorResponse)=>{
          alert(error.message);
        }
        )
      
    //ako nema selektirano bara default po ime
    }else{
      console.log("pet elif")

      this.configService.getByNameHouse(this.filterBy).subscribe(
        (response:GuestHouse[])=>{
          this.guesthouses=response;
        },
        (error:HttpErrorResponse)=>{
          alert(error.message);
        }
        )
    }
    
  }
  deleteGHouse(id:number){
    this.configService.deleteHouse(id).subscribe(); 
    window.location.reload()
  }

}
