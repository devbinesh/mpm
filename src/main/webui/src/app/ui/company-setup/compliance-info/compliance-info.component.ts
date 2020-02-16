import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { CompanySetupService, AppService } from '@core/services';
import { CompanyInfo } from '@core/model/CompanyInfo';
import { NzMessageService, UploadFile } from 'ng-zorro-antd';
import { Observable, Observer } from 'rxjs';

@Component({
  selector: 'compliance-info',
  templateUrl: './compliance-info.component.html',
  styleUrls: ['./compliance-info.component.scss']
})
export class ComplianceInfoComponent implements OnInit {


  saving:boolean = false
  uploadMsgId : any
  loadingLogo = false;
  logoUrl: string;
  complianceInfo: CompanyInfo = new CompanyInfo()
  infoForm : FormGroup
  constructor(private appService: AppService,private  formBuilder: FormBuilder,private cinfoService: CompanySetupService,private message: NzMessageService) { }

  ngOnInit() {

    this.infoForm = this.formBuilder.group({
      businessName:new FormControl(null,Validators.required),
      businessNature:new FormControl(null),
      businessType:new FormControl(null, Validators.required),
      address:new FormControl(null, Validators.required),
      city:new FormControl(null,Validators.required),
      pincode:new FormControl(null,Validators.required),
      state:new FormControl(null,Validators.required),
      fax:new FormControl(null),
      phone:new FormControl(null,Validators.required),
      email:new FormControl(null,Validators.required),
      cinNo:new FormControl(null),
      panNo:new FormControl(null ),
      serviceTax:new FormControl(null ),
      tanNo:new FormControl(null),
      pfNo:new FormControl(null),
      empStatInsNo:new FormControl(null ),
      ptNoCo:new FormControl(null ),
      ptNoDir:new FormControl(null),
      ptNoEmp:new FormControl(null )
    })
    this.cinfoService.loadCompanyInfo().subscribe(respData=>{
      
      this.complianceInfo = respData;
    
      this.infoForm.  patchValue(this.complianceInfo);
      this.logoUrl = this.complianceInfo.logo;
    })
    
   
  }


  private getBase64(img: File, callback: (img: string) => void): void {
    const reader = new FileReader();
    reader.addEventListener('load', () => callback(reader.result!.toString()));
    reader.readAsDataURL(img);
  }
  handleChange(info: { file: UploadFile }): void {
    switch (info.file.status) {
      case 'uploading':
        this.loadingLogo = true;
        break;
      case 'done':
        // Get this url from response in real world.
        this.getBase64(info.file!.originFileObj!, (img: string) => {
          this.loadingLogo = false;
          this.logoUrl = img;
        });
        break;
      case 'error':
        this.message.error("Error while uploading logo");
        this.loadingLogo = false;
        break;
    }
  }

  
  beforeUpload = (file: File) => {
    return new Observable((observer: Observer<boolean>) => {
      const fileSupport = file.type === 'image/jpeg' || file.type === 'image/png' || file.type === 'image/svg';
      if (!fileSupport) {
        this.message.error('Please select an image file');
        observer.complete();
        return;
      }
      const isLt2M = file.size / 1024  < this.appService.getAppConfig().maxLogoSize;
      if (!isLt2M) {
        this.message.error('Image must smaller than '+this.appService.getAppConfig().maxLogoSize+'KB!');
        observer.complete();
        return;
      }
      observer.next(fileSupport && isLt2M  );
      observer.complete();
   //  this.uploadMsgId = this.message.loading('Logo upload in progress..', { nzDuration: 0 }).messageId
    });
  };
 
  onFormSubmit(){
  
    if(this.infoForm.valid &&  !this.saving){
      this.saving = true;
       
      let formData = new FormData();
      
      
      Object.keys(this.infoForm.value).forEach(item=>{
        
        formData.append(item,this.infoForm.value[item]);
      })
    
       this.cinfoService.saveCompanyInfo(formData).subscribe(resp=>{
           if(resp.success){
            this.message.success("Saved Successfully");
           }else{
            this.message.success("Error while saving company info");
           }
           this.saving = false;
       },
       resp=>{
        this.saving = false;
        this.message.success("Error while saving company info");
       }
       )
    }
  }
}
