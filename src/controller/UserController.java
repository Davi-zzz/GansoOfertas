package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Util;
import dao.UserDAO;
import model.User;


@Named
@ViewScoped
public class UserController extends Controller<User> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1863957852474569039L;
	
	private List<User> listaUsuario;
	
	public UserController() {
		super(new UserDAO());
	}

	public List<User> getListaUsuario() {
		return listaUsuario;
	}

	@Override
	public User getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarDados() {
		if (getEntity().getNome().isBlank()){
			Util.addErrorMessage("O campo não pode ser vazio");
			return super.validarDados();
		}
		//encriptografando a senha
		String senha = Util.hashSHA256(getEntity().getSenha());
		getEntity().setSenha(senha);
		return true;
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub
		super.limpar();
	}

	
	
	
	
	
	
	
	
	

}
