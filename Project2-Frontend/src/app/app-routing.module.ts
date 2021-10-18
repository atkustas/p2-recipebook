import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CocktailComponent } from './components/cocktail/cocktail.component';
//import { LoginComponent } from './components/login/login.component';
import { ReviewComponent } from './components/review/review.component';
import { UserComponent } from './components/user/user.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
//testing branches
const routes: Routes = [

  {
    path: "user",
    component: UserComponent
  },

  {
    path: "cocktails",
    component: CocktailComponent
  },

  // {
  //   path: "login",
  //   component: LoginComponent
  // },

  {
    path: "review",
    component: ReviewComponent
  },

  {
    path: "",
    component: WelcomeComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
