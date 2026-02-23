import { Component, inject } from '@angular/core';
import { Servis } from '../servis';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
private servis = inject(Servis)
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
      this.servis.prijava(this.username, this.password, this.tip).subscribe(data => {
          if (data == null) {
            this.greska = 'Takav korisnik u bazi ne postoji';
          } else {
            localStorage.setItem('ulogovan', JSON.stringify(data));
            if (data.tip == 'kupac') {
              this.router.navigate(['/kupac']);
            } else if (data.tip == 'prodavac') {
              this.router.navigate(['/prodavac']);
            } else {
              this.greska = 'Nepoznat tip korisnika';
            }
          }
        });
    }
  }
}
