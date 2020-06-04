package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Util;
import dao.UserDAO;
import model.User;

@Named
@ViewScoped
public class LoginContreller {
	private User user;
	
	public String entrar() {
		UserDAO dao = new UserDAO();
		User user2 = dao.verificarLoginSenha(getUser().getLogin(),Util.hashSHA256(getUser().getSenha()), getUser().getEmail());
		
		if (user2 != null){
			return "user.xhtml?faces-redirect=true";
		}
		Util.addErrorMessage("Credenciais incorretas");
		return "";
		
	}
	
	public void clear() {
		user = null;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
