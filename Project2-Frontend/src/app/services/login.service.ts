import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, Observable, of } from 'rxjs';
import {catchError, tap} from 'rxjs/internal/operators'
import { User } from '../models/user';
import { Jwt } from '../models/jwt';
import { UserComponent } from '../components/user/user.component';
import { Package } from '../models/package';

/*const httpOptions = {
  Headers: new HttpHeaders({'Content-Type': 'application/json'})
};*/

@Injectable({
  providedIn: 'root'
})
export class LoginService {

//private url = 'http://localhost:8090/login';
  constructor(private http: HttpClient) {}

  logurl = "http://localhost:8090/login"

   login(username:String, password:String):Observable<Package> {
    const encodedCredentials = btoa(`${username}:${password}`);
    const httpOptions = {
        headers: new HttpHeaders({
            'Authorization': `Basic ${encodedCredentials}`
        })
    };
    return this.http.post(this.logurl, {username, password}, {withCredentials:true}) as Observable<Package>

   };

  usurl = "http://localhost:8090/returnuser"

  async getUser(username:String, password:String){
    
    let user;
    var body = {
      username: username,
      password: password
    }

    let response = await fetch(this.usurl, {
 
      method: "POST",
      mode: 'cors',
      body: JSON.stringify(body),
      credentials: "include"
  });

    let data = await response.json();

    if(response.status === 200){
      user = data;

      localStorage.setItem('fName', data.firstname);
      localStorage.setItem('lName', data.lastname);
      localStorage.setItem('dob', data.dob);
      localStorage.setItem('email', data.email);

      console.log(user);

    }
    return user;
  }

  regurl = "http://localhost:8090/register"

   register(username:String, email:String, password:String){
     return this.http.post(this.regurl, {username, email, password}) as Observable<User>
   }

   
}



     

