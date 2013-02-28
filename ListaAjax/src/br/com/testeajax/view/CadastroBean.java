package br.com.testeajax.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.testeajax.model.Grupo;
import br.com.testeajax.model.Pessoa;
import br.com.testeajax.repository.Pessoas;
import br.com.testeajax.service.GestaoGrupos;
import br.com.testeajax.util.Repositorios;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CadastroBean implements Serializable {

	private Repositorios repositorios = new Repositorios();
	private Grupo grupo = new Grupo();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Pessoa pessoaSelecionada;
	private PessoaDataModel pessoasModel;
	private Pessoa[] pessoasSelecionadas;
	private List<Pessoa> listaPessoasSelecionadas = new ArrayList<Pessoa>();

	@PostConstruct
	public void init() {

		Pessoas pessoas = this.repositorios.getPessoas();
		this.setPessoas(pessoas.todos());
		pessoasModel = new PessoaDataModel(this.pessoas);

	}

	public void inserir() {
		listaPessoasSelecionadas.add(pessoaSelecionada);
	}

	public void salvar() {

		GestaoGrupos gestaoGrupos = new GestaoGrupos(
				this.repositorios.getGrupos());
		grupo.setPessoas(listaPessoasSelecionadas);
		gestaoGrupos.salvar(grupo);

	}

	public void excluir() {
		listaPessoasSelecionadas.remove(pessoaSelecionada);
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) throws CloneNotSupportedException {
		this.grupo = grupo;
		if (this.grupo == null) {
			this.grupo = new Grupo();
		} else {
			listaPessoasSelecionadas = grupo.getPessoas();
			this.grupo = (Grupo) grupo.clone();
		}
	}

	public PessoaDataModel getPessoasModel() {
		return pessoasModel;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public Pessoa[] getPessoasSelecionadas() {
		return pessoasSelecionadas;
	}

	public void setPessoasSelecionadas(Pessoa[] pessoasSelecionadas) {
		this.pessoasSelecionadas = pessoasSelecionadas;
	}

	public List<Pessoa> getListaPessoasSelecionadas() {
		return listaPessoasSelecionadas;
	}

	public void setListaPessoasSelecionadas(
			List<Pessoa> listaPessoasSelecionadas) {
		this.listaPessoasSelecionadas = listaPessoasSelecionadas;
	}

}
