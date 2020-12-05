import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
 

  constructor(private service:DrugRegistrationServiceService,
    private _router:Router,private _route:ActivatedRoute) { }

    ngOnInit() {
      this.drugModel.name=this._route.snapshot.paramMap.get("name");
      this.drugModel.availableAt=this._route.snapshot.paramMap.get("availableAt");
      this.drugModel.manufacturer=this._route.snapshot.paramMap.get("manufacturer");
      this.drugModel.expiryAt=this._route.snapshot.paramMap.get("expiryAt");
      this.drugModel.marketingStatus=this._route.snapshot.paramMap.get("marketingStatus");
     }
  

     public addNow(){
      let resp=this.service.doRegistration(this.drugModel);
      resp.subscribe((data:any)=>this.message=data);
      this._router.navigateByUrl('actOnDrug')
      }

}