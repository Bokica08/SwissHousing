import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditingCampsComponent } from './editing-camps.component';

describe('EditingCampsComponent', () => {
  let component: EditingCampsComponent;
  let fixture: ComponentFixture<EditingCampsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditingCampsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditingCampsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
