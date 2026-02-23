import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  imports: [],
  templateUrl: './logout.html',
  styleUrl: './logout.css',
})
export class Logout {
 private router = inject(Router)

  logout() {
    localStorage.clear();
    this.router.navigate(['']);
  }
}
