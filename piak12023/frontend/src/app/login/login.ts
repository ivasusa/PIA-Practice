import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Servis } from '../servis';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  private korisnikServis = inject(Servis)
  private router = inject(Router)

  username: string = "";
  password: string = "";
  tip: string = "";
  greska: string = "";

  login() {
    if (this.username == "") {
      this.greska = "Nije uneto korisnicko ime";
    }
    else if (this.password == "") {
      this.greska = "Nije uneta lozinka";
    }
    else if (this.tip == "") {
      this.greska = "Nije unet tip";
    }
    else {
      this.korisnikServis.prijava(this.username, this.password, this.tip).subscribe(data => {
          if (data == null) {
            this.greska = 'Takav korisnik u bazi ne postoji';
          } else {
            localStorage.setItem('ulogovan', JSON.stringify(data));
            if (data.tip == 'student') {
              this.router.navigate(['/student']);
            } else if (data.tip == 'nastavnik') {
              this.router.navigate(['/nastavnik']);
            } else {
              this.greska = 'Nepoznat tip korisnika';
            }
          }
        });
    }
  }
}
