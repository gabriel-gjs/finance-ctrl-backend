package com.gabriel_gjs.finance_ctrl.controller;

import com.gabriel_gjs.finance_ctrl.domain.entities.user.User;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.dtos.LoginRequestDTO;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.dtos.LoginResponseDTO;
import com.gabriel_gjs.finance_ctrl.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO data) {
        var tokenByEmailAndPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());

        var auth = this.authenticationManager.authenticate(tokenByEmailAndPassword);

        var token = this.tokenService.generateTokenJWT((User) auth.getPrincipal());


        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
