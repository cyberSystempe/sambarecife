package br.com.festacheia.sambarecife.api.model;
import javax.persistence.*;

import br.com.festacheia.sambarecife.api.dto.UsuarioDTO;

@Entity
public class Usuario {

	@TableGenerator(name = "usuario_id_seq",initialValue = 2)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String telefone;
	
	@Column
	private String ddd;
	
	public Usuario() {}
	
	public Usuario(UsuarioDTO usuarioDto) {
		this.setId(usuarioDto.getId());
		this.setNome(usuarioDto.getNome());
		this.setDdd(usuarioDto.getDdd());
		this.setTelefone(usuarioDto.getTelefone());
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
}
