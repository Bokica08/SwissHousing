import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ConfigService } from 'src/app/config/config.service';
import { GuestHouse } from 'src/app/guest-house.model';
import { ActivatedRoute, ActivatedRouteSnapshot, Router, RouterStateSnapshot} from "@angular/router";
import { state } from '@angular/animations';

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
  router: any;
  isLoggedIn: any;
  storageService: any;
  roles: any;
  showAdminBoard: any;
  showModeratorBoard: any;
  username: any;
  user;


  title(title: any) {
    throw new Error('Method not implemented.');
  }


  constructor(private configService:ConfigService,private activateRoute: ActivatedRoute,private httpClient:HttpClient){
    this.isLoggedIn=this.activateRoute.snapshot.data['data5']
    this.user=this.activateRoute.snapshot.data['data6']
    
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    throw new Error('Method not implemented.');
  }
  ngOnInit(): void {
    this.getHouses();
    if (this.isLoggedIn) {
      console.log("if")
      //const user = this.storageService.getUser();
      this.roles = this.user.roles;
      //debugger

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
      //debugger

      this.username = this.user.username;
    }else{
      console.log("else")
      console.log(this.isLoggedIn);
    }
    console.log(this.isLoggedIn);
    //debugger
    
  }



  getHouseForUser(id:number)
  {
    this.httpClient.get<any>("http://localhost:8080/user/addFavourite/"+id,).subscribe(res=>
    {
      console.log(res);
      
    })
  }
  getHouseForUserV(id:number)
  {
    this.httpClient.get<any>("http://localhost:8080/user/addVisited/"+id,).subscribe(res=>
    {
      console.log(res);
      
    })
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
  getHouse(id:number)
  {
    console.log(id);
    window.location.href = "http://localhost:4200/edit-guesth/"+id;

  }

}
