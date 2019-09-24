package br.com.festacheia.sambarecife.api.model;
import javax.persistence.*;

import br.com.festacheia.sambarecife.api.dto.UsuarioDTO;

@Entity
public class Funcionario {

	@TableGenerator(name = "funcionario_id_seq",initialValue = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	@Column
	private Long qtd;
	
	@Column
	private String codigo;
	
	
	public Funcionario() {}
	
	public Funcionario(UsuarioDTO usuarioDto) {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getQtd() {
		return qtd;
	}

	public void setQtd(Long qtd) {
		this.qtd = qtd;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
