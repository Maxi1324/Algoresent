import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class linksrechts extends JPanel {
	
	private draw rechts = new draw(2);
	private draw links = new draw(3);
	int theopos;
	private gui_fenster fenster;

	public linksrechts(gui_fenster fenster) {
		fenster.items.add(this);
		setBackground(Color.BLACK);
		setSize(150,50);
		setLocation(400, 400);
		add(rechts);
		add(links);
		rechts.setSize(50, 50);
		rechts.setLocation(getWidth()/2,0);
		links.setSize(50, 50);
		links.setLocation(0, 0);
		links.setBackground(Color.WHITE);
		rechts.setBackground(Color.WHITE);
		this.fenster = fenster;
		theopos = fenster.canvas.getSize().height;
		action();
	}

	public void notwendig() {
//		setLocation(fenster.canvas.getWidth() - getWidth() - 10, fenster.canvas.getHeight() - getHeight() - 20+offset);
		setLocation(new Point(fenster.items.getSize().width/2-getWidth()/2, fenster.items.getSize().height - getHeight() - 125));
		rechts.setSize(50, 50);
		rechts.setLocation(getWidth()-rechts.getWidth(),0);
		links.setSize(50, 50);
		links.setLocation(0, 0);
		theopos = fenster.canvas.getSize().height;

	}

	public void action() {
		rechts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				fenster.canvas.setLocation(pfeil.add_point(fenster.canvas.getLocation(), -20, 0));
				theopos += 20;
				if (theopos > fenster.canvas.getHeight()) {
					fenster.canvas.setSize(fenster.canvas.getSize().width+20, fenster.canvas.getSize().height);

				}
			}
		});

		links.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (fenster.canvas.getLocation().getX() < 0) {
					fenster.canvas.setLocation(pfeil.add_point(fenster.canvas.getLocation(), 20, 0));
					theopos -= 20;
					fenster.canvas.repaint();
				}
			}
		});
	}
}
