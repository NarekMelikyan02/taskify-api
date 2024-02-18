package com.example.taskifyapi.securityconfig.service;

import com.example.taskifyapi.entity.BaseEntity;
import com.example.taskifyapi.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.naming.spi.Resolver;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    private final String SECRET_KEY = "532e0960c1082ec81fe81d696b26c6cfbd31949661ae911cc57d82ad1069e4ac";

    public String extractUserName(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    public boolean isValid(String token, UserDetails user) {
        String username = extractUserName(token);
        return (username.equals(user.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpirationTime(token).before(new Date());
    }

    private Date extractExpirationTime(String token) {
        return extractClaims(token, Claims::getExpiration);
    }


    public <T> T extractClaims(String token, Function<Claims, T> resolver) {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String generateToken(UserEntity user) {
        String token = Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 24 * 60*60 * 1000))
                .signWith(getSignInKey())
                .compact();
        return token;

    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
