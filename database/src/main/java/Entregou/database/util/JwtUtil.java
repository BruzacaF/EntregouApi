package Entregou.database.util;

import Entregou.database.model.Role;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 8;
    private final SecretKey chaveSecreta = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String gerarToken(String email, Role role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role.name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(chaveSecreta)
                .compact();
    }

    public String extrairEmail(String token) {
        return getClaims(token).getSubject();
    }

    public Role extrairRole(String token) {
        String roleStr = getClaims(token).get("role", String.class);
        return Role.valueOf(roleStr);
    }

    public boolean validarToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch ( JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(chaveSecreta)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }



}
