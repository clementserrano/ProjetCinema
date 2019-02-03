import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogAddRealisateurComponent } from './dialog-add-realisateur.component';

describe('DialogAddRealisateurComponent', () => {
  let component: DialogAddRealisateurComponent;
  let fixture: ComponentFixture<DialogAddRealisateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogAddRealisateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogAddRealisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
