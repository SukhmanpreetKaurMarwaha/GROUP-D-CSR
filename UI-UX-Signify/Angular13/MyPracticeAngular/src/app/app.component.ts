import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  //this is the data model property
  title:string = 'Signify Project';
  name:string='CRS-Group-D';
  clickMessage:string="status of training";

  //this is angular custom event for click message
  onClickMe(){

    console.log("fire the event in A13");
  
    this.clickMessage="Taaining is up-->"

} 
}
