package br.com.testeajax.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.testeajax.model.Pessoa;
import br.com.testeajax.repository.Pessoas;
import br.com.testeajax.util.Repositorios;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	private Repositorios repositorios = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Pessoa retorno = null;
		Pessoas pessoas = this.repositorios.getPessoas();

		if (value != null && !value.equals("")) {
			retorno = pessoas.porCodigo(new Integer(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Integer codigo = ((Pessoa) value).getCodigo();
			return codigo == null ? "" : codigo.toString();
		}
		return null;
	}

}
