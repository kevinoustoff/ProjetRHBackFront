import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OffreCreateComponent } from './offre-create.component';

describe('OffreCreateComponent', () => {
  let component: OffreCreateComponent;
  let fixture: ComponentFixture<OffreCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OffreCreateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OffreCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
