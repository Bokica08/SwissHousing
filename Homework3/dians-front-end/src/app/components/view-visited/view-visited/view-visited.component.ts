import { state } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { ConfigService } from 'src/app/config/config.service';

@Component({
  selector: 'app-view-visited',
  templateUrl: './view-visited.component.html',
  styleUrls: ['./view-visited.component.css']
})
export class ViewVisitedComponent implements OnInit{
  isLoggedIn: any;
  roles: any;
  user: any;
  showAdminBoard: any;
  showModeratorBoard: any;
  username: any;
  userAccount:any;

  constructor(private activateRoute: ActivatedRoute,private configService:ConfigService){
    this.isLoggedIn=this.activateRoute.snapshot.data['data5']
    this.user=this.activateRoute.snapshot.data['data6']
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    throw new Error('Method not implemented.');
  }


  ngOnInit(): void {
    if (this.isLoggedIn) {
      console.log("if")
      //const user = this.storageService.getUser();
      this.roles = this.user.roles;
      //debugger

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
      //debugger

      this.username = this.user.username;
      //debugger;
      this.userAccount=this.configService.getUser(this.username).subscribe(
        res=>{
          this.user=res
          console.log(this.user);
          
        }
      );
      //debugger;
      console.log(this.userAccount.lastname);
    }else{
      console.log("else")
      console.log(this.isLoggedIn);
    }
    console.log(this.isLoggedIn);
    //debugger
  }
}
