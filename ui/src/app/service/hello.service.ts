import { Injectable } from '@angular/core';
import { Http,  Response } from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class HelloService {

  constructor(private http: Http) { }

  getWelcomeMessage() {
    return this.http.get('http://cerebrum-app:8080/api/greeting').map(
      (response: Response) => {
        const welcome = response.json();
        console.log(welcome);
        return welcome;
      }
    );
  }


}
