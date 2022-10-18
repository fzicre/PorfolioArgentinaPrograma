import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Banner } from 'src/app/model/banner';
import { BannerService } from 'src/app/service/banner.service';
import { BgimageService } from 'src/app/service/bgimage.service';


@Component({
  selector: 'app-edit-banner',
  templateUrl: './edit-banner.component.html',
  styleUrls: ['./edit-banner.component.css']
})
export class EditBannerComponent implements OnInit {
  banner: Banner = null;

  constructor(private activatedRouter: ActivatedRoute,
    private bannerService: BannerService, private router: Router, public bgImage : BgimageService) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.bannerService.detail(id).subscribe(
      data =>{
        this.banner = data;
      }, err =>{
         alert("Error al modificar Banner ID");
         this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.banner.bgi = this.bgImage.url
    this.bannerService.update(id, this.banner).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar el banner");
        this.router.navigate(['']);
      }
    )
  }

uploadImage($event:any){
  const id = this.activatedRouter.snapshot.params['id'];
  const name = "banner_" + id;
  this.bgImage.uploadImage($event, name)
}
}
