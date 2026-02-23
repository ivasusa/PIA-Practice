export class Korisnik {
  korisnicko_ime: string = '';
  lozinka: string = '';
  ime: string = '';
  prezime: string = '';
    mejl: string = '';
  tip: string = '';
}

export class Aukcija {
  idA: number = 0;
  naziv: string = '';
  pocetak: string = '';
  kraj: string = '';
}

export class Umetnina {
    idU: number = 0;
    idA: number = 0;
    naziv: string = '';
    ponuda: number = 0;
    vlasnik: string = '';
    novaPonuda: number = 0;

}
 
