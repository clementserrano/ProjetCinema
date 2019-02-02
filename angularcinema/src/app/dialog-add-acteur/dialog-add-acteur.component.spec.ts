import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogAddActeurComponent } from './dialog-add-acteur.component';

describe('DialogAddActeurComponent', () => {
  let component: DialogAddActeurComponent;
  let fixture: ComponentFixture<DialogAddActeurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogAddActeurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogAddActeurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
