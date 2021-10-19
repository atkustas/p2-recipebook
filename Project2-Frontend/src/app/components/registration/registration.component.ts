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


//add ticket function
async newTicket() {

  console.log("inside the newTicket async");
  //console.log("This is the userOb: " + userOb);

  //populate form with userOb data (first/last name), user_id (regular employee is signed it at this point)
  //remember to use timestamp function to set re_submitted --- "timestamp = new Date();"

  //this will be where the JS reads the ticket parameters from the form inputs
  //document.getElement....value for each ticket.parameter
  //need to have all the parameters set for the server to accept the ticket


      if(this.type == "Business"){
          this.type_id = 1;
      }else if(this.type = "Travel"){
          this.type_id = 2;
      }else if(this.type = "Medical"){
          this.type_id= 3;
      }else{
          this.type_id = 4;
      }

      // let type_id_ob = {
      //     re_type: type,
      //     re_type_id: type_id

      // };

      let status_id_ob = {
          re_status: "Pending",
          re_status_id: 3

      };


    let ticket = {
    re_amount: this.amount,
   re_submitted: this.timeSubmitted,
  //     re_resolved: null,
  //     re_desc: desc,
  //     re_receipt: null,
  //     re_author: userOb,
  //     re_resolver: null,
  //     re_status_id: status_id_ob,
  //     re_type_id: type_id_ob
    };

  console.log(ticket);
  console.log("sending request");

  let response = await fetch(this.url + "newticket", {


      method: "POST",
      mode: 'cors',
      body: JSON.stringify(ticket),
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
      // changeHideEmpForm()
  }
}

}







