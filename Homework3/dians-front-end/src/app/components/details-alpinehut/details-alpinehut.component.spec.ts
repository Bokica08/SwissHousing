import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsAlpinehutComponent } from './details-alpinehut.component';

describe('DetailsAlpinehutComponent', () => {
  let component: DetailsAlpinehutComponent;
  let fixture: ComponentFixture<DetailsAlpinehutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsAlpinehutComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsAlpinehutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
