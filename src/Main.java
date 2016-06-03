import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main {

	public static PanelDeCouleurs panneau;
	
	public static void main(String[] args) {
		JFrame fenetre = new JFrame("TestMain");
		fenetre.setMinimumSize(new Dimension(910,500));
		fenetre.setSize(910, 500);
		fenetre.setResizable(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panneau = new PanelDeCouleurs(5);

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
		fenetre.getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel bouttons = new JPanel();
		bouttons.setLayout(new GridLayout(3, 1));
		bouttons.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		bouttons.add(new JButton("Auto"));
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panneau.add();
			}
		});
		JButton enlever = new JButton("Retirer");
		enlever.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panneau.remove();
			}
		});
		bouttons.add(ajouter);
		bouttons.add(enlever);
		
		Sliders sliders = new Sliders(panneau);
		panneau.setSliders(sliders);
		
		JPanel millieu = new JPanel();
		millieu.setLayout(new GridLayout(1,2));
		millieu.add(bouttons);
		millieu.add(sliders);
		fenetre.add(millieu);
		
		fenetre.add(panneau);
		panneau.repaint();
		
		fenetre.setVisible(true);
	}

}
