export class Korisnik {
  kor_ime: string = '';
  lozinka: string = '';
  ime: string = '';
  prezime: string = '';
  mejl: string = '';
  tip: string = '';
}


export class Komentar{
    idK: number = 0;    
    proizvod: number = 0;
    tekst: string = ''
    korisnik: string = '';
    status: string = '';

}

export class Narudzbina{
    idN: number = 0;
    proizvod: number = 0;
    kolicina: number = 0;
    kupac: string = ''; 
}


export class Proizvod {
  idP: number = 0;
  naziv: string = '';
  opis: string = '';
  cena: number = 0;
  slika: string = '';
}
