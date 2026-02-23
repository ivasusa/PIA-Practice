import { Component, inject } from '@angular/core';
import { Proizvod } from '../models/Modeli';
import { ActivatedRoute, Router } from '@angular/router';
import { Service } from '../service';
import { Logout } from "../logout/logout";

@Component({
  selector: 'app-detalji',
  imports: [Logout],
  templateUrl: './detalji.html',
  styleUrl: './detalji.css',
})
export class Detalji {

  private servis = inject(Service)
  private router = inject(Router)
  private route = inject(ActivatedRoute)
  proizvod: Proizvod | null = null;
  poruka: string = '';

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

  pregledajKorpu() {
    var username = localStorage.getItem('name');
    this.router.navigate([`/korpa/${username}`]);
  }
  dodajUKorpu() {
  if (!this.proizvod) return;

  const korpa: Proizvod[] = JSON.parse(localStorage.getItem('korpa') || '[]');

  const postoji = korpa.some(s => s.naziv === this.proizvod!.naziv);
  if (postoji) {
    this.poruka = 'Proizvod je vec u korpi.';
    return;
  }

  korpa.push({
    naziv: this.proizvod.naziv,
    cena: this.proizvod.cena,
    opis: this.proizvod.opis,
  });

  localStorage.setItem('korpa', JSON.stringify(korpa));
  this.poruka = 'Proizvod dodat u korpu.';
}

}
