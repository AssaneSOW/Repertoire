package fr.eni.annuaire.bll;

import java.util.List;
import java.util.regex.Pattern;

import fr.eni.annuaire.bo.User;
import fr.eni.annuaire.dal.UserDAO;


public class UserManager {
	
	private static UserManager instance = null;
	private UserDAO userDAO;
	
	private UserManager(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public static UserManager getInstance() {
		if(instance == null) {
			instance = new UserManager(UserDAO.getInstance());
		}
		return instance;
	}
	
	public void save(User user) {
		user.setNom(user.getNom().toUpperCase());
		user.setDate(user.getDate());
		userDAO.save(user);
	}
	
	public void update(User user) {
		user.setNom(user.getNom().toUpperCase());
		userDAO.update(user);
	}
	
	public List<User> findAll() {
		return userDAO.findAll();
	}
	
	public User findById(int id) {
		return userDAO.findById(id);
	}
	
	public void deleteByEmail(String email) {
		userDAO.deleteByEmail(email);
	}
	
	public void deleteById(int id) {
		userDAO.deleteById(id);
	}

	public boolean verificationEmail(String email) {
		if (email.contains("@")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verificationMdp(String mdp) {
		boolean contientMaj = !mdp.equals(mdp.toLowerCase());
		boolean contientNum = Pattern.matches("(\\w+\\d+)|(\\d+\\w+)", mdp);
		if (contientMaj && contientNum) {
			return true;
		} else if (contientMaj && !contientNum) {
			System.out.println("Le mot de passe doit aussi contenir un nombre");
			return false;
		} else if (!contientMaj && contientNum) {
			System.out.println("Le mot de passe doit aussi contenir une majuscule");
			return false;
		} else {
			return false;
		}
	}

}
