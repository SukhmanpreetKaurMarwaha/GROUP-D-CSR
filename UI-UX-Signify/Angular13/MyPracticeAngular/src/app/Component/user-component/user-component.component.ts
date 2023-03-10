import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-user-component',
  templateUrl: './user-component.component.html',
  styleUrls: ['./user-component.component.css']
})
export class UserComponentComponent implements OnInit {

  getData: any[] = [];

constructor(private _httpService:UserServiceService) { }

  ngOnInit(): void {
  }

  // call the back service method here 

getUserDetails(){

  this._httpService.getUsers().subscribe((res : any[])=>{
           console.log(res);
     this.getData = res;

});

}}
