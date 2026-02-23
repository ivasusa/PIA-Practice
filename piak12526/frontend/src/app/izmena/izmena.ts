import { Component, inject } from '@angular/core';
import { Service } from '../service';
import { ActivatedRoute, Router } from '@angular/router';
import { Proizvod } from '../models/Modeli';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-izmena',
  imports: [FormsModule],
  templateUrl: './izmena.html',
  styleUrl: './izmena.css',
})
export class Izmena {
  private servis = inject(Service);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

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

  potvrdi() {
    if (!this.proizvod) return;

    this.servis.izmeniProizvod(this.proizvod).subscribe(() => {
      this.router.navigate(['/']);
    });
  }
}
