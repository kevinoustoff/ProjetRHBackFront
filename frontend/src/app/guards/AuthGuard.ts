import {CanActivateFn, Router, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "../services/auth.service";
import { inject } from "@angular/core";

export const AuthGuard: CanActivateFn = (

):
  Observable<boolean | UrlTree>
  | Promise<boolean | UrlTree>
  | boolean
  | UrlTree=> {

  return inject(AuthService).authenticated()
    ? true
    : inject(Router).createUrlTree(['/login']);

};
