package br.com.moisesestevao.api.config.security.controller;

import br.com.moisesestevao.api.config.security.dto.TokenDto;
import br.com.moisesestevao.api.config.security.model.FormLogin;
import br.com.moisesestevao.api.config.security.service.TokenService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping
    public ResponseEntity<?> autentica (@RequestBody @Valid FormLogin form){
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = form.toUsernamePasswordAuthenticationToken();
		try {
			Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			String token = tokenService.generateToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
    }

}
