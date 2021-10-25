import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private ls:LoginService) { }

  public userName:String = '';
  public passWord:String = '';
  public user:any;

  ngOnInit(): void {
    this.getUserInfo();
  }

  getUserInfo(): void {
    this.ls.getUser(this.userName, this.passWord).subscribe(
       (data:any) =>{
         this.user = data;

         console.log(this.user)
         
       },
       () => {
         this.user = null;
         console.log("NO USER");
       }
     )
   }

  //  userInfo():void {
  //   this.ps.getUser(this.userName, this.passWord).subscribe(
  //     (data2:User) => {
  
  //       this.user = data2;
  //       console.log("here's the user");
  //       console.log(this.user);
  //     }
  //   )
  
  // }

}
