import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from "@angular/router";
import { Observable } from "rxjs";
import { ConfigService } from "../config/config.service";
import { Employee } from "../employee";
import { AlpineHut } from "../alpinehut";
import { GuestHouse } from "../guest-house.model";
import { CampSite } from "../camp-site.model";
import { StorageService } from "../_services/storage.service";


@Injectable({providedIn:'root'})
export class dataResolverServiceHotel implements Resolve<Employee[]>{

    constructor(private configService:ConfigService){

    }


    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Employee[] | Observable<Employee[]> | Promise<Employee[]> {
        {
            return this.configService.getEmployees();
        }
    }
    
}
@Injectable({providedIn:'root'})
export class dataResolverServiceHut implements Resolve<AlpineHut[]>{

    constructor(private configService:ConfigService){

    }


    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): AlpineHut[] | Observable<AlpineHut[]> | Promise<AlpineHut[]> {
        {
            return this.configService.getHuts();
        }
    }
    
}
@Injectable({providedIn:'root'})
export class dataResolverServiceHouse implements Resolve<GuestHouse[]>{

    constructor(private configService:ConfigService){

    }


    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): GuestHouse[] | Observable<GuestHouse[]> | Promise<GuestHouse[]> {
        {
            return this.configService.getHouses();
        }
    }
    
}
@Injectable({providedIn:'root'})
export class dataResolverServiceCamp implements Resolve<CampSite[]>{

    constructor(private configService:ConfigService){

    }


    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): CampSite[] | Observable<CampSite[]> | Promise<CampSite[]> {
        {
            return this.configService.getCamps();
        }
    }

  
}
@Injectable({providedIn:'root'})
export class dataResolverLoggedIn implements Resolve<boolean>{

    constructor(private storageService:StorageService){

    }


    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
        {
            debugger;
            return this.storageService.isLoggedIn();
        }
    }

  
}
@Injectable({providedIn:'root'})
export class dataResolverGetAdmin implements Resolve<any>{

    constructor(private storageService:StorageService){

    }


    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): any | Observable<any> | Promise<any> {
        {
            debugger;
            return this.storageService.getUser();
        }
    }

  
}
// @Injectable({providedIn:'root'})
// export class dataResolverGetUser implements Resolve<any>{

//     constructor(private configService:ConfigService){

//     }


//     resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): any | Observable<any> | Promise<any> {
//         {
//             debugger;
//             return this.configService.getUser(username);
//         }
//     }

  
// }