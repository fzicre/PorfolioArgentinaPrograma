export class Educacion {
    detail(id: any) {
      throw new Error('Method not implemented.');
    }
    id?: number;
    nombreE: string;
    descripcionE: string;

    constructor(nombreE: string, descripcionE: string){
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
}