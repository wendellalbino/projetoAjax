package br.com.testeajax.repository.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.testeajax.model.Grupo;
import br.com.testeajax.repository.Grupos;

public class GruposHibernate implements Grupos {

	private Session session;

	public GruposHibernate(Session session) {
		this.session = session;
	}

	@Override
	public Grupo guardar(Grupo grupo) {
		return (Grupo) session.merge(grupo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> todos() {
		return session.createCriteria(Grupo.class)
				.addOrder(Order.asc("atividade")).list();
	}

	@Override
	public void remover(Grupo grupo) {
		this.session.delete(grupo);
	}

	@Override
	public Grupo porCodigo(Integer codigo) {
		return (Grupo) this.session.get(Grupo.class, codigo);
	}

}
