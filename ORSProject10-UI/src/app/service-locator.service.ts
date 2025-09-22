import { Injectable } from '@angular/core';
import { HttpServiceService } from './http-service.service';
import { EndpointServiceService } from './endpoint-service.service';
import { Router, ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ServiceLocatorService {


  httpService :any = '';
  
  router :any= '';
  endpoints:any = '';

  constructor(private hs: HttpServiceService, private r: Router, private ep: EndpointServiceService) {
    this.httpService = hs;
  
    this.router = r;
    this.endpoints = ep;
  }

  
  getPathVariable(route: ActivatedRoute, callback:any) {
    route.params.subscribe(params => {
      callback(params)
    });
  }


  forward(page:any) {
    this.router.navigateByUrl(page);
  }
}
