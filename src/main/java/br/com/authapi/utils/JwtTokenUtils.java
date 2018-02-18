package br.com.authapi.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtils {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	@Value("${jwt.header}")
	private String header;

	public String gerarToken(String username) {
		Map<String, Object>map = new HashMap<>();
		map.put("admin", false);
		return Jwts.builder()
				.setSubject(username)
				.setClaims(map)
				.setExpiration(gerarDataExpiracao())
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}

	public String validarToken(HttpServletRequest request) {
		String token = request.getHeader(header);
		if (token != null) {
			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
		}
		return null;
	}

	private Date gerarDataExpiracao() {
		return new Date(System.currentTimeMillis() + expiration * 1000);
	}

}
