import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditingHutsComponent } from './editing-huts.component';

describe('EditingHutsComponent', () => {
  let component: EditingHutsComponent;
  let fixture: ComponentFixture<EditingHutsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditingHutsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditingHutsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
