import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsHotelsComponent } from './details-hotels.component';

describe('DetailsHotelsComponent', () => {
  let component: DetailsHotelsComponent;
  let fixture: ComponentFixture<DetailsHotelsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsHotelsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsHotelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
