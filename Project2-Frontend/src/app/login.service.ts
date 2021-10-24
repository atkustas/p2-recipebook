import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
// import { Session } from 'inspector';
import { Observable } from 'rxjs';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  constructor(private http: HttpClient) {
   }
    logurl = "http://localhost:8090/login"

   login(username:String, password:String){
    console.log("in loginservfuc0");
    // console.log(this.http.post(this.logurl, {username, password}));

     return this.http.post(this.logurl, {username, password}) as Observable<any>
   }

   regurl = "http://localhost:8090/register"

   register(username:String, email:String, password:String){
     return this.http.post(this.regurl, {username, email, password}) as Observable<User>
   }
}

