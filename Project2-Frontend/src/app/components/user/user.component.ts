import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { User } from 'src/app/models/user';
import { Package } from 'src/app/models/package';

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
  public package:any;

  ngOnInit(): void {
    this.getInfo();

  }

  getInfo(): void{
    // this.ls.login(this.userName, this.passWord).subscribe(
    //   (data:any) => {
    //     this.package = data;
    //     console.log(this.package);
    //   },
      
    //   () => {
    //     this.package = null;
    //     console.log("No user info.");
    //   }
    // )

    this.user = localStorage.getItem('user')

  }


}
