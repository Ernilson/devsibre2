package br.com.devsibre.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import br.com.devsibre.Model.Usuario;

@Entity
public class Roles implements GrantedAuthority{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String nomeRole;
	
	 @ManyToMany(mappedBy = "roles")
	private List<Usuario>usuarios;
	

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String getAuthority() {
		 return this.nomeRole;
	}
	
	
}
