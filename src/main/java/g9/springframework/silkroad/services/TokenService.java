package g9.springframework.silkroad.services;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TokenService {
  private final JwtEncoder jwtEncoder;

  public String generateToken(Authentication authentication) {
    Instant now = Instant.now();
    System.out.println(authentication.getAuthorities());
    String scope = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(" "));
    System.out.println("Scope " + scope);

    JwtClaimsSet claims = JwtClaimsSet.builder()
        .issuedAt(now)
        .subject(authentication.getName())
        .claim("scope", scope)
        .build();
    return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
  }
}
