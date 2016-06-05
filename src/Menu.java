import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{

	private static final long serialVersionUID = 7902612641611790795L;

	private PanelDeCouleurs panneau;
	
	public Menu(PanelDeCouleurs panneauP){
		this.panneau = panneauP;
		
		JMenu mnFichier = new JMenu("Fichier");
		this.add(mnFichier);

		JMenuItem mntmNouveau = new JMenuItem("Nouveau");
		mnFichier.add(mntmNouveau);

		JMenu mnEdition = new JMenu("Edition");
		this.add(mnEdition);
		
		JMenuItem mntmAjouter = new JMenuItem("Ajouter");
		mnEdition.add(mntmAjouter);
		mntmAjouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panneau.add();
				Main.updateFrame();
			}
		});
		
		JMenuItem mntmRetirer = new JMenuItem("Retirer");
		mnEdition.add(mntmRetirer);
		mntmRetirer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panneau.remove();
				Main.updateFrame();
			}
		});

		JMenu mnAffichage = new JMenu("Affichage");
		this.add(mnAffichage);

		JMenu mnOptions = new JMenu("Options");
		this.add(mnOptions);

		JMenu mnAide = new JMenu("Aide");
		this.add(mnAide);
		
		JMenuItem mntmHelp = new JMenuItem("Help?");
		mnAide.add(mntmHelp);
		mntmHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Readme();
			}
		});
	}
}
