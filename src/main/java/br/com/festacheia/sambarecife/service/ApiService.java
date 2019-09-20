package br.com.festacheia.sambarecife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.festacheia.sambarecife.api.model.Usuario;
import br.com.festacheia.sambarecife.repository.UsuarioRepository;

@Service
public class ApiService {

	@Autowired UsuarioRepository usuarioRepository;
	
	public void inserir(Usuario usuario){
		usuarioRepository.save(usuario);
	}
	
}
