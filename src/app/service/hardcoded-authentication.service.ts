import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'
  public username: String;
  public password: String;

  constructor(private http: HttpClient) { }

  // authenticate(username,password){
  //   const headers=new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
  //   console.log("before "+this.isValidUserLogin());
  //   if(username==='MeenaT' && password==='Hello123!'){
  //    sessionStorage.setItem('userSession',username);
  //    console.log("after "+this.isValidUserLogin());
  //    return true;
  //   }
  //   else{
  //     return false;
  //   }
  // }
  authenticate(username:String,password:String){
    return this.http.get(`http://localhost:4203/basicauth`,
    { headers: { authorization: this.createBasicAuthToken(username, password) } }).pipe(map((res) => {
      this.username = username;
      this.password = password;
      this.registerSuccessfulLogin(username, password);
    }));
  }
  createBasicAuthToken(username: String, password: String) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }
  registerSuccessfulLogin(username, password) {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username)
  }
  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }
  isValidUserLogin(){
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  isUserLoggedOut(){  
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.username = null;
    this.password = null;
  }
}  
