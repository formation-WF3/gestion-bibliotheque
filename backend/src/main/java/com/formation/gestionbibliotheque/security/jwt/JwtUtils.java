package com.formation.gestionbibliotheque.security.jwt;
import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.formation.gestionbibliotheque.security.services.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtils {
	 private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	 
	 @Value("${formation.app.jwtSecret:saidSecretKey}")
  private String jwtSecret;
  
  @Value("${jwt.signing-key:123}")
  private String jwtSigningKey;

  @Value("${formation.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  @Value("${formation.app.jwtCookieName:said}")
  private String jwtCookie;
  
  @Value("${jwt.accessTokenValidititySeconds:43200}") // 12 hours
  private int accessTokenValiditySeconds;

  @Value("${jwt.authorizedGrantTypes:password,authorization_code,refresh_token}")
  private String[] authorizedGrantTypes;

  @Value("${jwt.refreshTokenValiditySeconds:2592000}") // 30 days
  private int refreshTokenValiditySeconds;


  public JwtUtils(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UserDetailsService userService) {
  }

 
  public String getJwtFromCookies(HttpServletRequest request) {
    Cookie cookie = WebUtils.getCookie(request, jwtCookie);
    if (cookie != null) {
      return cookie.getValue();
    } else {
      return null;
    }
  }

  public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
    String jwt = generateTokenFromUsername(userPrincipal.getUsername());
    ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
    return cookie;
  }

  public ResponseCookie getCleanJwtCookie() {
    ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
    return cookie;
  }

  public String generateJwtToken(Authentication authentication) {

    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

    return Jwts.builder()
        .setSubject((userPrincipal.getUsername()))
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
        .signWith(key(), SignatureAlgorithm.HS256)
        .compact();
  }
  
  private Key key() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key()).build()
               .parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
      return true;
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
  
  public String generateTokenFromUsername(String username) {   
	    return Jwts.builder()
	              .setSubject(username)
	              .setIssuedAt(new Date())
	              .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
	              .signWith(key(), SignatureAlgorithm.HS256)
	              .compact();
	  }
}
