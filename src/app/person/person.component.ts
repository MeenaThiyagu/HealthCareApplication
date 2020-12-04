import { Component, OnInit } from '@angular/core';
import { PersonModel } from '../personModel';
import { PersonRegistationService } from '../service/person-details.service';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {
 
 public personModel: PersonModel={
    firstName:"",   lastName:"",    emailId:"",    location:"",personId:0
 };
  message:any;
 

  constructor(private service:PersonRegistationService) { }

  ngOnInit() {
    // this.personModel.firstName="";
    // this.personModel.lastName="";
    // this.personModel.emailId="";
    // this.personModel.location="";
  }
  

public addNow(){
let resp=this.service.doRegistration(this.personModel);
resp.subscribe((data:any)=>this.message=data);
}

}