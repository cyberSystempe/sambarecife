package br.com.festacheia.sambarecife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.festacheia.sambarecife.api.model.Funcionario;
import br.com.festacheia.sambarecife.api.model.Usuario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	  Funcionario findByCodigoAllIgnoreCase(String codigo);

}
