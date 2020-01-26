import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AppService} from '@core/services'


@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers:[
    AppService
  ]

})
export class CoreModule { 
  static forRoot(): ModuleWithProviders {
    return {
        ngModule: CoreModule
    };
}
}
