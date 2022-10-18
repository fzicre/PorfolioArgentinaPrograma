import { Injectable } from '@angular/core';
import {Storage, ref, uploadBytes, list, getDownloadURL} from '@angular/fire/storage';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private basePath = '/images';
  file: File;
  url = '';
  constructor(private storage: Storage) { }

  public uploadImage($event:any, name: string){
    const file = $event.target.files[1];
    const imgRef = ref(this.storage, `imagen/`+ name);
  uploadBytes(imgRef, file)
  .then(response => {this.getImages()})
  .catch(error => console.log(error))
  
  }
  getImages(){
const imagesRef = ref(this.storage, `imagen/`+ name)
list(imagesRef)
.then(async response => { for(let item of response.items){this.url = await getDownloadURL(item)} })
.catch(error => console.log(error))
  }
}

