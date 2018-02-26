import { Component } from '@angular/core';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { HelloService } from './service/hello.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  helloMessage = '';

  constructor(private helloService: HelloService) { }

  ngOnInit() {
    this.helloService.getWelcomeMessage().subscribe((welcome: any) => {
      this.helloMessage = welcome.helloMessage;
      console.log(welcome);
    });
  }

}
