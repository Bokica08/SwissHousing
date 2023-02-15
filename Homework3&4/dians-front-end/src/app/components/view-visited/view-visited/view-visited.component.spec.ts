import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewVisitedComponent } from './view-visited.component';

describe('ViewVisitedComponent', () => {
  let component: ViewVisitedComponent;
  let fixture: ComponentFixture<ViewVisitedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewVisitedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewVisitedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
