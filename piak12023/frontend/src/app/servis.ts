import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Aktivnosti, Korisnici } from './models/models';

@Injectable({
  providedIn: 'root',
})
export class Servis {
 
  url = 'http://localhost:8080/prijave';
  
  constructor() { }

  http = inject(HttpClient)

  prijava(username: string, password: string, tip: string) {
    const data = {
      korisnicko_ime: username,
      lozinka: password,
      tip: tip,
    };
    return this.http.post<Korisnici>(`${this.url}/prijava`, data);
  }

   aktuelneAktivnosti() {
    return this.http.get<Aktivnosti[]>(`${this.url}/aktuelne`);
  }
  
}
