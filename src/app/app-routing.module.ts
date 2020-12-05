import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DrugDataComponent } from './drug-data/drug-data.component';
import { DrugComponent } from './drug/drug.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MenuComponent } from './menu/menu.component';
import { PersonDataComponent } from './person-data/person-data.component';
import { PersonComponent } from './person/person.component';
import { RouteguardService } from './service/routeguard.service';
import { ErrorComponent } from './error/error.component';
import { WelcomeUserComponent } from './welcome-user/welcome-user.component';


const routes: Routes = [
  {path:'person',component:PersonComponent},
  {path:'login',component:LoginComponent},
  {path:'logout',component:LogoutComponent},
  { path:'',component:LoginComponent},
  { path:'welcome/:name',component:WelcomeUserComponent,canActivate:[RouteguardService]},
  {path:'actOnPerson',component:PersonDataComponent,canActivate:[RouteguardService]},
  {path:'drug',component:DrugComponent},
  {path:'actOnDrug',component:DrugDataComponent},
  { path:'**',component:ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
