import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CvEnLigneComponent } from './cv-en-ligne.component';

describe('CvEnLigneComponent', () => {
  let component: CvEnLigneComponent;
  let fixture: ComponentFixture<CvEnLigneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CvEnLigneComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CvEnLigneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
