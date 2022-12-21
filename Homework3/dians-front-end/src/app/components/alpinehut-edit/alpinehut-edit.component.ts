import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Guest } from '../adding-guestshouses/adding-guesthouses.model';

@Component({
  selector: 'app-alpinehut-edit',
  templateUrl: './alpinehut-edit.component.html',
  styleUrls: ['./alpinehut-edit.component.css']
})
export class AlpinehutEditComponent implements OnInit{
  guest=new Guest()
  constructor(private httpClient:HttpClient){}
  ngOnInit(): void {
  }

submit()
{
  console.log(this.guest);
  this.httpClient.post<any>("http://localhost:8080/guesthouse/add",this.guest)
.subscribe(res=>{
  console.log(this.guest);
  
})
}

}
