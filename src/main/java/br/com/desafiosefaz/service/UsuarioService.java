package br.com.desafiosefaz.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.desafiosefaz.domain.Usuario;
import br.com.desafiosefaz.repository.UsuarioRepository;
import br.com.desafiosefaz.util.Validation;

@Stateless
public class UsuarioService {
	
	@EJB
	private UsuarioRepository usuarioRepository;
	
	public void createOrUpdate(Usuario usuario) {
		if(usuario.getId() == null) {
			create(usuario);
		}else {
			update(usuario);
		}
	}
	
	public List<Usuario> getUsers(){
		List<Usuario> usuarios = usuarioRepository.list();
		return usuarios;
	}
	
	public void findByEmail(String email) {
		usuarioRepository.findByEmail(email);
	}
	
	public Usuario findeById(Integer id) {
		return usuarioRepository.findById(id);
	}

	private void update(Usuario usuario) {
		usuarioRepository.salvar(usuario);
	}
	
	public void delete(Integer id) {
		usuarioRepository.deletar(id);
	}

	private void create(Usuario usuario) {
		Usuario u = usuarioRepository.findByEmail(usuario.getEmail());
		if(u == null && Validation.validarEmail(usuario.getEmail()) && Validation.validarSenha(usuario.getSenha())) {
			usuarioRepository.salvar(usuario);
		}
		
	}
}
