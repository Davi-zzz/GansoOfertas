package controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import application.Util;
import dao.Dao;
import dao.UserDAO;
import model.Entity;

@Named
@RequestScoped
public abstract class Controller<T extends Entity<T>> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String teste = "9";

	protected T entity = null;
	protected Dao<T> dao = null;


	public Controller(UserDAO userDAO) {
		// TODO Auto-generated constructor stub
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	public abstract T getEntity();
	
	public void setEntity(T entity) {
		this.entity = entity;
	}

	public void incluir() {
		if (validarDados()) {
			if (dao.create(getEntity())) {
				limpar();
				Util.addInfoMessage("Inclusão realizada com sucesso.");
			} else {
				Util.addInfoMessage("Erro ao incluir no banco de dados.");
			}
		}
		
	}

	public void alterar() {
		if (validarDados()) {		
			if (dao.update(getEntity())) {
				limpar();
				Util.addInfoMessage("Alteração realizada com sucesso.");
			} else {
				Util.addInfoMessage("Erro ao alterar no banco de dados.");
			}
		}
	}

	public void remover() {
		if (dao.delete(getEntity().getId())) {
			limpar();
			Util.addInfoMessage("Remoção realizada com sucesso.");
		} else {
			Util.addInfoMessage("Erro ao remover no banco de dados.");
		}
	}

	public void editar(T entity) {
		entity = dao.findById(entity.getId());
		setEntity(entity);
	}
	
	public boolean validarDados() {
		return true;
	}
	
	public void limpar() {
		entity = null;
	}
	
	
	

}
