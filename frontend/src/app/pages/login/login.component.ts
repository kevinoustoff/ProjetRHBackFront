import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { AuthResponse } from '../../models/AuthResponse';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit{
  loginForm!: FormGroup;

  constructor(private fb: FormBuilder,private authService:AuthService,private router:Router) {}

  ngOnInit() {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }

    this.authService.login(this.loginForm.value)
      .subscribe((response:AuthResponse) => {
        sessionStorage.setItem("ACCESS_TOKEN",response.accessToken);
        this.router.navigateByUrl("/offres-rh");
      });
  }
}
