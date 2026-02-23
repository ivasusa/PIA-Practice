export class Korisnik {
  kor_ime: string = '';
  lozinka: string = '';
  ime: string = '';
  prezime: string = '';
  mejl: string = '';
  tip: string = '';
}

export class Aktivnost {
  idA: number = 0;
  naziv: string = '';
  datum: string = '';
  potrebno: number = 0;
  prijavljeno: number = 0;
}

export class Prijava {
  idP: number = 0;
  volonter: string = '';
  aktivnost: number = 0;
  status: string = '';
}

export class PrijavljeniVolonter {
  kor_ime: string = '';
  ime: string = '';
  prezime: string = '';
  status: string = '';
}
