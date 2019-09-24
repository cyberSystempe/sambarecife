package br.com.festacheia.sambarecife.api.dto;

import java.util.List;

public class ObjectDTO {

	String codigo;
	List<UsuarioDTO> usuarios;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}
	
}
