import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CocktailComponent } from './components/cocktail/cocktail.component';
import { HomeComponent } from './components/home/home.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { ReviewComponent } from './components/review/review.component';
import { UserComponent } from './components/user/user.component';
import { WelcomeComponent } from './components/welcome/welcome.component';


const routes: Routes = [

  {
    path: "user",
    component: UserComponent
  },

  {
    path: "cocktails",
    component: CocktailComponent
  },

  {
    path: "new",
    component: RegistrationComponent
  },

  {
    path: "review",
    component: ReviewComponent
  },

  {
    path: "",
    component: WelcomeComponent
    
  },

  {
    path: "home",
    component: HomeComponent,
    // canActivate:[WelcomeComponent]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
