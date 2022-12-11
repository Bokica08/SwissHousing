import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { environment } from '../enviroment/enviroment';

@Injectable({providedIn: 'root'})
export class ConfigService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getEmployees(): Observable<Employee[]> {
    
    return this.http.get<Employee[]>(`${this.apiServerUrl}/hotel`);
    
  }

  public addEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiServerUrl}/hotel/add`, employee);
  }

  public updateEmployee(employeeId: number): Observable<Employee> {
    return this.http.delete<Employee>(`${this.apiServerUrl}/hotel/edit/${employeeId}`);
  }

  public deleteEmployee(employeeId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/hotel/delete/${employeeId}`);
  }
  public getByCity(city:string):Observable<Employee[]>{
    let queryParams= new HttpParams();
    queryParams=queryParams.append("city",city)
    return this.http.get<Employee[]>(`${this.apiServerUrl}/hotel/city`,{params:queryParams})
  }

  public getByName(name:string):Observable<Employee[]>{
    let queryParams=new HttpParams();
    queryParams=queryParams.append("name",name)
    return this.http.get<Employee[]>(`${this.apiServerUrl}/hotel/cname`,{params:queryParams})
  }

  public getByStars(stars:number):Observable<Employee[]>{
    let queryParams=new HttpParams();
    queryParams=queryParams.append("stars",stars)
    return this.http.get<Employee[]>(`${this.apiServerUrl}/hotel/stars`,{params:queryParams});
  }
}