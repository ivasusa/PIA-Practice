import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Volonter } from './volonter';

describe('Volonter', () => {
  let component: Volonter;
  let fixture: ComponentFixture<Volonter>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Volonter]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Volonter);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
