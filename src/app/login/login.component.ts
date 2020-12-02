import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn:'root'
})
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  unFromComp='MeenaT'
  pwFromComp=''
  errorMessage="Invalid Credentails";
  isInvalidLogin=false;

  constructor(private router :Router, 
    private hardcodedAuthenticationService: HardcodedAuthenticationService) 
  { }//Router dependency injected

  ngOnInit(): void {
  }

  HandleLogin(){
    console.log("Hello  "+ this.unFromComp);
   // if(this.unFromComp==='MeenaT' && this.pwFromComp==='Hello123!'){
    if(this.hardcodedAuthenticationService.authenticate(this.unFromComp,this.pwFromComp)){
      this.isInvalidLogin=false
      this.router.navigate(['welcome',this.unFromComp])
      //Redirecting to Welcome component
    }
    else{
    this.isInvalidLogin=true
   // this.router.navigate(['error'])
    }
  }
 
}
