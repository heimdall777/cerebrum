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

  image: Image;
  additionalSoftwareToAdd: string;
  softwareToAddList = [];
  errors: any;
  success: boolean;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private imagesService: ImagesService) { }

  ngOnInit() {
    this.image = new Image();
  }

  onSoftwareAdd() {
    this.softwareToAddList.push(this.additionalSoftwareToAdd);
    this.additionalSoftwareToAdd = '';
  }

  onSoftwareCancel() {
    this.additionalSoftwareToAdd = '';
  }

  onCancel() {
    this.router.navigate(['../'], { relativeTo: this.route });
  }

  onAdd() {
    this.image.additionalSoftware = this.softwareToAddList;

    this.imagesService.createDockerImage(this.image).subscribe(
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
