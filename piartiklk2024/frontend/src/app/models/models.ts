export class Korisnik {
  korisnicko_ime: string = '';
  lozinka: string = '';
  ime: string = '';
  prezime: string = '';
  tip: string = '';
}

export class Narudzbina {
  id: number = 0;
  kupac: string = '';
  pica: string = '';
  velicina: string = '';
  dodaci: string = '';
  cena: number = 0;
  status: string = '';
}   


export class Pica {
    naziv: string = '';     
    cena: number = 0;
    opis: string = '';
}

export class Dodatak {
    naziv: string = '';
    cena: number = 0;
    dostupan: boolean = false;
}