import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddingGuestshousesComponent } from './adding-guestshouses.component';

describe('AddingGuestshousesComponent', () => {
  let component: AddingGuestshousesComponent;
  let fixture: ComponentFixture<AddingGuestshousesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddingGuestshousesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddingGuestshousesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
