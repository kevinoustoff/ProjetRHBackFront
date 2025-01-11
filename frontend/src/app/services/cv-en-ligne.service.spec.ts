import { TestBed } from '@angular/core/testing';

import { CvEnLigneService } from './cv-en-ligne.service';

describe('CvEnLigneService', () => {
  let service: CvEnLigneService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CvEnLigneService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
