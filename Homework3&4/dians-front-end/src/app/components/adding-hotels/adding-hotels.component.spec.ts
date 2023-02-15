import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddingHotelsComponent } from './adding-hotels.component';

describe('AddingHotelsComponent', () => {
  let component: AddingHotelsComponent;
  let fixture: ComponentFixture<AddingHotelsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddingHotelsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddingHotelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
