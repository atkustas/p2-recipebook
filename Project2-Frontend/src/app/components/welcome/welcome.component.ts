import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}

//add URL variable so that we can add fetch request to backend
const urllogin = "http://localhost:8090/login"
async function loginFunc() { //add loginFunc
   
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

}

//add Registration function
