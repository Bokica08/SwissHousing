import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddingHutsComponent } from './adding-huts.component';

describe('AddingHutsComponent', () => {
  let component: AddingHutsComponent;
  let fixture: ComponentFixture<AddingHutsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddingHutsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddingHutsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
