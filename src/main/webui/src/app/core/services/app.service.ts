import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfig } from '@core/model/AppConfig';
import { Observable } from 'rxjs';

@Injectable( )
export class AppService {

  constructor(private http: HttpClient) {
    
   }
 
   getAppConfig(): AppConfig{
    let config: AppConfig =  JSON.parse( localStorage.getItem("config"));
   
    return config;
  }
  getLoginUser(): string{
   
    return  localStorage.getItem("username"); 
  }
  loadConfig() : Observable<AppConfig>{ 
   return  this.http.get<AppConfig>("/api/loadconfig");
    
  }
}
