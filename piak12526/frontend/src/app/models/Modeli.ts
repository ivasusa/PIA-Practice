export class Korisnik {
  kor_ime: string = '';
  lozinka: string = '';
  tip: string = '';

}

export class Narudzbina {
  idN: number = 0;
  kupac: string = '';
  proizvodi: string = '';
  racun: number = 0;
  datum: string = '';

}

export class Proizvod {
  naziv: string = '';
  opis: string = '';
  cena: number = 0;
}
