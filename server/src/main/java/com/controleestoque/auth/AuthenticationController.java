package com.controleestoque.auth;


import com.controleestoque.auth.dto.AuthenticationRequest;
import com.controleestoque.auth.dto.AuthenticationResponse;
import com.controleestoque.auth.dto.RegiterRequest;
import com.controleestoque.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @CrossOrigin("*")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegiterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));


    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));


    }

}