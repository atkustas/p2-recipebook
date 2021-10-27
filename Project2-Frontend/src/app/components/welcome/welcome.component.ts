import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';


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

public urllogin:String = "http://localhost:8090/login"

public package:any;

loginFunc(): void {
  console.log("in loginfunc1");
  this.ls.login(this.userName,this.passWord).subscribe(
    (data:any) => {

      this.package = data;

      localStorage.setItem('id', this.package.user.user_id);
      console.log("CHECKING FOR USER ID")
      console.log(localStorage.getItem('id'));
      console.log(this.package.user.user_id);
      localStorage.setItem('fName', this.package.user.firstName);
      localStorage.setItem('lName', this.package.user.lastName);
      localStorage.setItem('dob', this.package.user.dob);
      localStorage.setItem('email', this.package.user.email);
      localStorage.setItem('un', this.package.user.password);
      localStorage.setItem('pw', this.package.user.username);
      console.log(localStorage.getItem('id'));

      console.log("in loginFunc, should have Package");
      console.log(this.package);

      let newPackage = JSON.stringify(this.package);
      localStorage.setItem('pkg', newPackage);
      console.log(localStorage.getItem('pkg'));
    },

    () => {
      console.log("LOGIN FAILED");
      this.package = null;
    }
  )
}

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
