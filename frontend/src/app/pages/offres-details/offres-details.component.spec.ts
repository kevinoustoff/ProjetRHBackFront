import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OffresDetailsComponent } from './offres-details.component';

describe('OffresDetailsComponent', () => {
  let component: OffresDetailsComponent;
  let fixture: ComponentFixture<OffresDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OffresDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OffresDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
