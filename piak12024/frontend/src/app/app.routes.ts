import { Routes } from '@angular/router';
import { Volonter } from './volonter/volonter';
import { Login } from './login/login';
import { Organizator } from './organizator/organizator';
import { Detalji } from './detalji/detalji';

export const routes: Routes = [
    { path: "", component: Login},
  { path: "volonter", component: Volonter },
  { path: "organizator", component: Organizator },
  { path: "detalji/:id", component: Detalji },
];
