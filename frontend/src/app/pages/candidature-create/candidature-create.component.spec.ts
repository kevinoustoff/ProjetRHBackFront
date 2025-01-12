import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatureCreateComponent } from './candidature-create.component';

describe('CandidatureCreateComponent', () => {
  let component: CandidatureCreateComponent;
  let fixture: ComponentFixture<CandidatureCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CandidatureCreateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CandidatureCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
