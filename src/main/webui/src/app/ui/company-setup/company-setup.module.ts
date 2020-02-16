import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompanySetupComponent } from './company-setup.component';
import { Routes, RouterModule } from '@angular/router';
import { ComplianceInfoComponent } from './compliance-info/compliance-info.component';
import { BranchComponent } from './branch/branch.component';
import { DepartmentComponent } from './department/department.component';
import { BankComponent } from './bank/bank.component';
import { FinancialYearComponent } from './financial-year/financial-year.component';
import { DesignationComponent } from './designation/designation.component';
import { CompanyInfoComponent } from './company-info/company-info.component';
import { NgZorroAntdModule } from 'ng-zorro-antd';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [
   
  { path: '', 
    component: CompanySetupComponent,
    children:[
      {
        path:"company-info",
        component:CompanyInfoComponent
      }
    ]

} 
];
@NgModule({
  declarations: [CompanySetupComponent, ComplianceInfoComponent, BranchComponent, DepartmentComponent, BankComponent, FinancialYearComponent, DesignationComponent, CompanyInfoComponent],
  imports: [
    NgZorroAntdModule,
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ],
  entryComponents:[CompanySetupComponent],
  exports: [CompanySetupComponent, RouterModule, ComplianceInfoComponent, BranchComponent, DepartmentComponent, BankComponent, FinancialYearComponent, DesignationComponent, CompanyInfoComponent] 
})
export class CompanySetupModule { }
