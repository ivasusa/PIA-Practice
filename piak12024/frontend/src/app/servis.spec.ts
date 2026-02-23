import { TestBed } from '@angular/core/testing';

import { Servis } from './servis';

describe('Servis', () => {
  let service: Servis;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Servis);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
