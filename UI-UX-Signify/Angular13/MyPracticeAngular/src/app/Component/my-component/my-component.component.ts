import { Component, OnInit } from '@angular/core';
import { SSL_OP_PKCS1_CHECK_2 } from 'constants';
import { Customer } from 'src/app/model/customer';

@Component({
  selector: 'app-my-component',
  templateUrl: './my-component.component.html',
  styleUrls: ['./my-component.component.css']
})
export class MyComponentComponent implements OnInit {

  custArray:Array<Customer>=new Array();

  model=new Customer('',0);
  constructor() { }

  ngOnInit(): void {
  }
  //create customer operation with angular event
  createCustomer(){

    console.log("in the create customer method");
    this.custArray.push(new Customer(this.model.name,this.model.age));
    console.log(JSON.stringify(this.custArray));
  }

  update(i:number){
    this.custArray[i].age=this.model.age;
    this.custArray[i].name=this.model.name;
  }
  delete(i:number){
    this.custArray.splice(i,1);
  }

}
