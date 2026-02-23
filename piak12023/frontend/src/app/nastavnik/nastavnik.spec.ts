import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Nastavnik } from './nastavnik';

describe('Nastavnik', () => {
  let component: Nastavnik;
  let fixture: ComponentFixture<Nastavnik>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Nastavnik]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Nastavnik);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
