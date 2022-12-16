import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlpinehutComponent } from './alpinehut.component';

describe('AlpinehutComponent', () => {
  let component: AlpinehutComponent;
  let fixture: ComponentFixture<AlpinehutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlpinehutComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlpinehutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
