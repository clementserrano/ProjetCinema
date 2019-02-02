import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogAddPersonnageComponent } from './dialog-add-personnage.component';

describe('DialogAddPersonnageComponent', () => {
  let component: DialogAddPersonnageComponent;
  let fixture: ComponentFixture<DialogAddPersonnageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogAddPersonnageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogAddPersonnageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
