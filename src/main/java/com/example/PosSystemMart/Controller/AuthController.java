package com.example.PosSystemMart.Controller;

import com.example.PosSystemMart.DTO.AuthResponse;
import com.example.PosSystemMart.DTO.LoginRequest;
import com.example.PosSystemMart.DTO.RegisterRequest;
import com.example.PosSystemMart.Service.AuthService;
import com.example.PosSystemMart.Util.APIResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse<AuthResponse>> register(@RequestBody @Valid RegisterRequest request) {
        AuthResponse response = authService.register(request);
        APIResponse<AuthResponse> apiResponse = APIResponse.<AuthResponse>builder()
                .status(HttpStatus.CREATED.value())
                .message("User registered successfully")
                .data(response)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse<AuthResponse>> login(@RequestBody @Valid LoginRequest request) {
        AuthResponse response = authService.login(request);
        APIResponse<AuthResponse> apiResponse = APIResponse.<AuthResponse>builder()
                .status(HttpStatus.OK.value())
                .message("User logged in successfully")
                .data(response)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
