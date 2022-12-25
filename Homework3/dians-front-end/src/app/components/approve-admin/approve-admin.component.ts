import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/_services/user.service';
import { User } from './approveAdmin.model';

@Component({
  selector: 'app-approve-admin',
  templateUrl: './approve-admin.component.html',
  styleUrls: ['./approve-admin.component.css']
})
export class ApproveAdminComponent implements OnInit{
  users:User[]
  constructor(private httpClient:HttpClient){}
  ngOnInit(): void {
   this.httpClient.get<any>("http://localhost:8080/user/pending")
  .subscribe(res=>{
    this.users=res
    console.log(this.users);
    
  })

}
approve(send:string)
{

  this.httpClient.get<any>("http://localhost:8080/user/pending/authorizeAdmin?username="+send).subscribe(res=>
  {
    this.ngOnInit()
  })
  
  

}
}
