import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  images = [{osType: 'Ubuntu', osVersion: '16.04', additionalSoftware: ['Java', 'Spring Boot']},
            {osType: 'Ubuntu', osVersion: '17.10', additionalSoftware: 'PostgreSQL'},
            {osType: 'Ubuntu', osVersion: '18.04', additionalSoftware: ''},
            {osType: 'CentOS', osVersion: '7.3', additionalSoftware: 'Python'}];

  constructor() { }

  ngOnInit() {
  }

}
