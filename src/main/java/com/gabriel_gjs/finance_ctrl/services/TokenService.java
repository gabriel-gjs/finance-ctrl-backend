package com.gabriel_gjs.finance_ctrl.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Slf4j
public class TokenService {
    @Value("{api.security.token.secret}")
    private String secret;

    public String generateTokenJWT(User user) {
        log.info("Iniciando processo de geração de token JWT");

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String tokenJWT = JWT.create()
                    .withIssuer("finance-ctrl-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationDateByTokenJWT())
                    .sign(algorithm);

            log.info("Processo de geração de token JWT com sucesso");

            return tokenJWT;
        } catch (JWTCreationException exception) {
            log.info("Erro no processo de geração de token JWT");

            throw new RuntimeException("Error while generating token JWT", exception);
        }
    }

    public String validateTokenJWT(String token) {
        log.info("Iniciando processo de validação de token JWT");

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                        .withIssuer("finance-ctrl-api")
                        .build()
                        .verify(token)
                        .getSubject();
        } catch (JWTVerificationException exception) {
            log.info("Erro no processo de validação de token JWT");

            throw new RuntimeException("Error while validate token JWT", exception);
        }
    }

    private Instant generateExpirationDateByTokenJWT() {
        return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00"));
    }

}
