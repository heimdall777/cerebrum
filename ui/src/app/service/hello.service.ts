import { Injectable } from '@angular/core';
import { Http,  Response } from '@angular/http';
import { Observable } from "rxjs/Rx";
import {Router} from "@angular/router";
import 'rxjs/Rx';

import { environment } from '../../environments/environment';

@Injectable()
export class HelloService {

  constructor(private http: Http,
              public router: Router) { }

  getWelcomeMessage() {
    return this.http.get(environment.apiUrl + '/greeting').map(
      (response: Response) => {
        const welcome = response.json();
        console.log(welcome);
        return welcome;
      }
    ).catch((err) => {
      console.log('There was an error here', err);
      this.router.navigate(['/error']);
      return Observable.empty();
    });
  }

}
