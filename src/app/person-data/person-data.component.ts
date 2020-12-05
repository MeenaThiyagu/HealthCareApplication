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
    this.getAllPersons();
    
  }
  public getAllPersons(){
    let resp=this.service.getAllPersons();
    resp.subscribe((data)=>{
  
      this.persons=data
    });
 
  }

  public deleteUser(person:any){
    const id=person.id;
    console.log(person);
   let resp=this.service.deleteUser(person.emailId);

   resp.subscribe(
    (data)=>{
      this.persons = this.persons.filter((x,y)=> {//x=>
        return x.id != id;
      })
      this.getAllPersons();
    },
    (error) => alert("Delete operation failed")
    
  );
  
  console.log("inside tsof delete");
  }

  public updateThisPerson(user){
    let resp=this.service.updateThisPerson(user);
    
    resp.subscribe((data:any)=>this.persons=data);
    console.log(resp+" is response ");
  }
}