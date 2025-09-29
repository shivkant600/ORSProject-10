import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  
})
export class SubjectComponent extends BaseCtl {

  constructor(public locator:ServiceLocatorService,route:ActivatedRoute){
    super(locator.endpoints.SUBJECT,locator,route);

  }

}
