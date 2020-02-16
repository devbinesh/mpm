import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'; 
import { UiComponent } from './ui.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
 

  // Authetication Routes
 {
  path:"",
  component: UiComponent, 
  children:[
    {
      path: '',
   
      redirectTo: 'company-setup/company-info',
      pathMatch: 'full' },
   
   // Hrms Routes
 
   { path: 'dashboard', component: DashboardComponent, data: { title: ':: Epic :: Home ::' } },
   { path: 'company-setup', loadChildren: () => import('./company-setup/company-setup.module').then(m => m.CompanySetupModule)  }
  
  ]
 },
 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UIRoutingModule { }
