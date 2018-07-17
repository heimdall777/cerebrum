import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HelloService } from './service/hello.service';
import { HttpModule } from '@angular/http';
import { ListComponent } from './images/list/list.component';
import { RoutingModule } from './app-routing.module';
import { ImagesService } from './service/images.service';
import { NotFoundComponent } from './error/not-found/not-found.component';
import { GeneralErrorComponent } from './error/general-error/general-error.component';
import { AddComponent } from './images/add/add.component';
import { FormsModule } from '@angular/forms';
import { HomePageComponent } from './home/home-page/home-page.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { AboutComponent } from './shared/about/about.component';


@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    NotFoundComponent,
    GeneralErrorComponent,
    AddComponent,
    HomePageComponent,
    HeaderComponent,
    FooterComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RoutingModule,
    FormsModule
  ],
  providers: [HelloService, ImagesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
