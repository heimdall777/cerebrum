import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HelloService } from './service/hello.service';
import { HttpModule } from '@angular/http';
import { ListComponent } from './images/list/list.component';
import { RoutingModule } from './app-routing.module';
import { GreetingsComponent } from './greetings/greetings.component';
import { ImagesService } from './service/images.service';
import { NotFoundComponent } from './error/not-found/not-found.component';
import { GeneralErrorComponent } from './error/general-error/general-error.component';


@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    GreetingsComponent,
    NotFoundComponent,
    GeneralErrorComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RoutingModule
  ],
  providers: [HelloService, ImagesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
