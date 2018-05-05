import { Component, OnInit } from '@angular/core';
import { ImagesService } from '../../service/images.service';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  images = [];

  constructor(private imagesService: ImagesService) { }

  ngOnInit() {
    console.log('Initializing list.');
    this.imagesService.getDockerImages().subscribe((images: any) => { console.log(images);
      this.images = images; });
    console.log('List initialized.');
  }

}
