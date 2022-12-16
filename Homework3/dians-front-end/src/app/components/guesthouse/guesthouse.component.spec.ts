import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuesthouseComponent } from './guesthouse.component';

describe('GuesthouseComponent', () => {
  let component: GuesthouseComponent;
  let fixture: ComponentFixture<GuesthouseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GuesthouseComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuesthouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
