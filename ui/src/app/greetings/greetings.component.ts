import { Component, OnInit } from '@angular/core';
import { HelloService } from '../service/hello.service';

@Component({
  selector: 'app-greetings',
  templateUrl: './greetings.component.html',
  styleUrls: ['./greetings.component.css']
})
export class GreetingsComponent implements OnInit {

  helloMessage = '';

  constructor(private helloService: HelloService) { }

  ngOnInit() {
    this.helloService.getWelcomeMessage().subscribe((welcome: any) => {
      this.helloMessage = welcome.helloMessage;
      console.log(welcome);
    });
  }

}
