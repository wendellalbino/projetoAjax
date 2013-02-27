package br.com.testeajax.service;

import br.com.testeajax.model.Pessoa;
import br.com.testeajax.repository.Pessoas;

public class GestaoPessoas {

	private Pessoas pessoas;

	public GestaoPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}

	public void salvar(Pessoa pessoa) throws RegraNegocioException {

		this.pessoas.guardar(pessoa);
	}

	public void excluir(Pessoa pessoa) throws RegraNegocioException {

		this.pessoas.remover(pessoa);
	}

}
