import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditingGuesthousesComponent } from './editing-guesthouses.component';

describe('EditingGuesthousesComponent', () => {
  let component: EditingGuesthousesComponent;
  let fixture: ComponentFixture<EditingGuesthousesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditingGuesthousesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditingGuesthousesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
