import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import  {DrugModel} from '../drugModel';

@Injectable({
  providedIn: 'root'
})
export class DrugRegistrationServiceService {
  message:any;

  constructor(private http:HttpClient) { }

  public doRegistration(drugModel){
    return this.http.post<DrugModel>("http://localhost:4203/drugs",drugModel,{responseType:'text' as 'json'});

    // return this.http.post("http://localhost:4203/drugs/",body);
  }

  public getAllDrugs(){
    console.log("inside service");
    console.log(this.http.get<DrugModel>("http://localhost:4203/drugs/"));
    return this.http.get<DrugModel>("http://localhost:4203/drugs/");
  }

  public deleteThisDrug(name){
    return this.http.delete("http://localhost:4203/drugs/"+name);
  }

  public getDrugByName(name){
    return this.http.get("http://localhost:4203/drugs/"+name);
  }
  public updateThisDrug(drugModel){
    return this.http.post<DrugModel>("http://localhost:4203/drugs",drugModel);

    // return this.http.post("http://localhost:4203/persons/",body);
  }

}
