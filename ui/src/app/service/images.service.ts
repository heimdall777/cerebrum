import { Injectable } from '@angular/core';
import { Headers, Http,  Response } from '@angular/http';
import { Observable } from "rxjs/Rx";
import {Router} from "@angular/router";
import 'rxjs/Rx';

import { environment } from '../../environments/environment';
import { Image } from '../images/model/image.model';

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

  createDockerImage(image: Image) {

    console.log('Create image...');
    console.log('Image: ', image);
    const headers = new Headers({'Content-Type': 'application/json'});
    return this.http.post(environment.apiUrl + '/dockerimage/create',
      image,
      {headers: headers});
  }

}
