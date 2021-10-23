import { Component, OnInit } from '@angular/core';
//added for jwt webtoken 
import {Request, Response} from "express";
import * as express from 'express';

//added for jwt webtoken
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');

//added for jwt webtoken
import * as jwt from 'jsonwebtoken';
import *  as fs from "fs";

const app: Application = express();

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
const urlreg = "http://localhost:8090/register"
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
}

//code for webtoken

