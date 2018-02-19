package br.com.authapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.authapi.dto.TokenDto;
import br.com.authapi.dto.UsuarioDto;
import br.com.authapi.response.Response;
import br.com.authapi.service.UsuarioService;
import br.com.authapi.utils.JwtTokenUtils;

@RestController
@RequestMapping("auth/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private JwtTokenUtils jwt;
	
	@PostMapping
	public ResponseEntity<Response<UsuarioDto>>salvar(@Valid @RequestBody UsuarioDto usuarioDto,BindingResult result){
		Response<UsuarioDto>response = new Response<UsuarioDto>();
		if(result.hasErrors()) {
			result.getAllErrors().forEach(erro -> {
				response.getErros().add(erro.getDefaultMessage());
			});
			return new ResponseEntity<Response<UsuarioDto>>(response,HttpStatus.OK);
		}
		response.setData(this.usuarioService.salvar(usuarioDto));
		return new ResponseEntity<Response<UsuarioDto>>(response,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response<TokenDto>> login(@RequestBody UsuarioDto usuarioDto){
		TokenDto tokenDto = new TokenDto();
		tokenDto.setToken(this.usuarioService.Login(usuarioDto));
		Response<TokenDto>response = new Response<>(tokenDto);
		return new ResponseEntity<Response<TokenDto>>(response,HttpStatus.OK);
	}
	
	@GetMapping
	public String teste() {
		return "Olá";
	}

}
