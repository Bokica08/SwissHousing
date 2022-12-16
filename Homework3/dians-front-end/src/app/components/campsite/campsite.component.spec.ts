import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CampsiteComponent } from './campsite.component';

describe('CampsiteComponent', () => {
  let component: CampsiteComponent;
  let fixture: ComponentFixture<CampsiteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CampsiteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CampsiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
