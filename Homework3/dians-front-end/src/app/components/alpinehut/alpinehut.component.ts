import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ConfigService } from 'src/app/config/config.service';
import { AlpineHut } from 'src/app/alpinehut';

@Component({
  selector: 'app-alpinehut',
  templateUrl: './alpinehut.component.html',
  styleUrls: ['./alpinehut.component.css']
})
export class AlpinehutComponent implements OnInit{
  public alpinehuts:AlpineHut[] | undefined;
  filterBy;
  dropDownResult;
  showNoResult;


  title(title: any) {
    throw new Error('Method not implemented.');
  }


  constructor(private configService:ConfigService){}
  ngOnInit(): void {
    this.getHuts();
  }



  addHut(){

  }
  deleteHut(){

  }
  public getHuts(): void {
  
    this.configService.getHuts().subscribe(
      
      (response: AlpineHut[]) => {
        this.alpinehuts = response;
        console.log(this.alpinehuts);
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
      this.configService.getHuts().subscribe(
      
        (response: AlpineHut[]) => {
          this.alpinehuts = response;
          console.log(this.alpinehuts);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
        
      );
      if(this.alpinehuts.length==0){
        this.showNoResult=true;
      }else{
        this.showNoResult=false;
      }
      // ako e selektirano da bara po city
    }else if(this.dropDownResult==='city'){
      console.log("Vtor if")
    this.configService.getByCityHut(this.filterBy).subscribe(
      (response: AlpineHut[]) => {
        this.alpinehuts = response;
        console.log(this.alpinehuts);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
    this.showNoResult=false;
    // ako e selektirano da bara po ime
    }else if(this.dropDownResult==='name'){
      console.log("Tret elif")
      this.configService.getByNameHut(this.filterBy).subscribe(
        (response:AlpineHut[])=>{
          this.alpinehuts=response;
        },
        (error:HttpErrorResponse)=>{
          alert(error.message);
        }
        )
      
    //ako nema selektirano bara default po ime
    }else{
      console.log("pet elif")

      this.configService.getByNameHut(this.filterBy).subscribe(
        (response:AlpineHut[])=>{
          this.alpinehuts=response;
        },
        (error:HttpErrorResponse)=>{
          alert(error.message);
        }
        )
    }
    
  }
  deleteH(name:number){
    console.log("Test")
    console.log(name)
    this.configService.deleteHut(name);
  }


}