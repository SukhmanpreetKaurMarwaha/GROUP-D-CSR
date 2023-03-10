import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  //constructor() { }
  

  constructor(private httpClient:HttpClient) { }
 // Get method implementation from the service layer 
  getUsers(): Observable<any>{
    let getUsersUrl:string = "http://localhost:7000/users/list";
    return this.httpClient.get(getUsersUrl,{headers: this.headers});
  }
}
