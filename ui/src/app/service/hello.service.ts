import { Injectable } from '@angular/core';
import { Http,  Response } from '@angular/http';
import 'rxjs/Rx';

import { environment } from '../../environments/environment';

@Injectable()
export class HelloService {

  constructor(private http: Http) { }

  getWelcomeMessage() {
    return this.http.get(environment.apiUrl +'/greeting').map(
      (response: Response) => {
        const welcome = response.json();
        console.log(welcome);
        return welcome;
      }
    );
  }


}
