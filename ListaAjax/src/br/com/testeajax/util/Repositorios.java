package br.com.testeajax.util;

import java.io.Serializable;

import org.hibernate.Session;

import br.com.testeajax.repository.Grupos;
import br.com.testeajax.repository.Pessoas;
import br.com.testeajax.repository.infra.GruposHibernate;
import br.com.testeajax.repository.infra.PessoasHibernate;

@SuppressWarnings("serial")
public class Repositorios implements Serializable {

	public Pessoas getPessoas() {
		return new PessoasHibernate(this.getSession());
	}

	public Grupos getGrupos() {
		return new GruposHibernate(this.getSession());
	}

	private Session getSession() {
		return (Session) FacesUtil.getRequestAttribute("session");
	}
}
