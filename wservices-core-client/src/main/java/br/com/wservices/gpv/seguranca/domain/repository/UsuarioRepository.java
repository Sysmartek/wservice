package br.com.wservices.gpv.seguranca.domain.repository;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.seguranca.domain.entity.Usuario;

public interface UsuarioRepository extends SysmartekRepository<Usuario, Integer> {

	Usuario findByLoginIgnoreCase(String login);

}
