import { Component, OnInit } from '@angular/core';
import { Employee } from '../../employee';
import { ConfigService } from '../../config/config.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { AlpineHut } from 'src/app/alpinehut';
import { AuthService } from '../../_services/auth.service';
import { StorageService } from '../../_services/storage.service';
import { ActivatedRoute, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  public employees!: Employee[];
  public editEmployee!: Employee;
  public deleteEmployee!: Employee;
  public alpinehuts!: AlpineHut[];
  public editHut!: AlpineHut;
  public deleteHut!: AlpineHut;
  public isCollapsed = true;




  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;

  constructor(private employeeService: ConfigService, private storageService: StorageService, private authService: AuthService,private activateRoute: ActivatedRoute,) {
    //this.isLoggedIn=this.activateRoute.snapshot.data['data5']
   }
  //  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
  //   throw new Error('Method not implemented.');
  // }

  ngOnInit() {
    // if(this.isLoggedIn==undefined || this.isLoggedIn==null){
    //   if (this.isLoggedIn) {
    //     const user = this.storageService.getUser();
    //     this.roles = user.roles;
  
    //     this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
    //     this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
  
    //     this.username = user.username;
    //   }
    // }else{
      this.isLoggedIn=this.storageService.isLoggedIn();
      const user = this.storageService.getUser();
        this.roles = user.roles;
  
        this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
        this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
  
        this.username = user.username;
    //}
    //this.isLoggedIn = this.storageService.isLoggedIn();

    
    

  }

  public getEmployees(): void {
    
    this.employeeService.getEmployees().subscribe(
      
      (response: Employee[]) => {
        this.employees = response;
        console.log(this.employees);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      
    );
    
  }

  public onAddEmloyee(addForm: NgForm): void {
    
    document.getElementById('add-employee-form')!.click();
    this.employeeService.addEmployee(addForm.value).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployees();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
    
  }

  public onUpdateEmloyee(employee: Employee): void {
    
    this.employeeService.updateEmployee(employee.locationId!).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    
  }

  public onDeleteEmloyee(employeeId: number): void {
    
    this.employeeService.deleteEmployee(employeeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    
  }

  public searchEmployees(key: string): void {
    
    console.log(key);
    const results: Employee[] = [];
    for (const employee of this.employees) {
      if (employee.name?.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.city?.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.houseNumber?.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.street?.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(employee);
      }
    }
    this.employees = results;
    
    if (results.length === 0 || !key) {
      this.getEmployees();
    }
  }
  public searchEmployeesByCity(key: string): void {
    
    console.log(key);
    const results: Employee[] = [];
    for (const employee of this.employees) {
      if (employee.city?.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.city?.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.city?.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.city?.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(employee);
      }
    }
    this.employees = results;
    
    if (results.length === 0 || !key) {
      this.getEmployees();
    }
  }

  

  public onOpenModal(employee: any, mode: string): void {
    
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (mode === 'edit') {
      this.editEmployee = employee;
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    if (mode === 'delete') {
      this.deleteEmployee = employee;
      button.setAttribute('data-target', '#deleteEmployeeModal');
    }
    
    container!.appendChild(button);
    button.click();
  }

  isObject(value: any): boolean { 
    
    return typeof value === 'object'; }

    logout(): void {
      ;
      this.authService.logout().subscribe({
        next: res => {
          console.log(res);
          this.storageService.clean();
  
          window.location.reload();
          this.ngOnInit();
        },
        error: err => {
          console.log(err);
        }
      });
    }

}