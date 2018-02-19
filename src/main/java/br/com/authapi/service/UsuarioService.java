package br.com.authapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.authapi.dto.UsuarioDto;
import br.com.authapi.utils.JwtTokenUtils;
import br.com.authapi.utils.SenhaUtils;

@Service
public class UsuarioService {

	public static List<UsuarioDto>usuarios = new ArrayList<>();
	public static int cont = 0;
	public UsuarioDto usuarioFiltrado = null;
	@Autowired
	private JwtTokenUtils jwtTokenUtils;
	
	public UsuarioService() {
		UsuarioDto dto = new UsuarioDto();
		dto.setEmail("tiagoisrael77@gmail.com");
		dto.setNome("nome");
		dto.setSenha("12345");
		cont++;
		this.salvar(dto);
	}
	
	public UsuarioDto salvar(UsuarioDto usuarioDto) {
		usuarioDto.setId(cont);
		usuarioDto.setSenha(SenhaUtils.gerarBCript(usuarioDto.getSenha()));
		usuarios.add(usuarioDto);
		usuarios.forEach(ususario -> {
			System.out.println(ususario.getNome() + ususario.getSenha() + ususario.getEmail()  );
		});
		return usuarioDto;
	}
	
	public String Login(UsuarioDto usuarioDto) {
		usuarios.forEach(usuario -> {
			if(usuarioDto.getEmail().equals(usuario.getEmail()) ) {
				usuarioFiltrado = usuario;
			}
		});
		if(usuarioFiltrado != null) {
			if(SenhaUtils.validarSenha(usuarioDto.getSenha(), usuarioFiltrado.getSenha())) {
				System.out.println(usuarioFiltrado.getNome()+" logado!!!");
				return jwtTokenUtils.gerarToken(usuarioFiltrado.getNome());
			}
		}
		return null;
	}
	
	
}
