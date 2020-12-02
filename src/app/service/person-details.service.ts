import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PersonModel } from '../personModel';

@Injectable({
  providedIn: 'root'
})
export class PersonRegistationService {


  constructor(private http:HttpClient) { }

  public doRegistration(personModel){
    return this.http.post<PersonModel>("http://localhost:4203/persons",personModel,{responseType:'text' as 'json'});

    // return this.http.post("http://localhost:4203/persons/",body);
  }

  public getPersons(){
    return this.http.get("http://localhost:4203/persons");
  }

  public getUserByFirstName(firstName){
    return this.http.get("http://localhost:4203/persons/"+firstName);
  }

  public deleteUser(id){
    return this.http.delete("http://localhost:4203/persons/"+id);
  }
}