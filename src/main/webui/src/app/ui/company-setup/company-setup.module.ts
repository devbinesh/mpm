import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompanySetupComponent } from './company-setup.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
   
  { path: '', component: CompanySetupComponent } 
];
@NgModule({
  declarations: [CompanySetupComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [CompanySetupComponent, RouterModule] 
})
export class CompanySetupModule { }
