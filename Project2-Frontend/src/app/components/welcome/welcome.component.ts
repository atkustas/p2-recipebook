import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/login.service';
import { User } from 'src/app/models/user';
import { Jwt } from 'src/app/models/jwt';


@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor(private ps: LoginService) { }

  public user:any = null;
  public userName:String = '0';
  public passWord:String = "0";
  public email:String = ""

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

public jwt:any;

loginFunc(): void {
  console.log("in loginfunc1");
  this.ps.login(this.userName,this.passWord).subscribe(
    (data:any) => {

      this.jwt = data;

      console.log("in loginFunc, should have JWT");
      console.log(this.jwt);
    },
    () => {
      console.log("in loginFunc1 fail");
      this.jwt = null;
    }
  )
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

// regFunc(): void{
//   this.ps.register(this.input).subscribe(
//     (data:any) => {
//       this.register = data;
//       console.log(this.register)
//     },
//     () => {
//       this.register = null;
//     }
//   )
// }
}
