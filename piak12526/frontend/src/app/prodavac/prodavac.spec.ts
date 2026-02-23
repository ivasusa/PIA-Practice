import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Prodavac } from './prodavac';

describe('Prodavac', () => {
  let component: Prodavac;
  let fixture: ComponentFixture<Prodavac>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Prodavac]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Prodavac);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
