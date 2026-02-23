import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetaljiAdmin } from './detalji-admin';

describe('DetaljiAdmin', () => {
  let component: DetaljiAdmin;
  let fixture: ComponentFixture<DetaljiAdmin>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetaljiAdmin]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetaljiAdmin);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
