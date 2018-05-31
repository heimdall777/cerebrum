import { Injectable } from '@angular/core';
import { Http,  Response } from '@angular/http';
import { Observable } from "rxjs/Rx";
import {Router} from "@angular/router";
import 'rxjs/Rx';

import { environment } from '../../environments/environment';

@Injectable()
export class ImagesService {

  constructor(private http: Http,
              public router: Router) { }

  getDockerImages() {
    return this.http.get(environment.apiUrl + '/dockerimage').map(
      (response: Response) => {
        const imagesList = response.json();
        console.log('Getting docker images.');
        return imagesList;
      }
    ).catch((err) => {
      console.log('There was an error here', err);
      this.router.navigate(['/error']);
      return Observable.empty();
    });
  }

}
