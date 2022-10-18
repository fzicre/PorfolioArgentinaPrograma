import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Banner } from 'src/app/model/banner';
import { BannerService } from 'src/app/service/banner.service';

@Component({
  selector: 'app-new-banner',
  templateUrl: './new-banner.component.html',
  styleUrls: ['./new-banner.component.css']
})
export class NewBannerComponent implements OnInit {
  nombre: string;
  bgi: string;
  

  constructor(private bannerService: BannerService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const banner = new Banner(this.nombre, this.bgi);
    this.bannerService.save(banner).subscribe(
      data =>{
        alert("banner info añadida correctamente");
        this.router.navigate(['']);
      }, err =>{
        alert("falló");
        this.router.navigate(['']);
      }
    )
  }
}
