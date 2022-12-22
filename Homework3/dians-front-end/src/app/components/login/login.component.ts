import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Login } from './login.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  login=new Login()
  constructor(private httpClient:HttpClient){}
  ngOnInit(): void {
  }
submit()
{
  console.log(this.login.username);
  console.log(this.login.password);
  
  
  this.httpClient.post<any>("http://localhost:8080/login",{username:this.login.username, password:this.login.password})
.subscribe(res=>{
  console.log(this.login);
  
})
}

}
