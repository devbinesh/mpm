import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AppService,CompanySetupService} from '@core/services'


@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers:[
    AppService,CompanySetupService
  ]

})
export class CoreModule { 
  static forRoot(): ModuleWithProviders {
    return {
        ngModule: CoreModule
    };
}
}
