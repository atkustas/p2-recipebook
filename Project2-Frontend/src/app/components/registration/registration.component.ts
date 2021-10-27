import { User } from 'src/app/models/user';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }



url:String = "http://localhost:8090/"

i = null;
allTickets= [this.i];
userOb:any;

//document.getElementById("empsubForm").addEventListener("click", newTicket);

type_id = 0;

amount:any = 0; //document.getElementById("EmpFormControlInputAmt").value;
type:String ="";//document.getElementById("exampleFormControlSelect1").value;
desc:String = "";//document.getElementById("EmpFormControlTextarea1").value;


public inputFN:any;
public inputLN:any;
public inputUN:any;
public inputUNTemp:any;
public inputPW:any;
public inputDob:any;
public inputEM:any;
public regFail:any;

//add user function
async getUserInfoFReg() {

  console.log("inside the registration async");

  this.inputUNTemp = this.inputUN;

    let user:any = {
      email: this.inputEM,
      dob: this.inputDob,
      firstName: this.inputFN,
      lastName: this.inputLN,
      password: this.inputPW,
      username: this.inputUN,
    };

  console.log(user);
  console.log("sending request");

  let response = await fetch(this.url + "register", {

      method: "POST",
      mode: 'cors',
      body: JSON.stringify(user),
      credentials: "include"

  });

  console.log("request got back");
  console.log(response.status);

  if(response.status === 201){

      console.log("New user created.");
      this.amount=null;
      // document.getElementById("EmpFormControlInputAmt").value = null;
      // document.getElementById("EmpFormControlTextarea1").value = null;

      // //call function to disappear ticket form and show success message
     this.changeHideRegForm();
  }

if(response.status === 403){

  console.log("failed 403 user created.");
  this.amount=null;
  this.regFail="403, underage"
  // document.getElementById("EmpFormControlInputAmt").value = null;
  // document.getElementById("EmpFormControlTextarea1").value = null;

  // //call function to disappear ticket form and show success message
 this.changeFailedRegFrom();
}

if(response.status === 406){

  console.log("failed 406 user created.");
  this.amount=null;
  this.regFail="406, Username taken"
  // document.getElementById("EmpFormControlInputAmt").value = null;
  // document.getElementById("EmpFormControlTextarea1").value = null;

  // //call function to disappear ticket form and show success message
 this.changeFailedRegFrom();
}

if(response.status === 409){

  console.log("failed 409 user created.");
  this.amount=null;
  this.regFail="409, Email already taken"
  // document.getElementById("EmpFormControlInputAmt").value = null;
  // document.getElementById("EmpFormControlTextarea1").value = null;

  // //call function to disappear ticket form and show success message
 this.changeFailedRegFrom();
}

  if(response.status === 500){

    console.log("failed 500 user created.");
    this.amount=null;
    this.regFail="500, empty or massive failure"
    // document.getElementById("EmpFormControlInputAmt").value = null;
    // document.getElementById("EmpFormControlTextarea1").value = null;

    // //call function to disappear ticket form and show success message
   this.changeFailedRegFrom();
}

}




 changeHideRegForm() {

  this.clearForms();
  this.submitName2();

  //user was created

  //link to somewhere else

}


 changeFailedRegFrom() {

//user failed to be created
   this.submitName();

}

clearForms() {
this.inputEM = "";
this.inputDob = "";
this.inputFN = "";
this.inputLN = "";
this.inputPW = "";

this.inputUNTemp = this.inputUN;
this.inputUN = "";
}

 //Greeter toggle
 greeterDiv:boolean = false;
 failBox:boolean = false;
 failBoxTag:boolean = false;
 //Greeter toggle
 greeterDiv2:boolean = false;
 sucBox:boolean = false;
 sucBoxTag:boolean = false;

submitName(){

  this.greeterDiv = true;

  this.failBox = !this.failBox;
  this.failBoxTag = !this.failBox;
}

submitName2(){

  this.greeterDiv = false;

  this.failBox = false;
  this.failBoxTag = false;


  this.greeterDiv2 = true;

  this.sucBox = !this.sucBox;
  this.sucBoxTag = !this.sucBox;
}

}







