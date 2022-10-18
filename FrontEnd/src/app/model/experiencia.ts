export class Experiencia {


        id? : number;
        nombreE : string;
        descripcionE : string;
        fechaE: string;
        obsE: string;
    
        constructor(nombreE: string, descripcionE: string, fechaE: string, obsE: string){
            this.nombreE = nombreE;
            this.descripcionE = descripcionE;
            this.fechaE = fechaE;
            this.obsE = obsE;
        }
    }


