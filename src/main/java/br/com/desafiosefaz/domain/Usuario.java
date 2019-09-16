package br.com.desafiosefaz.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@NotNull
		private String nome;
		
		@NotNull
		private String email;
		
		@NotNull
		private String senha;
		
		@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
		private List<Telefone> telefones = new ArrayList<Telefone>();
		
		public Usuario() {}
		
		public Usuario(Integer id, String nome, String email, String senha, List<Telefone> telefones) {
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.senha = senha;
			this.telefones = telefones;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public List<Telefone> getTelefones() {
			return telefones;
		}

		public void setTelefones(List<Telefone> telefones) {
			this.telefones = telefones;
		}

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", telefones="
					+ telefones + "]";
		}
}
