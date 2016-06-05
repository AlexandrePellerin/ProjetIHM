import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{

	private static final long serialVersionUID = 7902612641611790795L;

	private PanelDeCouleurs panneau;
	
	public Menu(PanelDeCouleurs panneau){
		this.panneau = panneau;
		
		JMenu mnFichier = new JMenu("Fichier");
		this.add(mnFichier);

		JMenuItem mntmNouveau = new JMenuItem("Nouveau");
		mnFichier.add(mntmNouveau);

		JMenu mnEdition = new JMenu("Edition");
		this.add(mnEdition);
		
		JMenuItem mntmAjouter = new JMenuItem("Ajouter");
		mnEdition.add(mntmAjouter);
		
		JMenuItem mntmRetirer = new JMenuItem("Retirer");
		mnEdition.add(mntmRetirer);

		JMenu mnAffichage = new JMenu("Affichage");
		this.add(mnAffichage);

		JMenu mnOptions = new JMenu("Options");
		this.add(mnOptions);

		JMenu mnAide = new JMenu("Aide");
		this.add(mnAide);
	}
}
