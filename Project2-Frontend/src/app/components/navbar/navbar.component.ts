import { User } from 'src/app/models/user';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  clearInfo(){

    console.log(localStorage);
    console.log(sessionStorage);
    localStorage.clear();
    sessionStorage.clear();
    console.log(localStorage);
    console.log(sessionStorage);

  }

}
