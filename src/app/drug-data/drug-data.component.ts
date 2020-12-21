import { Component, OnInit } from '@angular/core';
import { DrugRegistrationServiceService } from '../service/drug-registration-service.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-drug-data',
  templateUrl: './drug-data.component.html',
  styleUrls: ['./drug-data.component.css']
})
export class DrugDataComponent implements OnInit {
  drugs:any;
  data:Array<any>
  constructor(private service:DrugRegistrationServiceService,
    private http: HttpClient) { 
      this.data=new Array<any>()
    }
  
  totalRecords:number
  page: number=1

  ngOnInit(): void {
    this.getAllDrugs();
    
  }
  public getAllDrugs(){
    let resp=this.service.getAllDrugs();
    resp.subscribe((data)=>{
      console.log('Data is ',resp)
      console.log('Data is ',data)
      this.drugs=data;
    });
 
  }
  public deleteThisDrug(drug:any){
    const id=drug.id;
    console.log(drug);
   let resp=this.service.deleteThisDrug(drug.name);

   resp.subscribe(
    (data)=>{
      this.drugs = this.drugs.filter((x,y)=> {//x=>
        return x.id != id;
      })
      this.getAllDrugs()
    },
    (error) => alert("Delete operation failed")
    
  );
  
  console.log("inside tsof delete");
  }

  
}
