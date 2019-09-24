package br.com.festacheia.sambarecife.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.festacheia.sambarecife.api.model.Funcionario;
import br.com.festacheia.sambarecife.api.model.Usuario;
import br.com.festacheia.sambarecife.repository.FuncionarioRepository;
import br.com.festacheia.sambarecife.repository.UsuarioRepository;

@Service
public class ApiService {

	@Autowired UsuarioRepository usuarioRepository;
	@Autowired FuncionarioRepository funcionarioRepository;

	
	public void inserir(Usuario usuario){
		Usuario u = usuarioRepository.findByTelefoneAndDddAllIgnoreCase(usuario.getTelefone(), usuario.getDdd());
		if(u != null) {
			usuario.setId(u.getId());
		}
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Funcionario inserirFuncionario(Funcionario func){
		return funcionarioRepository.save(func);
	}
	
	public Funcionario findByFuncionarioCodigo(String codigo) {
		return funcionarioRepository.findByCodigoAllIgnoreCase(codigo);
	}
	
	public List<Funcionario> listarFuncionarios(){
		return funcionarioRepository.findAll();
	}
	

}
