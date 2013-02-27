package br.com.testeajax.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.testeajax.model.Grupo;
import br.com.testeajax.repository.Grupos;
import br.com.testeajax.util.Repositorios;

@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter {

	private Repositorios repositorios = new Repositorios();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Grupo retorno = null;
		Grupos grupos = this.repositorios.getGrupos();

		if (value != null && !value.equals("")) {
			retorno = grupos.porCodigo(new Integer(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Integer codigo = ((Grupo) value).getCodigo();
			return codigo == null ? "" : codigo.toString();
		}
		return null;
	}

}
