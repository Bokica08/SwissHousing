import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ConfigService } from 'src/app/config/config.service';
import { CampSite } from 'src/app/camp-site.model';
import { ActivatedRoute, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Component({
  selector: 'app-campsite',
  templateUrl: './campsite.component.html',
  styleUrls: ['./campsite.component.css']
})
export class CampsiteComponent implements OnInit{
  public campsites:CampSite[] | undefined;
  filterBy;
  dropDownResult;
  showNoResult;
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


  constructor(private configService:ConfigService,private httpClient:HttpClient,private activateRoute: ActivatedRoute){
    this.isLoggedIn=this.activateRoute.snapshot.data['data5']
    this.user=this.activateRoute.snapshot.data['data6']
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    this.getCamps();
    if (this.isLoggedIn) {
      console.log("if")
      //const user = this.storageService.getUser();
      this.roles = this.user.roles;
      debugger

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
      debugger

      this.username = this.user.username;
    }else{
      console.log("else")
      console.log(this.isLoggedIn);
    }
    console.log(this.isLoggedIn);
    debugger
  }



  getCampForUser(id:number)
  {
    this.httpClient.get<any>("http://localhost:8080/user/addFavourite/"+id,).subscribe(res=>
    {
      console.log(res);
      
    })
  }
  getCampForUserV(id:number)
  {
    this.httpClient.get<any>("http://localhost:8080/user/addVisited/"+id,).subscribe(res=>
    {
      console.log(res);
      
    })
  }
  deleteCamps(){

  }
  public getCamps(): void {
  
    this.configService.getCamps().subscribe(
      
      (response: CampSite[]) => {
        this.campsites = response;
        console.log(this.campsites);
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
      this.configService.getCamps().subscribe(
      
        (response: CampSite[]) => {
          this.campsites = response;
          console.log(this.campsites);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
        
      );
      if(this.campsites.length==0){
        this.showNoResult=true;
      }else{
        this.showNoResult=false;
      }
      // ako e selektirano da bara po city
    }else if(this.dropDownResult==='city'){
      console.log("Vtor if")
    this.configService.getByCityCamp(this.filterBy).subscribe(
      (response: CampSite[]) => {
        this.campsites = response;
        console.log(this.campsites);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
    this.showNoResult=false;
    // ako e selektirano da bara po ime
    }else if(this.dropDownResult==='name'){
      console.log("Tret elif")
      this.configService.getByNameCamp(this.filterBy).subscribe(
        (response:CampSite[])=>{
          this.campsites=response;
        },
        (error:HttpErrorResponse)=>{
          alert(error.message);
        }
        )
      
    //ako nema selektirano bara default po ime
    }else{
      console.log("pet elif")

      this.configService.getByNameCamp(this.filterBy).subscribe(
        (response:CampSite[])=>{
          this.campsites=response;
        },
        (error:HttpErrorResponse)=>{
          alert(error.message);
        }
        )
    }
    
  }
  deleteCamp(id:number){
    this.configService.deleteCamp(id).subscribe(); 
    window.location.reload()
  }
  getCamp(id:number)
  {
    console.log(id);
    window.location.href = "http://localhost:4200/edit-camp/"+id;

  }


}
