import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ArcEnCiel extends JPanel{
	
	private static final long serialVersionUID = -8708382076577068170L;

	public void paintComponent(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 20, 20);
		
	}
}
