import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PersonModel } from '../personModel';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonRegistationService {
  message:any;


  constructor(private http:HttpClient) { }
  

  public doRegistration(personModel){
    return this.http.post<PersonModel>("http://localhost:4203/persons",personModel,{responseType:'text' as 'json'});

    // return this.http.post("http://localhost:4203/persons/",body);
  }

  public getAllPersons(){
    console.log("inside service");
    console.log(this.http.get<PersonModel>("http://localhost:4203/persons/"));
    return this.http.get<PersonModel>("http://localhost:4203/persons/");
  }

  public getUserByFirstName(emailId){
    return this.http.get("http://localhost:4203/persons/"+emailId);
  }

  public deleteUser(emailid){
    return this.http.delete("http://localhost:4203/persons/"+emailid);
  }

  public updateThisPerson(personModel,emailId){
    console.log('Inside update service method',personModel,emailId);
    return this.http.put<PersonModel>("http://localhost:4203/persons/"+emailId,personModel,{responseType:'text' as 'json'});
    
    // return this.http.post("http://localhost:4203/persons/",body);
  }
}