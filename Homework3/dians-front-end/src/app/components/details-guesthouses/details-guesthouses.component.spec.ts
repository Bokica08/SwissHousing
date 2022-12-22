import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsGuesthousesComponent } from './details-guesthouses.component';

describe('DetailsGuesthousesComponent', () => {
  let component: DetailsGuesthousesComponent;
  let fixture: ComponentFixture<DetailsGuesthousesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsGuesthousesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsGuesthousesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
