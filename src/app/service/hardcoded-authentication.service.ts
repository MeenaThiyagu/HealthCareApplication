import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  constructor() { }

  authenticate(username,password){
    console.log("before "+this.isValidUserLogin());
    if(username==='MeenaT' && password==='Hello123!'){
     sessionStorage.setItem('userSession',username);
     console.log("after "+this.isValidUserLogin());
     return true;
    }
    else{
      return false;
    }
  }

  isValidUserLogin(){
  let validatedUser= sessionStorage.getItem('userSession');
  return !(validatedUser===null)
  }

  isUserLoggedOut(){
    sessionStorage.removeItem('userSession');
  }
}
