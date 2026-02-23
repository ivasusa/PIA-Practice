import { Routes } from '@angular/router';
import { Login } from './login/login';
import { Kupac } from './kupac/kupac';
import { Prodavac } from './prodavac/prodavac';
import { Detalji } from './detalji/detalji';

export const routes: Routes = [
     { path: "", component: Login },
  { path: "kupac", component: Kupac },
  { path: "prodavac", component: Prodavac },
    { path: "detalji/:idA", component: Detalji },

];
