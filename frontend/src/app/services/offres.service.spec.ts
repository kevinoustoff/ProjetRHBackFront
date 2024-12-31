import { TestBed } from '@angular/core/testing';

import { OffresService } from './offres.service';

describe('OffresService', () => {
  let service: OffresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OffresService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
