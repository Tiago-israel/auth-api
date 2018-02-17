package br.com.authapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.authapi.dto.UsuarioDto;
import br.com.authapi.service.UsuarioService;

@RestController
@RequestMapping("auth/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioDto>salvar(@RequestBody UsuarioDto usuarioDto){
		UsuarioDto usuarioDtoresponse = this.usuarioService.salvar(usuarioDto);
		return new ResponseEntity<UsuarioDto>(usuarioDtoresponse,HttpStatus.OK);
	}
	
}
