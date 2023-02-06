import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
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
  isLoggedIn: any;
  storageService: any;
  roles: any;
  user;
  showAdminBoard: any;
  showModeratorBoard: any;
  username: any;




  title(title: any) {
    throw new Error('Method not implemented.');
  }


  constructor(private configService:ConfigService,private activateRoute: ActivatedRoute,private httpClient:HttpClient){
    ;
    this.isLoggedIn=this.activateRoute.snapshot.data['data5']
    this.user=this.activateRoute.snapshot.data['data6']
    //this.isLoggedIn = this.storageService.isLoggedIn();
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    ;
    this.getEmployees();
    
    //this.isLoggedIn=this.activateRoute.snapshot.data['data5']
    if (this.isLoggedIn) {
      //const user = this.storageService.getUser();
      this.roles = this.user.roles;
      

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
      

      this.username = this.user.username;
    }else{
      console.log(this.isLoggedIn);
    }
    console.log(this.isLoggedIn);
    
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
    console.log(this.filterBy!=null)
    console.log(this.dropDownResult);
    // ako e 
    if(this.filterBy==null || this.filterBy.length==0){
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
  getHotelForUser(id:number)
  {
    this.httpClient.get<any>("http://localhost:8080/user/addFavourite/"+id,).subscribe(res=>
    {
      console.log(res);
      
    })
  }
  getHotelForUserV(id:number)
  {
    this.httpClient.get<any>("http://localhost:8080/user/addVisited/"+id,).subscribe(res=>
    {
      console.log(res);
      
    })
  }
}
