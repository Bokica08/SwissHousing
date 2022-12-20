import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { dataService } from 'src/app/resolver/dataService';
import { Register } from './signup.model';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
  roles=[{id:1, name:"user"},{id:2, name:"admin"}]
signup=new Register();

  constructor(private dataserivce:dataService,private httpClient:HttpClient){}
  ngOnInit(): void {

  
}
submit(f:NgForm)
{
  this.signup.role="ROLE_USER";
  this.signup.surname="tr"
    console.log(this.signup);

this.httpClient.post<any>("http://localhost:8080/register",this.signup)
.subscribe(res=>{
  console.log(this.signup);
  
})
}
}
