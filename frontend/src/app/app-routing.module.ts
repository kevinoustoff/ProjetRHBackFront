import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { FolderListComponent } from './pages/folder-list/folder-list.component';
import { AuthGuard } from './guards/AuthGuard';
import { FileListComponent } from './pages/file-list/file-list.component';
import { OffresRHComponent } from './pages/offres-rh/offres-rh.component';
import {OffresDetailsComponent} from "./pages/offres-details/offres-details.component";
import {OffreCreateComponent} from "./pages/offre-create/offre-create.component";
import {HomeComponent} from "./pages/home/home.component";
import {CreateCvComponent} from "./pages/create-cv/create-cv.component";

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"offres-rh",component:OffresRHComponent,canActivate: [AuthGuard],},
  {path:"offres-rh/create",component:OffreCreateComponent,canActivate: [AuthGuard]},
  {path:"offres-rh/:id",component:OffresDetailsComponent,canActivate: [AuthGuard]},
  { path: 'mon-cv', component: CreateCvComponent },



  {path:"",component:HomeComponent,canActivate: [AuthGuard],},
  {path:"folder/:id",component:FileListComponent,canActivate: [AuthGuard],},
  {path:"**",pathMatch:'full',redirectTo:"/"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
