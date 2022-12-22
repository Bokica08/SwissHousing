import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditingHotelsComponent } from './editing-hotels.component';

describe('EditingHotelsComponent', () => {
  let component: EditingHotelsComponent;
  let fixture: ComponentFixture<EditingHotelsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditingHotelsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditingHotelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
