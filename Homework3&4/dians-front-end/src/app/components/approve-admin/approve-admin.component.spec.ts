import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveAdminComponent } from './approve-admin.component';

describe('ApproveAdminComponent', () => {
  let component: ApproveAdminComponent;
  let fixture: ComponentFixture<ApproveAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApproveAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApproveAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
