package br.com.desafiosefaz.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.desafiosefaz.domain.Telefone;
import br.com.desafiosefaz.domain.Usuario;
import br.com.desafiosefaz.service.UsuarioService;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
	
	@EJB
	private UsuarioService usuarioService;
	private Usuario usuario = new Usuario();
	private Telefone telefone = new Telefone();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private String titulo = "Cadastro Usuario";
	private Integer id;
	
	@PostConstruct
	public void init() {
		this.list();
	}

	public void deletar() {
		usuarioService.delete(id);
	}
	
	public void list() {
		usuarios.add(createUserStatico());
		//usuarios = usuarioService.getUsers();
	}
	
	public void entrar() {
		usuarioService.findByEmail(usuario.getEmail());
	}
	public void carregar() {
		if(id != null) {
			usuario = usuarioService.findeById(id);
			titulo = "Alterar usuario";
		}
	}
	
	public void gravar() {
		usuarioService.createOrUpdate(usuario);
		this.list();
		titulo = "Alterar usuario";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	//Testar visaulziação da tebela Lista usuarios
	public Usuario createUserStatico() {
		Usuario u = new Usuario();
		u.setId(1);
		u.setEmail("teste@gamil.com");
		u.setNome("Teste");
		return u;
	}
	
}
