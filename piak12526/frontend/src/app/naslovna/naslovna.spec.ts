import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Naslovna } from './naslovna';

describe('Naslovna', () => {
  let component: Naslovna;
  let fixture: ComponentFixture<Naslovna>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Naslovna]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Naslovna);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
