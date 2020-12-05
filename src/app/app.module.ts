import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { MenuComponent } from './menu/menu.component';
import { PersonComponent } from './person/person.component';
import { FormsModule } from '@angular/forms';
import { PersonRegistationService } from './service/person-details.service';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HardcodedAuthenticationService } from './service/hardcoded-authentication.service';
import { LogoutComponent } from './logout/logout.component';
import { RouteguardService } from './service/routeguard.service';
import { PersonDataComponent } from './person-data/person-data.component';
import { DrugComponent } from './drug/drug.component';
import { DrugDataComponent } from './drug-data/drug-data.component';
import {ErrorComponent} from './error/error.component';
import { WelcomeUserComponent } from './welcome-user/welcome-user.component';

@NgModule({
  declarations: [
    AppComponent,ErrorComponent,
    FooterComponent,MenuComponent, PersonComponent,LoginComponent,LogoutComponent, PersonDataComponent, DrugComponent, DrugDataComponent, WelcomeUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule,
    HttpClientModule
  ],
  providers: [PersonRegistationService,HardcodedAuthenticationService,RouteguardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
