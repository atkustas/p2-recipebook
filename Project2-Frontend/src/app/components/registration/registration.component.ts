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
public inputPW:any;
public inputDob:any;
public inputEM:any;

//add user function
async getUserInfoFReg() {

  console.log("inside the registration async");

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
this.inputDob = "0";
this.inputFN = "0";
this.inputLN = "0";
this.inputPW = "0";
this.inputUN = "0";
}

}







