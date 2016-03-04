package br.com.wservices.gpv.seguranca.domain.service.remote;

import javax.ejb.Remote;

import br.com.wservices.gpv.seguranca.domain.dto.UsuarioDTO;

@Remote
public interface UsuarioServiceRemote {

	String MAPPED_NAME = "UsuarioService";

	UsuarioDTO find(String login);

}
