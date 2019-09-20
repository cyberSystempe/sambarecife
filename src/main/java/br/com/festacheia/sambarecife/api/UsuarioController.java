package br.com.festacheia.sambarecife.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.festacheia.sambarecife.api.dto.UsuarioDTO;
import br.com.festacheia.sambarecife.api.model.Usuario;
import br.com.festacheia.sambarecife.service.ApiService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired ApiService apiService;
	
	@PostMapping("/save")
	@ApiOperation(value = "Usuarios", notes = "Usuarios", tags = { "Usuarios" })
	public ResponseEntity<String> salvarProjeto(@RequestBody UsuarioDTO usuarioDTO){
		try {
			apiService.inserir( new Usuario(usuarioDTO));
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} 
	}

}
