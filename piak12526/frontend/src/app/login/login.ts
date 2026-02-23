import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Service } from '../service';


@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  private korisnikServis = inject(Service)
  private router = inject(Router)

  kor_ime: string = "";
  lozinka: string = "";
  tip: string = "";
  greska: string = "";

  login() {
    if (this.kor_ime == "") {
      this.greska = "Nije uneto korisnicko ime";
    }
    else if (this.lozinka == "") {
      this.greska = "Nije uneta lozinka";
    }
    else if (this.tip == "") {
      this.greska = "Nije unet tip";
    }
    else {
      this.korisnikServis.prijava(this.kor_ime, this.lozinka, this.tip).subscribe(data => {
          if (data == null) {
            this.greska = 'Takav korisnik u bazi ne postoji';
          } else {
            localStorage.setItem('ulogovan', JSON.stringify(data));
            localStorage.setItem('name', data.kor_ime);
            if (data.tip == 'kupac') {
              const naziv = localStorage.getItem('izabranProizvodNaziv');
              if (naziv) {
                this.router.navigate(['/detalji', naziv]);
              } else {
                this.router.navigate(['/']);
              }
            } else if (data.tip == 'prodavac') {
              const naziv = localStorage.getItem('izabranProizvodNaziv');
              if (naziv) {
                this.router.navigate(['/detaljiAdmin', naziv]);
              } else {
                this.router.navigate(['/']);
              }
            } else {
              this.greska = 'Nepoznat tip korisnika';
            }
          }
        });
    }
  }
}
