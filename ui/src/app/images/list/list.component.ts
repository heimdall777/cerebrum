import { Component, OnInit } from '@angular/core';
import { ImagesService } from '../../service/images.service';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  images = [];
  interval: any;

  constructor(private imagesService: ImagesService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    console.log('Initializing list.');
    this.fetchData();
    console.log('List initialized.');
  //   this.interval = setInterval(() => {
  //     this.fetchData();
  // }, 1000);
  }

  onAddImage() {
    this.router.navigate(['add'], {relativeTo: this.route});
  }

  fetchData() {
    this.imagesService.getDockerImages().subscribe((images: any) => { console.log(images);
      this.images = images; });
  }

}
