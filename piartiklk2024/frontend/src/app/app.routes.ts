import { Routes } from '@angular/router';
import { Login } from './login/login';
import { Kupac } from './kupac/kupac';
import { Administrator } from './administrator/administrator';
import { Detalji } from './detalji/detalji';

export const routes: Routes = [
      { path: "", component: Login },
  { path: "kupac", component: Kupac },
  { path: "administrator", component: Administrator },
    { path: "detalji/:naziv", component: Detalji },
];
