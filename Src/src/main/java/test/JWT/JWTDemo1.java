package test.JWT;

import com.sun.xml.internal.ws.addressing.model.InvalidAddressingHeaderException;
import io.jsonwebtoken.*;
import org.apache.xmlbeans.impl.jam.internal.parser.ParserClassBuilder;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

/**
 * @program: Src
 * @description: JWT例子
 * @author: wsj
 * @create: 2024-06-24 11:00
 **/
public class JWTDemo1 {
    private long time = 1000 * 60 * 60 * 24;
    private String signature = "admin";

    @Test
    public void jwt() {
        JwtBuilder jwtBuilder  = Jwts.builder();
        String jwtToken = jwtBuilder
                // Header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // payload
                .claim("username", "tom")
                .claim("role", "admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                //Signature
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        System.out.println(jwtToken);

    }

    @Test
    public void parse() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiLnu4fngrnku6PnoIEiLCJpbmZvIjoi5LiA6ZSu5LiJ6L-eIiwiaWF0IjoxNTE2MjM5MDIyLCJleHAiOjE1MTYyMzkwMjJ9.cQggk0Seou-JDEGurQs1MKpyWq7YnpTQvMWiqS3YexQ";
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJwts = parser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJwts.getBody();
        System.out.println(claims.get("username"));
        System.out.println(claims.get("role"));
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getExpiration());
    }
}

