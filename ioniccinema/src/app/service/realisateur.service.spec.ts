import { TestBed } from '@angular/core/testing';

import { RealisateurService } from './realisateur.service';

describe('RealisateurService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RealisateurService = TestBed.get(RealisateurService);
    expect(service).toBeTruthy();
  });
});
