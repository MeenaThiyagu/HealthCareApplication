import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DrugModel } from '../drugModel';
import { DrugRegistrationServiceService } from '../service/drug-registration-service.service';

@Component({
  selector: 'app-drug',
  templateUrl: './drug.component.html',
  styleUrls: ['./drug.component.css']
})
export class DrugComponent implements OnInit {
  public drugModel: DrugModel={
    name:"",   availableAt:"",    manufacturer:"",    expiryAt:"",drugId:0, marketingStatus:""
 };
  message:any;
 

  constructor(private service:DrugRegistrationServiceService,private _router:Router) { }

  ngOnInit() {
   
  }
  

public registerThisDrug(){
let resp=this.service.doRegistration(this.drugModel);
console.log(this.drugModel);
resp.subscribe((data:any)=>this.message=data);
this._router.navigateByUrl('actOnDrug')
}

}