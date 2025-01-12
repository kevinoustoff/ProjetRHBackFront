import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidaturesRhComponent } from './candidatures-rh.component';

describe('CandidaturesRhComponent', () => {
  let component: CandidaturesRhComponent;
  let fixture: ComponentFixture<CandidaturesRhComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CandidaturesRhComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CandidaturesRhComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
