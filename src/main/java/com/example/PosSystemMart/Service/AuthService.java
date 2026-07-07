package com.example.PosSystemMart.Service;

import com.example.PosSystemMart.DTO.AuthResponse;
import com.example.PosSystemMart.DTO.LoginRequest;
import com.example.PosSystemMart.DTO.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
