import { Component, OnInit } from '@angular/core';
import { PersonRegistationService } from '../service/person-details.service';

import { HttpClient } from '@angular/common/http';
import { PersonModel } from '../personModel';

@Component({
  selector: 'app-person-data',
  templateUrl: './person-data.component.html',
  styleUrls: ['./person-data.component.css']
})
export class PersonDataComponent implements OnInit {
  persons:any;
  constructor(private service:PersonRegistationService,
    private http: HttpClient) { }
  
  
  ngOnInit(): void {
    let resp=this.service.getAllPersons();
    let op=resp.subscribe((data)=>this.persons=data);
    console.log("O/p is"+op);
    console.log("inside ngOnInit of ts");
  }
  public getAllPersons(){
    let resp=this.service.getAllPersons();
    resp.subscribe((data)=>this.persons=data);
    console.log("inside ts");
  }

  public deleteUser(person:any){
   let resp=this.service.deleteUser(person);
   resp.subscribe((data)=>this.persons=data);
   console.log("inside tsof delete");
      }
}