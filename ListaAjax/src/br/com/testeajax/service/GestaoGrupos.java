package br.com.testeajax.service;

import br.com.testeajax.model.Grupo;
import br.com.testeajax.repository.Grupos;

public class GestaoGrupos {

	private Grupos grupos;

	public GestaoGrupos(Grupos grupos) {
		this.grupos = grupos;
	}

	public void salvar(Grupo grupo)  {

		this.grupos.guardar(grupo);
	}

	public void excluir(Grupo grupo) throws RegraNegocioException {

		this.grupos.remover(grupo);
	}

}
