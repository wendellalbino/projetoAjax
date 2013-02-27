package br.com.testeajax.view;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.com.testeajax.model.Pessoa;
import br.com.testeajax.repository.Pessoas;
import br.com.testeajax.util.Repositorios;

public class PessoaDataModel extends ListDataModel<Pessoa> implements
		SelectableDataModel<Pessoa> {

	private Repositorios repositorios = new Repositorios();

	public PessoaDataModel() {
	}

	public PessoaDataModel(List<Pessoa> data) {
		super(data);
	}

	@Override
	public Pessoa getRowData(String rowKey) {

		Pessoa retorno = null;
		Pessoas pessoas = this.repositorios.getPessoas();

		if (rowKey != null && !rowKey.equals("")) {
			retorno = pessoas.porCodigo(new Integer(rowKey));
		}
		return retorno;
	}

	@Override
	public Object getRowKey(Pessoa pessoa) {
		Integer codigo = ((Pessoa) pessoa).getCodigo();
		return codigo == null ? "" : codigo.toString();
	}
}
