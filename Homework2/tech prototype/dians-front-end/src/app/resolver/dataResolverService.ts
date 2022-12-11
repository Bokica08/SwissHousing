import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from "@angular/router";
import { Observable } from "rxjs";
import { ConfigService } from "../config/config.service";
import { Employee } from "../employee";


@Injectable({providedIn:'root'})
export class dataResolverService implements Resolve<Employee[]>{

    constructor(private configService:ConfigService){

    }


    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Employee[] | Observable<Employee[]> | Promise<Employee[]> {
        {
            return this.configService.getEmployees();
        }
    }
    
}