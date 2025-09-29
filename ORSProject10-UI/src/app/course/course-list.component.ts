import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { BaseListCtl } from '../base-list.component';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  
})
export class CourseListComponent extends BaseListCtl{

  constructor(public locator:ServiceLocatorService,route:ActivatedRoute){
    super(locator.endpoints.COURSE,locator,route)

  }

}
