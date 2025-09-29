import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-faculty',
  templateUrl: './faculty.component.html',
  
})
export class FacultyComponent  extends BaseCtl{
  constructor(public locator:ServiceLocatorService,route:ActivatedRoute){
    super(locator.endpoints.FACULTY,locator,route);

  }

}
