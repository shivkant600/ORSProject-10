import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent extends BaseCtl {
  constructor(public locator:ServiceLocatorService,route:ActivatedRoute){
    super(locator.endpoints.role,locator,route);
  }

}
