import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MenuComponent } from './menu/menu.component';
import { PersonDataComponent } from './person-data/person-data.component';
import { PersonComponent } from './person/person.component';
import { RouteguardService } from './service/routeguard.service';


const routes: Routes = [
  {path:'person',component:PersonComponent},
  {path:'login',component:LoginComponent},
  {path:'logout',component:LogoutComponent},
  {path:'actOnPerson',component:PersonDataComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
