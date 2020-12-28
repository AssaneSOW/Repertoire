package fr.eni.annuaire.ihm;

import java.util.List;
import java.util.Scanner;

import fr.eni.annuaire.bll.UserManager;
import fr.eni.annuaire.bo.User;


public class Launcher {

	public static void main(String[] args) {
		
		UserManager userManager = UserManager.getInstance();
		int saisieUtilisateur;
		

		do {
			afficherMenu();
			saisieUtilisateur = saisieUtilisateur();
			System.out.println(saisieUtilisateur);
			if (saisieUtilisateur == 1) {
				
				User user = recupererSaisieContact();
				userManager.save(user);
				
			} else if (saisieUtilisateur == 2) {
				// Supprimer un contact
				String email = recupererMailASupprimer();
				userManager.deleteByEmail(email);
				
			} else if (saisieUtilisateur == 3) {
				
				List<User> users = userManager.findAll();
				afficherContacts(users);
				
			} else if (saisieUtilisateur == 4) {
				// Quitter l'application
			} else {
				System.err.println("Merci de saisir un choix entre 1 et 4");
			}
		} while (saisieUtilisateur != 4);

	}

	private static String recupererMailASupprimer() {
		System.out.println("Merci de saisir l'email du contact à supprimer");
		Scanner scan = new Scanner(System.in);
		String email = scan.nextLine();
		return email;
	}

	private static void afficherContacts(List<User> users) {
		for (User user : users) {
			System.out.println(user);
		}
	}

	private static User recupererSaisieContact() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Merci de saisir un nom");
		String nom = scan.nextLine();
		System.out.println("Merci de saisir un prénom");
		String prenom = scan.nextLine();
		
		boolean confirmation = false;
		String email;
		do {
			System.out.println("Merci de saisir un email");
			email = scan.nextLine();
			UserManager userManager = UserManager.getInstance();
			confirmation = userManager.verificationEmail(email);
		} while (!confirmation);
		
		boolean verif = false;
		String mdp;
		do {
			System.out.println("Merci de saisir un mot de passe comportant une majuscule et un nombre");
			mdp = scan.nextLine();
			UserManager userManager = UserManager.getInstance();
			verif = userManager.verificationMdp(mdp);
		} while (!verif);
		
		User user = new User(nom, prenom, email, mdp, 99);
		return user;
	}

	private static int saisieUtilisateur() {
		Scanner scan = new Scanner(System.in);
		int saisieUtilisateur = scan.nextInt();
		return saisieUtilisateur;
	}

	private static void afficherMenu() {
		System.out.println("Bienvenue dans mon annuaire :");
		System.out.println("1 - Ajouter un contact");
		System.out.println("2 - Supprimer un contact");
		System.out.println("3 - Afficher les contacts");
		System.out.println("4 - Quitter");
	}

}
