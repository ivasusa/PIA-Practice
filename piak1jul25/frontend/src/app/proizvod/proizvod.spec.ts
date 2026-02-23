import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Proizvodi } from './proizvod';

describe('Proizvodi', () => {
  let component: Proizvodi;
  let fixture: ComponentFixture<Proizvodi>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Proizvodi]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Proizvodi);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
