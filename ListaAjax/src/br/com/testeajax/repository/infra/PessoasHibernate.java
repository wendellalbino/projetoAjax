package br.com.testeajax.repository.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.testeajax.model.Pessoa;
import br.com.testeajax.repository.Pessoas;

public class PessoasHibernate implements Pessoas {

	private Session session;

	public PessoasHibernate(Session session) {
		this.session = session;
	}

	@Override
	public Pessoa guardar(Pessoa pessoa) {
		return (Pessoa) session.merge(pessoa);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> todos() {
		return session.createCriteria(Pessoa.class).addOrder(Order.asc("nome"))
				.list();
	}

	@Override
	public void remover(Pessoa pessoa) {
		this.session.delete(pessoa);
	}

	@Override
	public Pessoa porCodigo(Integer codigo) {
		return (Pessoa) this.session.get(Pessoa.class, codigo);
	}
}
