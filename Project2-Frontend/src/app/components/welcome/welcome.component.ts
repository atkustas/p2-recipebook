import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import { User } from 'src/app/models/user';
import { Jwt } from 'src/app/models/jwt';


@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit, CanActivate {

  constructor(
    private ls: LoginService,
    private router:Router
    ) {}

  public user:any;
  public userName:String = '';
  public passWord:String = '';
  public email:String = '';

  ngOnInit(): void {
  }



//add URL variable so that we can add fetch request to backend
public urllogin:String = "http://localhost:8090/login"
/*async function loginFunc() { //add loginFunc
  let usern = document.getElementById("username")
  let userp = document.getElementById("password")
  let user = {
    usern,
   userp
  }
  console.log(user)
  let response = await fetch(urllogin, {
    method: "POST",
    body: JSON.stringify(user),
    credentials: "include"
  })
  console.log(response.status)
}*/

public package:any;

loginFunc(): void {
  console.log("in loginfunc1");
  this.ls.login(this.userName,this.passWord).subscribe(
    (data:any) => {

      this.package = data;

      console.log("in loginFunc, should have Package");
      console.log(this.package);
      localStorage.setItem('token', this.package.jwt);
      localStorage.setItem('user', this.package.user);
    },

    () => {
      console.log("LOGIN FAILED");
      this.package = null;
    }
  )

  // this.getUserInfo();
}

// getUserInfo(): void {
//   this.ls.getUser(this.userName, this.passWord).subscribe(
//      (data:any) =>{
//        this.user = data;

//        console.log(this.user)
       
//      },
//      () => {
//        this.user = null;
//        console.log("NO USER");
//      }
//    )
//  }

canActivate(route: ActivatedRouteSnapshot, state:RouterStateSnapshot){
  let currentJwt = this.ls.login(this.userName, this.passWord).subscribe(
      (data:any) => {
          currentJwt = data;
      }
  );

  if(currentJwt){
      return true;
  }

  this.router.navigate([""], {queryParams: { returnUrl : state.url }});
  return false;
}




//add Registration function
/*const urlreg = "http://localhost:8090/register"
async function regiFunc() {
  let usern = document.getElementById("username")
  let email = document.getElementById("email")
  let userp = document.getElementById("password")
  let usreg = {
    usern,
    email,
    userp
  }
  console.log(usreg)
  let response = await fetch(urlreg, {
    method: "POST",
    body: JSON.stringify(usreg),
    credentials: "include"
  })
  console.log(response.status)
}*/

 regFunc(): void{
   this.ls.register(this.userName, this.email, this.passWord).subscribe(
     (data:any) => {
       this.package = data;
       console.log(this.package)
     },
     () => {
       this.package = null;
     }
   )
 }
}
