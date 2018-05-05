import { Injectable } from '@angular/core';
import { Http,  Response } from '@angular/http';
import 'rxjs/Rx';

import { environment } from '../../environments/environment';

@Injectable()
export class ImagesService {

  constructor(private http: Http) { }

  getDockerImages() {
    return this.http.get(environment.apiUrl + '/dockerimage').map(
      (response: Response) => {
        const imagesList = response.json();
        console.log('Getting docker images.');
        return imagesList;
      }
    );
  }

}
