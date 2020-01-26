import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UIRoutingModule } from './ui-routing.module';
import { UiComponent } from '../ui/ui.component';
import { LayoutComponent } from '@layout/layout.component';
import { HeaderTopComponent } from '@pages/Navbar/header-top/header-top.component';
import { LeftSidebarComponent } from '@pages/Navbar/left-sidebar/left-sidebar.component';
import { PageTopbarComponent } from '@pages/Navbar/page-topbar/page-topbar.component'; 
import { FooterComponent } from '@pages/footer/footer.component';
import { LoginComponent } from '@pages/Authentication/login/login.component';
import { UserComponent } from '@pages/Hrms/user/user.component'; 
import { ForgotPasswordComponent } from '@pages/Authentication/forgot-password/forgot-password.component';
import { PageNotFoundComponent } from '@pages/Authentication/page-not-found/page-not-found.component';
import { PageNotWorkingComponent } from '@pages/Authentication/page-not-working/page-not-working.component';
import { FontAwesomeComponent } from '@pages/Icon/font-awesome/font-awesome.component';
import { FeatherComponent } from '@pages/Icon/feather/feather.component';
import { LineIconComponent } from '@pages/Icon/line-icon/line-icon.component';
import { FlagIconComponent } from '@pages/Icon/flag-icon/flag-icon.component';
import { PaymentIconComponent } from '@pages/Icon/payment-icon/payment-icon.component';
 
 
import { NgZorroAntdModule, NZ_I18N, en_US } from 'ng-zorro-antd';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'; 
import { DashboardComponent } from './dashboard/dashboard.component';
registerLocaleData(en);


@NgModule({
  declarations: [UiComponent,LayoutComponent ,
    HeaderTopComponent,
    LeftSidebarComponent,
    PageTopbarComponent,
    DashboardComponent,
    FooterComponent,
    LoginComponent,
    UserComponent,
    
    ForgotPasswordComponent,
    PageNotFoundComponent,
    PageNotWorkingComponent,
    FontAwesomeComponent,
    FeatherComponent,
    LineIconComponent,
    FlagIconComponent,
    PaymentIconComponent
   ],
  imports: [
    CommonModule,
    UIRoutingModule,
    FormsModule,
    HttpClientModule,
  
    /** import ng-zorro-antd root module，you should import NgZorroAntdModule and avoid importing sub modules directly **/
    NgZorroAntdModule
  ],
  providers:[
    { provide: NZ_I18N, useValue: en_US }
  ],
  exports: [UiComponent] 
})
export class UIModule { }
