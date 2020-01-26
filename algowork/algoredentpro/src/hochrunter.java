import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class hochrunter extends JPanel {

	private gui_fenster fenster;
	private draw runter = new draw(0);
	private draw hoch = new draw(1);
	int offset;
	int theopos;

	public hochrunter(gui_fenster fenster) {
		fenster.items.add(this);
		setBackground(Color.BLACK);
		setSize(50, 150);
		setLocation(400, 400);
		add(runter);
		add(hoch);
		runter.setSize(getWidth(), getHeight() / 2);
		runter.setLocation(0, getHeight() / 2);
		hoch.setSize(getWidth(), getHeight() / 2);
		hoch.setLocation(0, 0);
		hoch.setBackground(Color.WHITE);
		runter.setBackground(Color.WHITE);
		this.fenster = fenster;
		theopos = fenster.canvas.getSize().height;
		action();
	}

	public void notwendig() {
//		setLocation(fenster.canvas.getWidth() - getWidth() - 10, fenster.canvas.getHeight() - getHeight() - 20+offset);
		setLocation(new Point(fenster.items.getWidth()/2-getWidth()/2+1, fenster.items.getSize().height - getHeight()-75));
		runter.setSize(50,50);
		runter.setLocation(0, getHeight() - runter.getHeight());
		hoch.setSize(50,50);
		hoch.setLocation(0, 0);
		theopos = fenster.canvas.getSize().height;


	}

	public void action() {
		runter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				fenster.canvas.setLocation(pfeil.add_point(fenster.canvas.getLocation(),0,-20));
				offset+=20;
				theopos +=20;
				if(theopos > fenster.canvas.getHeight()) {
					fenster.canvas.setSize(fenster.canvas.getSize().width,fenster.canvas.getSize().height+20);
				
				}
			}
		});

		hoch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(fenster.canvas.getLocation().getY()< 0) {
				fenster.canvas.setLocation(pfeil.add_point(fenster.canvas.getLocation(),0,20));
				offset-=20;
				theopos -=20;
				}
			}
		});
	}
}
