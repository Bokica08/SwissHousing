import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { environment } from '../enviroment/enviroment';
import { AlpineHut } from '../alpinehut';
import { GuestHouse } from '../guest-house.model';
import { CampSite } from '../camp-site.model';

@Injectable({providedIn: 'root'})
export class ConfigService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}
  public getHuts(): Observable<AlpineHut[]> {
    
    return this.http.get<AlpineHut[]>(`${this.apiServerUrl}/alpinehut`);
    
  }

  public getEmployees(): Observable<Employee[]> {
    
    return this.http.get<Employee[]>(`${this.apiServerUrl}/hotel`);
    
  }
  public getHouses(): Observable<GuestHouse[]> {
    
    return this.http.get<GuestHouse[]>(`${this.apiServerUrl}/guesthouse`);
    
  }
  public getCamps(): Observable<CampSite[]> {
    
    return this.http.get<CampSite[]>(`${this.apiServerUrl}/campsite`);
    
  }
  public addEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiServerUrl}/hotel/add`, employee);
  }
  public addHut(hut: AlpineHut): Observable<AlpineHut> {
    return this.http.post<AlpineHut>(`${this.apiServerUrl}/alpinehut/add`, hut);
  }
  public addHouse(house: GuestHouse): Observable<GuestHouse> {
    return this.http.post<GuestHouse>(`${this.apiServerUrl}/guesthouse/add`, house);
  }
  public addCamp(camp: CampSite): Observable<CampSite> {
    return this.http.post<CampSite>(`${this.apiServerUrl}/campsite/add`, camp);
  }

  public updateEmployee(employeeId: number): Observable<Employee> {
    return this.http.delete<Employee>(`${this.apiServerUrl}/hotel/edit/${employeeId}`);
  }
  public updateHut(hutid: number): Observable<AlpineHut> {
    return this.http.delete<AlpineHut>(`${this.apiServerUrl}/alpinehut/edit/${hutid}`);
  }
  public updateHouse(houseid: number): Observable<GuestHouse> {
    return this.http.delete<GuestHouse>(`${this.apiServerUrl}/guesthouse/edit/${houseid}`);
  }
  public updateCamp(campid: number): Observable<CampSite> {
    return this.http.delete<CampSite>(`${this.apiServerUrl}/campsite/edit/${campid}`);
  }

  public deleteEmployee(employeeId: number): Observable<void> {
    return this.http.get<void>(`${this.apiServerUrl}/location/delete/${employeeId}`);
  }
  public deleteHut(hutid: number): Observable<void> {
    return this.http.get<void>(`${this.apiServerUrl}/location/delete/${hutid}`);
  }
  public deleteHouse(houseid: number): Observable<void> {
    return this.http.get<void>(`${this.apiServerUrl}/location/delete/${houseid}`);
  }
  public deleteCamp(campid: number): Observable<void> {
    return this.http.get<void>(`${this.apiServerUrl}/location/delete/${campid}`);
  }
  public getByCity(city:string):Observable<Employee[]>{
    let queryParams= new HttpParams();
    queryParams=queryParams.append("city",city)
    return this.http.get<Employee[]>(`${this.apiServerUrl}/hotel/city`,{params:queryParams})
  }
  public getByCityHut(city:string):Observable<AlpineHut[]>{
    let queryParams= new HttpParams();
    queryParams=queryParams.append("city",city)
    return this.http.get<AlpineHut[]>(`${this.apiServerUrl}/alpinehut/city`,{params:queryParams})
  }
  public getByCityHouse(city:string):Observable<GuestHouse[]>{
    let queryParams= new HttpParams();
    queryParams=queryParams.append("city",city)
    return this.http.get<GuestHouse[]>(`${this.apiServerUrl}/guesthouse/city`,{params:queryParams})
  }
  public getByCityCamp(city:string):Observable<CampSite[]>{
    let queryParams= new HttpParams();
    queryParams=queryParams.append("city",city)
    return this.http.get<CampSite[]>(`${this.apiServerUrl}/campsite/city`,{params:queryParams})
  }

  public getByName(name:string):Observable<Employee[]>{
    let queryParams=new HttpParams();
    queryParams=queryParams.append("name",name)
    return this.http.get<Employee[]>(`${this.apiServerUrl}/hotel/cname`,{params:queryParams})
  }
  public getByNameHut(name:string):Observable<AlpineHut[]>{
    let queryParams=new HttpParams();
    queryParams=queryParams.append("name",name)
    return this.http.get<AlpineHut[]>(`${this.apiServerUrl}/alpinehut/cname`,{params:queryParams})
  }
  public getByNameHouse(name:string):Observable<GuestHouse[]>{
    let queryParams=new HttpParams();
    queryParams=queryParams.append("name",name)
    return this.http.get<GuestHouse[]>(`${this.apiServerUrl}/guesthouse/cname`,{params:queryParams})
  }
  public getByNameCamp(name:string):Observable<CampSite[]>{
    let queryParams=new HttpParams();
    queryParams=queryParams.append("name",name)
    return this.http.get<CampSite[]>(`${this.apiServerUrl}/campsite/cname`,{params:queryParams})
  }

  public getByStars(stars:number):Observable<Employee[]>{
    let queryParams=new HttpParams();
    queryParams=queryParams.append("stars",stars)
    return this.http.get<Employee[]>(`${this.apiServerUrl}/hotel/stars`,{params:queryParams});
  }
  public getGHouse(id:number):Observable<GuestHouse[]>{
    let queryParams=new HttpParams();
    return this.http.get<GuestHouse[]>(`${this.apiServerUrl}/guesthouse/${id}`);
  }

  public getUser(username:string):Observable<any>{
    let queryParams=new HttpParams();
    queryParams=queryParams.append("username",username)
    return this.http.get<CampSite[]>(`${this.apiServerUrl}/user/get`,{params:queryParams})
  }
}