import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogInfoRealisateurComponent } from './dialog-info-realisateur.component';

describe('DialogInfoRealisateurComponent', () => {
  let component: DialogInfoRealisateurComponent;
  let fixture: ComponentFixture<DialogInfoRealisateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogInfoRealisateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogInfoRealisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
