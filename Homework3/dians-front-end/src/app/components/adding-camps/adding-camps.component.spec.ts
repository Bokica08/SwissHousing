import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddingCampsComponent } from './adding-camps.component';

describe('AddingCampsComponent', () => {
  let component: AddingCampsComponent;
  let fixture: ComponentFixture<AddingCampsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddingCampsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddingCampsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
