import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
 

  constructor(private service:PersonRegistationService,private _router:Router,
    private _route:ActivatedRoute) { }

  ngOnInit() {
   this.personModel.emailId=this._route.snapshot.paramMap.get("emailId");
   this.personModel.firstName=this._route.snapshot.paramMap.get("firstName");
   this.personModel.lastName=this._route.snapshot.paramMap.get("lastName");
   this.personModel.location=this._route.snapshot.paramMap.get("location");
  }
  

public addNow(){
let resp=this.service.doRegistration(this.personModel);
resp.subscribe((data:any)=>this.message=data);
this._router.navigateByUrl('actOnPerson')
}

}