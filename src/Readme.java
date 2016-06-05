import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Readme {

	JFrame fen;
	
	public Readme(){
		fen = new JFrame("Help?");
		fen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fen.setResizable(true);
		fen.setMinimumSize(new Dimension(300,400));
		fen.setSize(new Dimension(300,500));
		
		JLabel affichage = new JLabel("<html><body>aze<br>test</body></html>");
		
		fen.add(affichage);
		
		String affiche = "<html><body>";
		
		BufferedReader text;
		try {
			text = new BufferedReader(new FileReader("ressources/README.MD"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			text = null;
		}
		
		fen.setVisible(true);
		
		try {
			while(text.ready()){
				affiche+=text.readLine();
				affiche+="<br>";
			}
			text.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		affichage.setText(affiche);
	}
}
