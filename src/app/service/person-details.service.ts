import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonRegistationService {


  constructor(private http:HttpClient) { }

  public doRegistration(personModel){
    let body= "email ID="+personModel.emailId;

    return this.http.post("http://localhost:4203/persons",body);
  }

  public getPersons(){
    return this.http.get("http://localhost:4201/persons");
  }

  public getUserByFirstName(firstName){
    return this.http.get("http://localhost:4201/persons/"+firstName);
  }

  public deleteUser(id){
    return this.http.delete("http://localhost:4201/persons/"+id);
  }
}