package br.com.festacheia.sambarecife.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.festacheia.sambarecife.api.dto.ObjectDTO;
import br.com.festacheia.sambarecife.api.dto.UsuarioDTO;
import br.com.festacheia.sambarecife.api.model.Funcionario;
import br.com.festacheia.sambarecife.api.model.Usuario;
import br.com.festacheia.sambarecife.service.ApiService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UsuarioController {
	
	@Autowired ApiService apiService;
	
	@PostMapping("usuario/save")
	@ApiOperation(value = "Usuarios", notes = "Usuarios", tags = { "Usuarios" })
	public ResponseEntity<String> salvarProjeto(@RequestBody ObjectDTO obj){
		try {
			if(obj.getUsuarios() != null) {
				String codigo = obj.getCodigo();
				Funcionario func = apiService.findByFuncionarioCodigo(codigo);
				if(func == null) {
					func = new Funcionario();
					func.setCodigo(codigo);
					func.setQtd((long) obj.getUsuarios().size());
					func = apiService.inserirFuncionario(func);
				}else {
					func.setQtd(func.getQtd() + obj.getUsuarios().size());
					apiService.inserirFuncionario(func);
				}
				for (UsuarioDTO usuarioDTO : obj.getUsuarios()) {
					apiService.inserir( new Usuario(usuarioDTO));
				}
			}
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} 
	}
	
	@GetMapping("usuario/findAll")
	@ApiOperation(value = "Usuarios", notes = "Lista dos usuarios", tags = { "Usuarios" })
	public ResponseEntity<List<Usuario>> getUsuarios(){
		return new ResponseEntity<List<Usuario>>(apiService.listarUsuarios(), HttpStatus.OK);
	}
	
	@GetMapping("funcionario/findAll")
	@ApiOperation(value = "Funcionarios", notes = "Lista dos funcionarios", tags = { "Funcionarios" })
	public ResponseEntity<List<Funcionario>> getFuncionarios(){
		return new ResponseEntity<List<Funcionario>>(apiService.listarFuncionarios(), HttpStatus.OK);
	}

}
