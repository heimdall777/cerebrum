import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { Image } from '../model/image.model';
import { ImagesService } from '../../service/images.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  os: Image;
  errors: any;
  success: boolean;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private imagesService: ImagesService) { }

  ngOnInit() {
    this.os = new Image();
  }

  onCancel() {
    this.router.navigate(['../'], { relativeTo: this.route });
  }

  onAdd() {
    this.imagesService.createDockerImage(this.os).subscribe(
      data => {
        console.log(data);
        this.success = true;
        this.errors = null;
        setTimeout(() => {
          this.onCancel();
        },
          1000);
      },
      err => {
        this.errors = err;
      });
  }

}
