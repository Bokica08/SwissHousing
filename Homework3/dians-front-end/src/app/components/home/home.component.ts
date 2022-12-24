import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  isLoggedIn: any;
  storageService: any;
  roles: any;
  showAdminBoard: any;
  showModeratorBoard: any;
  username: any;

  constructor(private activateRoute: ActivatedRoute,){
    debugger;
    this.isLoggedIn=this.activateRoute.snapshot.data['data5']
    
  }
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    throw new Error('Method not implemented.');
  }


   ngOnInit(): void {

    debugger
    //this.isLoggedIn = this.storageService.isLoggedIn();

    if (this.isLoggedIn) {
      debugger
      const user = this.storageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');

      this.username = user.username;
    }
    debugger
  }

}
