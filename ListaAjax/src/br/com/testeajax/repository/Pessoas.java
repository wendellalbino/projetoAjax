package br.com.testeajax.repository;

import java.util.List;

import br.com.testeajax.model.Pessoa;

public interface Pessoas {

	public List<Pessoa> todos();

	public Pessoa guardar(Pessoa pessoa);

	public Pessoa porCodigo(Integer codigo);

	public void remover(Pessoa pessoa);

}
