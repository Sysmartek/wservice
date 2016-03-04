package br.com.wservices.gpv.seguranca.domain.service;

import javax.ejb.Local;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.exception.InfrastructureException;
import br.com.wservices.gpv.seguranca.domain.dto.UsuarioDTO;
import br.com.wservices.gpv.seguranca.domain.service.remote.UsuarioServiceRemote;

@Local
public interface UsuarioService extends UsuarioServiceRemote {

	UsuarioDTO salvar(UsuarioDTO usuarioDTO) throws InfrastructureException, DomainException;

	UsuarioDTO alterar(UsuarioDTO usuarioDTO) throws InfrastructureException, DomainException;

}
