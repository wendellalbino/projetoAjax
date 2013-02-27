package br.com.testeajax.repository;

import java.util.List;

import br.com.testeajax.model.Grupo;

public interface Grupos {

	public List<Grupo> todos();

	public Grupo guardar(Grupo grupo);

	public Grupo porCodigo(Integer codigo);

	public void remover(Grupo grupo);
}
