package br.com.desafiosefaz.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.desafiosefaz.domain.Usuario;

@Stateless
public class UsuarioRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void update(Usuario usuario) {
		em.merge(usuario);
	}
	
	public void deletar(Integer id) {
		em.remove(id);
	}
	
	public Usuario findById(Integer id) {
		return em.find(Usuario.class, id);
	}
	
	public Usuario findByEmail(String email) {
		Usuario usuario = em.find(Usuario.class, email);
		return usuario;
	}
	
	public List<Usuario> list() {
		 Query query = em.createQuery("SELECT u FROM Usuario u");
		 @SuppressWarnings("unchecked")
		 List<Usuario> usuarios = query.getResultList();
		 return usuarios;
	}
	
	public void update(Integer id) {
		Usuario usuario = findById(id);
		if(usuario != null) {
			em.remove(usuario);
		}
	}
	
	
}
