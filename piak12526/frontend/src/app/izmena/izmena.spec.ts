import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Izmena } from './izmena';

describe('Izmena', () => {
  let component: Izmena;
  let fixture: ComponentFixture<Izmena>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Izmena]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Izmena);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
