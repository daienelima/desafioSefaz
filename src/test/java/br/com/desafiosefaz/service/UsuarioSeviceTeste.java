package br.com.desafiosefaz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.desafiosefaz.domain.Telefone;
import br.com.desafiosefaz.domain.Tipo;
import br.com.desafiosefaz.domain.Usuario;

public class UsuarioSeviceTeste {

	@Mock
	public UsuarioService usuarioService;
	private Usuario usuario;
	private final String EMAIL = "teste@gmail.com";
	private final String NOME = "Testes ";
	private final String SENHA = "123456";
	private final String DDD = "81";
	private final String NUMERO = "912345678";
	
	@Before
	public void init() {
		usuario = new Usuario();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void save() {
		usuario = createUsuario();
		this.usuarioService.createOrUpdate(usuario);
		assertEquals(NOME, usuario.getNome());
		assertEquals(EMAIL, usuario.getEmail());
		assertEquals(SENHA, usuario.getSenha());
		assertEquals(NUMERO, usuario.getTelefones().get(0).getNumero());
		assertEquals(DDD, usuario.getTelefones().get(0).getDdd());
		assertEquals(Tipo.FIXO, usuario.getTelefones().get(0).getTipo());
	}

	@Test
	public void findEmail() {
		usuario = createUsuario();
		this.usuarioService.findByEmail(usuario.getEmail());
		assertEquals(EMAIL, usuario.getEmail());
	}
	
	private Usuario createUsuario() {
		Usuario usuario = new Usuario();
		List<Telefone> fones = new ArrayList<Telefone>();
		Telefone tell = new Telefone();
		tell.setDdd(DDD);
		tell.setNumero(NUMERO);
		tell.setTipo(Tipo.FIXO);
		fones.add(tell);
		usuario.setEmail(EMAIL);
		usuario.setNome(NOME);
		usuario.setSenha(SENHA);
		usuario.setTelefones(fones);
		return usuario;
	}
}
