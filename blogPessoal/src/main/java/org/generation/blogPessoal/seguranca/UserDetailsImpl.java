package org.generation.blogPessoal.seguranca;

import java.util.Collection;

import org.generation.blogPessoal.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//aplicar uma regra de negocio da classe UserDetails
// clicar em UserDetailsImpl para importar todos os metodos
public class UserDetailsImpl implements UserDetails {

	// dizer que classe é apenas para controle interno
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;

	// criar um construtor de classe
	public UserDetailsImpl(Usuario user) {
		super();
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}

	// construtor vazio
	public UserDetailsImpl() {

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password; // retornar o password
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName; // retornar o userName
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true; // retornar true
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
