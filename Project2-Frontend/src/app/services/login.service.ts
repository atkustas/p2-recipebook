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
    
  /*login(data: any): Observable<any>{
    return this.http.post<any>(this.url, data).pipe(
      tap((result) => this.save_token(result)),
      catchError(this.handleError<any>('login'))
    );
  }
  private handleError<T>(operation = 'operation', result?: T){
    return (error: any): Observable<T> => {
      return of(result as T);
    };
  }
  private save_token(data: any){
    if (data.success) {
      localStorage.setItem('token', data.token)
    }
  }*/
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

  // getUser(username:String, password:String):Observable<User>{
  //   const jwt = localStorage.getItem('token');
  //   console.log("Heres the JWT: " +jwt)
  //   const httpOptions = {
  //     headers: new HttpHeaders({
  //       'Authorization': `Basic ${jwt}`
  //     })
  //   }
  //   return this.http.post(this.usurl, {username, password}, {withCredentials:true}) as Observable<User>
  // }

   
   

  regurl = "http://localhost:8090/register"

   register(username:String, email:String, password:String){
     return this.http.post(this.regurl, {username, email, password}) as Observable<User>
   }

   
}



     

