import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ConfigService } from 'src/app/config/config.service';
import { Employee } from 'src/app/employee';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit{

  public employees:Employee[] | undefined;
  filterBy;
  dropDownResult;
  showNoResult;


  title(title: any) {
    throw new Error('Method not implemented.');
  }


  constructor(private configService:ConfigService){}
  ngOnInit(): void {
    this.getEmployees();
  }



  addEmployee(){
    console.log("he")
    this.configService.addEmployee({
      locationId: null,
      x: 1, y: 1, name: "Gorjan", 
      city: "Skopje", street: "jablanica", houseNumber: "1515", description: "Xavi", imagePath: "https://google.com", website: "facebook.com",
      phoneNumber: "075500000", stars: 5,
      rating: null,
      numOfRatings: 0
    }).subscribe();
  }
  deleteEmployee(){

  }
  public getEmployees(): void {
  
    this.configService.getEmployees().subscribe(
      
      (response: Employee[]) => {
        this.employees = response;
        console.log(this.employees);
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
      this.configService.getEmployees().subscribe(
      
        (response: Employee[]) => {
          this.employees = response;
          console.log(this.employees);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
        
      );
      if(this.employees.length==0){
        this.showNoResult=true;
      }else{
        this.showNoResult=false;
      }
      // ako e selektirano da bara po city
    }else if(this.dropDownResult==='city'){
      console.log("Vtor if")
    this.configService.getByCity(this.filterBy).subscribe(
      (response: Employee[]) => {
        this.employees = response;
        console.log(this.employees);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
    this.showNoResult=false;
    // ako e selektirano da bara po ime
    }else if(this.dropDownResult==='name'){
      console.log("Tret elif")
      this.configService.getByName(this.filterBy).subscribe(
        (response:Employee[])=>{
          this.employees=response;
        },
        (error:HttpErrorResponse)=>{
          alert(error.message);
        }
        )
      
      // ako e selektirano da bara po stars
    }else if(this.dropDownResult==='stars'){
      console.log("Cetvrti elif")
      var noStars = parseInt(this.filterBy)
      if(!Number.isInteger(noStars)){
        
          alert("The value you entered is not a number")
      }else{
        if(noStars>5 || noStars<1){
          console.log(noStars)
          alert("The value you entered is greater than 5 or less than 1")
        }else{
      this.configService.getByStars(noStars).subscribe(
        (response:Employee[])=>{
          this.employees=response;
        },
        (error:HttpErrorResponse)=>{
          alert(error.message);
        }
      )
      }
    }


      //ako nema selektirano bara default po ime
    }else{
      console.log("pet elif")

      this.configService.getByName(this.filterBy).subscribe(
        (response:Employee[])=>{
          this.employees=response;
        },
        (error:HttpErrorResponse)=>{
          alert(error.message);
        }
        )
    }
    
  }
  deleteHotel(name:number){
    this.configService.deleteEmployee(name).subscribe();
    window.location.reload()
  }
  getHotel(id:number)
  {
    console.log(id);
    window.location.href = "http://localhost:4200/edit-hotel/"+id;

  }
}
