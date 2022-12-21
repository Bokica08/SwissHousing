import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlpinehutEditComponent } from './alpinehut-edit.component';

describe('AlpinehutEditComponent', () => {
  let component: AlpinehutEditComponent;
  let fixture: ComponentFixture<AlpinehutEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlpinehutEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlpinehutEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
