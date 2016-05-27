import java.awt.BorderLayout;

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
		fenetre.setSize(700, 500);
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
		flowLayout_1.setHgap(50);
		bouttons.add(new JButton("Auto"));
		fenetre.getContentPane().add(bouttons, BorderLayout.WEST);
		
		ArcEnCiel arcenciel = new ArcEnCiel();
		FlowLayout flowLayout_2 = (FlowLayout) arcenciel.getLayout();
		flowLayout_2.setHgap(100);
		fenetre.getContentPane().add(arcenciel, BorderLayout.CENTER);
		
		Sliders sliders = new Sliders(panneau);
		//FlowLayout flowLayout_3 = (FlowLayout) sliders.getLayout();
		//flowLayout_3.setHgap(50);
		fenetre.getContentPane().add(sliders, BorderLayout.EAST);
		
		FlowLayout flowLayout = (FlowLayout) panneau.getLayout();
		flowLayout.setVgap(150);
		fenetre.getContentPane().add(panneau, BorderLayout.SOUTH);
		
		fenetre.setVisible(true);
	}
	
}
