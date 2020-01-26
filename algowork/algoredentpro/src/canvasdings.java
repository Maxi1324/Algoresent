import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class canvasdings extends JTextArea {

	private gui_fenster fenster;

	public canvasdings(gui_fenster fenster) {

		this.fenster = fenster;
		mouse();
	}

	public void set_pos(int x, int y) {
		setBounds(x, y, getWidth(), getHeight());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.WHITE);
//		g.setColor(new Color(240,240,240));		
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);

		for (int i = 0; i < fenster.pfeile.size(); i++) {
			if (fenster.pfeile.get(i) != null)
				fenster.pfeile.get(i).zeichnen(g2d);
		}
		try {
			Thread.sleep(0);
			for (int i = 0; i < fenster.vier.size(); i++) {
				if (fenster.vier.get(i) != null) {

				}
			}
		} catch (Exception e) {
			System.err.println("Fehler");
		}

		if (fenster.pfeilsetz == true) {

			g2d.setStroke(new BasicStroke(15));
			g2d.drawRect(0, 0, getWidth(), getHeight());
			}

	}

	public void pain1t(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);

		for (int i = 0; i < fenster.pfeile.size(); i++) {
			fenster.pfeile.get(i).zeichnen(g2d);
		
		}

	
		if (fenster.pfeilsetz == true) {

			g2d.setStroke(new BasicStroke(200));
			g2d.drawRect(0, 0, getWidth(), getHeight());
			}

	}

	public void mouse() {
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				fenster.items.build = false;
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				fenster.items.build = false;
				fenster.pfeilsetz = false;
				repaint();
				for(int i = 0;i < fenster.vier.size();i++) {
					fenster.vier.get(i).start = false;
				}
				fenster.items.build = false;
				
			
			}
			
		});

	}

}
