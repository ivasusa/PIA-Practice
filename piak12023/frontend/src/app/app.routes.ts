import { Routes } from '@angular/router';
import { Login } from './login/login';
import { Nastavnik } from './nastavnik/nastavnik';
import { Student } from './student/student';

export const routes: Routes = [
    { path: "", component: Login },
  { path: "student", component: Student },
  { path: "nastavnik", component: Nastavnik },
];
