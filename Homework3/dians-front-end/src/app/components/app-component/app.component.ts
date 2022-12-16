
import { Component, OnInit } from '@angular/core';
import { Employee } from '../../employee';
import { ConfigService } from '../../config/config.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

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
  public isCollapsed = true;


  constructor(private employeeService: ConfigService){}

  ngOnInit() {
    

  }

  public getEmployees(): void {
    debugger
    this.employeeService.getEmployees().subscribe(
      
      (response: Employee[]) => {
        this.employees = response;
        console.log(this.employees);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      
    );
    debugger
  }

  public onAddEmloyee(addForm: NgForm): void {
    debugger
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
    debugger
  }

  public onUpdateEmloyee(employee: Employee): void {
    debugger
    this.employeeService.updateEmployee(employee.locationId!).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    debugger
  }

  public onDeleteEmloyee(employeeId: number): void {
    debugger
    this.employeeService.deleteEmployee(employeeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    debugger
  }

  public searchEmployees(key: string): void {
    debugger
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
    debugger
    if (results.length === 0 || !key) {
      this.getEmployees();
    }
  }
  public searchEmployeesByCity(key: string): void {
    debugger
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
    debugger
    if (results.length === 0 || !key) {
      this.getEmployees();
    }
  }

  

  public onOpenModal(employee: any, mode: string): void {
    debugger
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
    debugger
    container!.appendChild(button);
    button.click();
  }

  isObject(value: any): boolean { 
    debugger
    return typeof value === 'object'; }

}