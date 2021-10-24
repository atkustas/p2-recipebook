import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/login.service';
import { User } from 'src/app/models/user';


@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor(private ps: LoginService) { }

  public User:any = null;
  public input:number = 0;

  ngOnInit(): void {
  }

}

//add URL variable so that we can add fetch request to backend
const urllogin = "http://localhost:8090/login"
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
loginFunc():void {
  this.ps.login(this.input).subscribe(
    (data:any) => {
      this.user = data;
      console.log(LoginService);
    },
    () => {
      this.login = null;
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

regFunc(): void{
  this.ps.register(this.input).subscribe(
    (data:any) => {
      this.register = data; 
      console.log(this.register)
    },
    () => {
      this.register = null;
    }
  )
}


