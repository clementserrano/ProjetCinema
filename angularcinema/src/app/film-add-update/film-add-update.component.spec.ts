import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilmAddUpdateComponent } from './film-add-update.component';

describe('FilmAddUpdateComponent', () => {
  let component: FilmAddUpdateComponent;
  let fixture: ComponentFixture<FilmAddUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilmAddUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilmAddUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
