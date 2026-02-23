import { Component, inject } from '@angular/core';
import { Logout } from "../logout/logout";
import { Aktivnosti, Korisnici } from '../models/models';
import { Servis } from '../servis';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student',
  imports: [Logout],
  templateUrl: './student.html',
  styleUrl: './student.css',
})
export class Student {
ulogovan: Korisnici = new Korisnici();
  aktuelneAktivnosti: Aktivnosti[] = [];

  private router = inject(Router)
  private aktivnostiServis = inject(Servis)

  ngOnInit(): void {
    let x = localStorage.getItem("ulogovan");
    if (x != null) {
      this.ulogovan = JSON.parse(x);

      this.aktivnostiServis.aktuelneAktivnosti().subscribe(data => {
        this.aktuelneAktivnosti = data;
      });
    }
  }

  prijavi(aktivnost: Aktivnosti) {
    // Ispravnije bi bilo da prosledjujemo aktivnost, tj. njen identifikator kao parametar,
    // ali s obzirom na to da nam na narednoj strani trebaju i podaci o aktivnosti,
    // kako ne bismo vise puta bespotrebno dohvatali iz baze podatke,
    // sacuvacemo podatke o aktivnosti u localStorage objektu
    localStorage.setItem("selektovana", JSON.stringify(aktivnost));
    this.router.navigate(['/prijava']);
  }
}
