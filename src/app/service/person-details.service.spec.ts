import { TestBed } from '@angular/core/testing';

import { PersonRegistationService } from './person-details.service';

describe('PersonRegistationService', () => {
  let service: PersonRegistationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PersonRegistationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
