import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalRealisateurComponent } from './modal-realisateur.component';

describe('ModalRealisateurComponent', () => {
  let component: ModalRealisateurComponent;
  let fixture: ComponentFixture<ModalRealisateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalRealisateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalRealisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
