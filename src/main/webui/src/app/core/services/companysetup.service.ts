import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfig } from '@core/model/AppConfig';
import { Observable } from 'rxjs';
import { CompanyInfo } from '@core/model/CompanyInfo';
import { map } from 'rxjs/operators';
import { FormSubmitResponse } from '@core/model/FormSubmitResponse';
import { AppService } from './app.service';
@Injectable( )
export class CompanySetupService {

  constructor(private http: HttpClient) {
    
   }
  
   loadCompanyInfo() : Observable<CompanyInfo>{
    return this.http.get<CompanyInfo>("/api/company/load").pipe(map(resp=>resp['data']));
   }
   saveCompanyInfo(formData: FormData) : Observable<FormSubmitResponse>{
    return this.http.post<FormSubmitResponse>("/api/company/save",formData);
   }
}
