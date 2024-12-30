import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OffresRHComponent } from './offres-rh.component';

describe('OffresRHComponent', () => {
  let component: OffresRHComponent;
  let fixture: ComponentFixture<OffresRHComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OffresRHComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OffresRHComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
