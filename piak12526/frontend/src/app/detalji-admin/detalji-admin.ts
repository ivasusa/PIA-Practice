import { Component, inject } from '@angular/core';
import { Service } from '../service';
import { ActivatedRoute, Router } from '@angular/router';
import { Proizvod } from '../models/Modeli';
import { Logout } from "../logout/logout";

@Component({
  selector: 'app-detalji-admin',
  imports: [Logout],
  templateUrl: './detalji-admin.html',
  styleUrl: './detalji-admin.css',
})
export class DetaljiAdmin {
izmeni() {
  const naziv = localStorage.getItem('izabranProizvodNaziv');
  if (naziv) {
    this.router.navigate(['/izmena', naziv]);
  }
}
private servis = inject(Service)
  private router = inject(Router)
  private route = inject(ActivatedRoute)
  proizvod: Proizvod | null = null;

  ngOnInit(): void {
    const naziv = this.route.snapshot.paramMap.get('naziv');
    if (!naziv) {
      this.router.navigate(['/']);
      return;
    }

    this.servis.detaljProizvod(naziv).subscribe(data => {
      this.proizvod = data;
    });
  }

}
