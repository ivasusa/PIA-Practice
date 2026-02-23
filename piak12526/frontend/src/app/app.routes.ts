import { Routes } from '@angular/router';
import { Login } from './login/login';
import { Kupac } from './kupac/kupac';
import { Prodavac } from './prodavac/prodavac';
import { Naslovna } from './naslovna/naslovna';
import { Detalji } from './detalji/detalji';
import { DetaljiAdmin } from './detalji-admin/detalji-admin';
import { Izmena } from './izmena/izmena';
import { Korpa } from './korpa/korpa';

export const routes: Routes = [
{ path: "", component: Naslovna },
{ path: "prijava", component: Login },
  { path: "detalji/:naziv", component: Detalji },
    { path: "detaljiAdmin/:naziv", component: DetaljiAdmin },
  { path: "kupac", component: Kupac },
  { path: "prodavac", component: Prodavac },
  { path: "izmena/:naziv", component: Izmena },
  { path: "korpa/:username", component: Korpa },
];
