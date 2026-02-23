import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Organizator } from './organizator';

describe('Organizator', () => {
  let component: Organizator;
  let fixture: ComponentFixture<Organizator>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Organizator]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Organizator);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
