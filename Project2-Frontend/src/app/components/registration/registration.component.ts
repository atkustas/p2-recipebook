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
timeSubmitted:any = "10/11/2021"; //edit current date function
type:String ="";//document.getElementById("exampleFormControlSelect1").value;
desc:String = "";//document.getElementById("EmpFormControlTextarea1").value;


public inputFN: String = "John";
public inputLN: String = "Smith";
public inputUN: String = "JSmith";
public inputPW: String = "xxxxx";
public inputAge: any = "xx/xx/xxxx";
public inputEM: String = "jSm@Gmail.com";




//add ticket function
async getUserInfoFReg() {

  console.log("inside the newTicket async");
  //console.log("This is the userOb: " + userOb);

  //populate form with userOb data (first/last name), user_id (regular employee is signed it at this point)
  //remember to use timestamp function to set re_submitted --- "timestamp = new Date();"

  //this will be where the JS reads the ticket parameters from the form inputs
  //document.getElement....value for each ticket.parameter
  //need to have all the parameters set for the server to accept the ticket

    let user: User = {
      email: this.inputEM,
      dob: this.inputAge,
      firstname: this.inputFN,
      lastname: this.inputLN,
      password: this.inputPW,
      username: this.inputUN,
      user_id: "158"
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

      console.log("New ticket submitted.");
      this.amount=null;
      // document.getElementById("EmpFormControlInputAmt").value = null;
      // document.getElementById("EmpFormControlTextarea1").value = null;

      // //call function to disappear ticket form and show success message
     //changeHideRegForm()
  }
    //changeFailedRegFrom()
}




 changeHideRegForm() {

  this.clearForms()

  //user was created

  //link to somewhere else

}


 changeFailedRegFrom() {

//user failed to be created

}

 clearForms() {
 this.inputEM = "0";
this.inputAge = "0";
this.inputFN = "0";
this.inputLN = "0";
this.inputPW = "0";
this.inputUN = "0";
}

}







