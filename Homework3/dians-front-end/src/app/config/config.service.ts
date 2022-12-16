import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { environment } from '../enviroment/enviroment';
import { AlpineHut } from '../alpinehut';

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

  public addEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiServerUrl}/hotel/add`, employee);
  }
  public addHut(hut: AlpineHut): Observable<AlpineHut> {
    return this.http.post<AlpineHut>(`${this.apiServerUrl}/alpinehut/add`, hut);
  }

  public updateEmployee(employeeId: number): Observable<Employee> {
    return this.http.delete<Employee>(`${this.apiServerUrl}/hotel/edit/${employeeId}`);
  }
  public updateHut(hutid: number): Observable<AlpineHut> {
    return this.http.delete<AlpineHut>(`${this.apiServerUrl}/alpinehut/edit/${hutid}`);
  }
  

  public deleteEmployee(employeeId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/hotel/delete/${employeeId}`);
  }
  public deleteHut(hutid: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/alpinehut/delete/${hutid}`);
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

  public getByStars(stars:number):Observable<Employee[]>{
    let queryParams=new HttpParams();
    queryParams=queryParams.append("stars",stars)
    return this.http.get<Employee[]>(`${this.apiServerUrl}/hotel/stars`,{params:queryParams});
  }
}