package management.tokens;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class TokenHandler {

    private final SecretKey secretKey;

    public TokenHandler() throws NoSuchAlgorithmException {
//        String jwtKey = "MyJwtKey1234567890";
//        byte[] decodeKey = BaseEncoding.base64().decode(jwtKey);

        secretKey = KeyGenerator.getInstance("AES").generateKey();
//                new SecretKeySpec(decodeKey, "AES");
    }

    public String extractUserLogin(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            return body.getId();
        } catch (RuntimeException e) {
            return null;
        }
    }

    public String generateAccessToken(String login, LocalDateTime expires) {
        String res = Jwts.builder()
                .setId(login)
                .setExpiration(Date.from(expires.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        return res;
    }

    public void killToken(){

    }
}
