import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import { LoginComponent } from './pages/login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { FolderListComponent } from './pages/folder-list/folder-list.component';
import {MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import { JwtInterceptor } from './interceptors/JwtInterceptor';
import { FileListComponent } from './pages/file-list/file-list.component';
import { OffresRHComponent } from './pages/offres-rh/offres-rh.component';
import { AgGridModule } from 'ag-grid-angular'; 
import { AllCommunityModule } from 'ag-grid-community';
import { MenuComponent } from './layout/menu/menu.component';
import {HomeComponent} from "./pages/home/home.component";



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FolderListComponent,
    FileListComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    MatListModule,
    FormsModule,
  
    
  ],
  providers: [
    provideAnimationsAsync(),
      { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }
