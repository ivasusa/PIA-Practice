import { Routes } from '@angular/router';
import { Login } from './login/login';
import { Kupac } from './kupac/kupac';
import { Radnik } from './radnik/radnik';
import { Proizvodi } from './proizvod/proizvod';

export const routes: Routes = [
      { path: "", component: Login },
{ path: "kupac", component: Kupac },
  { path: "radnik", component: Radnik },
  { path: "proizvod/:id", component: Proizvodi },
];
