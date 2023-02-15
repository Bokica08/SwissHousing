import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsCampsComponent } from './details-camps.component';

describe('DetailsCampsComponent', () => {
  let component: DetailsCampsComponent;
  let fixture: ComponentFixture<DetailsCampsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsCampsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsCampsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
