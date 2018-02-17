package br.com.authapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.authapi.dto.UsuarioDto;

@Service
public class UsuarioService {

	public static List<UsuarioDto>usuarios = new ArrayList<>();
	public static int cont = 0;
	
	public UsuarioService() {
		cont++;
	}
	
	public UsuarioDto salvar(UsuarioDto usuarioDto) {
		usuarioDto.setId(cont);
		usuarios.add(usuarioDto);
		
		usuarios.forEach(ususario -> {
			System.out.println(ususario.getNome() + ususario.getId());
		});
		
		return usuarioDto;
	}
	
	
}
