import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;

public class Main {
	
	public static void main(String[]args){
		JFrame fenetre = new JFrame("IHM");
		fenetre.setSize(1280, 720);
		fenetre.setMinimumSize(new Dimension(1280, 720));
		fenetre.setResizable(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PanelDeCouleurs panneau = new PanelDeCouleurs(5);
		
		JMenuBar menuBar = new JMenuBar();
		fenetre.setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmNouveau = new JMenuItem("Nouveau");
		mnFichier.add(mntmNouveau);
		
		JMenu mnEdition = new JMenu("Edition");
		menuBar.add(mnEdition);
		
		JMenu mnAffichage = new JMenu("Affichage");
		menuBar.add(mnAffichage);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);
		
		JPanel bouttons = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) bouttons.getLayout();
		flowLayout_1.setVgap((100));
		bouttons.add(new JButton("Auto"));
		fenetre.getContentPane().add(bouttons, BorderLayout.WEST);
		
		Sliders sliders = new Sliders(panneau);
		panneau.setSliders(sliders);
		fenetre.getContentPane().add(sliders, BorderLayout.EAST);
		
		FlowLayout flowLayout = (FlowLayout) panneau.getLayout();
		flowLayout.setVgap(150);
		fenetre.getContentPane().add(panneau, BorderLayout.SOUTH);
		
		panneau.add();
		panneau.add();
		panneau.add();
		panneau.add();
		panneau.add();
		panneau.add();
		panneau.add();
		panneau.add();
		fenetre.setVisible(true);
	}
	
}
