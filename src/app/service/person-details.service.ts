import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PersonModel } from '../personModel';

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

  public deleteUser(id){
    return this.http.delete("http://localhost:4203/persons/"+id);
  }
}