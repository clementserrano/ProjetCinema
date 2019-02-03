import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogDeleteFilmComponent } from './dialog-delete-film.component';

describe('DialogDeleteFilmComponent', () => {
  let component: DialogDeleteFilmComponent;
  let fixture: ComponentFixture<DialogDeleteFilmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogDeleteFilmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogDeleteFilmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
