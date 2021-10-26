import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { User } from 'src/app/models/user';
import { Package } from 'src/app/models/package';
import { FavoriteService } from 'src/app/services/favorite.service';
import { ReviewService } from 'src/app/services/review.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private ls:LoginService, private fs: FavoriteService, private rs: ReviewService) { }

  public userName:String = '';
  public passWord:String = '';
  public user:any;
  public package:any;
  public user_id:any;
  public drinkName: String = '';

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


  getFavorites(): void{
    this.fs.addFavorite(this.user_id, this.drinkName).subscribe(
      (data:any) => {
        this.package = data;
        console.log(this.package);
      },

      () => {
        this.package = null;
        console.log("can't add fav")
      }
    )
    this.user_id = localStorage.getItem('user_id')
  }

  getReviews(): void{
    this.rs.viewReviews(this.user).subscribe(
      (data:any) => {
        this.package = data; 
        console.log(this.package);
      },
      () => {
        this.package = null;
        console.log("Cannot view reviews")
      }
    )
    
  }

  addReviews(): void{
    this.rs.addReview(this.user_id, this.drinkName).subscribe(
      (data:any) => {
        this.package = data;
        console.log(this.package);
      },
      () => {
        this.package = null;
        console.log("Cannot add review")
      }
    )
  }


}
