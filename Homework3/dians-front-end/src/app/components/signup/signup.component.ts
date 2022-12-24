import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { dataService } from 'src/app/resolver/dataService';
import { Register } from './signup.model';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
roles=[{id:1, value:'ROLE_USER', name:"User"},{id:2, value:'ROLE_PENDING_ADMIN', name:"Admin"}]
signup=new Register();

  constructor(private dataserivce:dataService,private httpClient:HttpClient){}
  ngOnInit(): void {
 
 
}
submit(f:NgForm)
{
  //this.signup.role="ROLE_USER";
  //this.signup.surname="tr"
    console.log(this.signup);
this.httpClient.post<any>("http://localhost:8080/register",this.signup)
.subscribe(res=>{
  if(res!=null && res!=undefined){
    location.href="/login";
  console.log(res);
  console.log(this.signup);
  }
  
})
}
}
