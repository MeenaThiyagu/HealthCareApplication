import { TestBed } from '@angular/core/testing';

import { DrugRegistrationServiceService } from './drug-registration-service.service';

describe('DrugRegistrationServiceService', () => {
  let service: DrugRegistrationServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DrugRegistrationServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
