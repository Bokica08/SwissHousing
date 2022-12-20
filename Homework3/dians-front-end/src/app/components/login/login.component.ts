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
  this.httpClient.post<any>("http://localhost:8080/login",this.login)
.subscribe(res=>{
  console.log(this.login);
  
})
}

}
