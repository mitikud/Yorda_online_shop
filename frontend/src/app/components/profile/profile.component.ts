import {Component, OnInit, TemplateRef} from '@angular/core';
import {Profile} from "../../models/profile";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";
import {AuthService} from "../../services/auth/auth.service";
import {ActivatedRoute} from "@angular/router";
import {FileUploader} from "ng2-file-upload";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profile!: Profile;
  modalRef!: BsModalRef;
  public uploader: FileUploader = new FileUploader({});
  formData: FormData = new FormData();
  selectedFile!: string;

  constructor(private authService: AuthService, private modalService: BsModalService,
              private route: ActivatedRoute) {
    if (route.snapshot.data['profile']) {
      this.profile = route.snapshot.data['profile'];
      this.updateObject.firstname = route.snapshot.data['profile'].firstname;
      this.updateObject.lastname = route.snapshot.data['profile'].lastname;
      this.updateObject.age = route.snapshot.data['profile'].age;
      this.updateObject.email = route.snapshot.data['profile'].email;
      this.updateObject.gender = route.snapshot.data['profile'].gender;
      this.updateObject.phone = route.snapshot.data['profile'].phone;
      this.updateObject.country = route.snapshot.data['profile'].country;
      this.updateObject.city = route.snapshot.data['profile'].city;
      this.updateObject.address = route.snapshot.data['profile'].address;
    }
  }

  updateObject = {
    firstname: null,
    lastname: null,
    email: null,
    gender: null,
    age: null,
    phone: null,
    country: null,
    city: null,
    address: null
  };

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  updateProfile() {
    this.authService.updateProfile(this.updateObject).subscribe(result => {
      this.profile = result;
      this.authService.username = `${result.firstname} ${result.lastname}`;
    })
  }


  hide(): void {
    this.modalRef.hide();
  }

  ngOnInit() {
  }

  // onFileSelect(event: { target: { files: string | any[]; }; }) {
  //   if (event.target.files.length > 0) {
  //     const file = event.target.files[0] as File;
  //     this.selectedFile = file.name;
  //     this.formData.set('image', file);
  //   }
  // }

  // uploadingNewPicture() {
  //   this.authService.addProfileImage(this.formData)
  //     .subscribe(res => {
  //       this.profile = res;
  //       this.formData.delete('image');
  //       this.selectedFile = null;
  //       alert('profile image uploaded successfully');
  //     })
  // }

  // changingExistPicture() {
  //   this.authService.changeProfileImage(this.formData)
  //     .subscribe(res => {
  //       this.profile = res;
  //       this.formData.delete('image');
  //       this.selectedFile = null;
  //       alert('profile image changed successfully');
  //     });
  // }
}