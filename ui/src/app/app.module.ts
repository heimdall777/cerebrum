import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HelloService } from './service/hello.service';
import { HttpModule } from '@angular/http';
import { ListComponent } from './images/list/list.component';
import { RoutingModule } from './app-routing.module';
import { GreetingsComponent } from './greetings/greetings.component';


@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    GreetingsComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RoutingModule
  ],
  providers: [HelloService],
  bootstrap: [AppComponent]
})
export class AppModule { }
