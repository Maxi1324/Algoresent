import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Pfeilstart extends JButton {

	int x = 20;
	int y = 20;
	private gui_fenster fenster;
	private Pfeilstart start;
	public int pfeil_in=-1;
	private int pos;
	private Viereck parrent;


	public Pfeilstart(gui_fenster fenster,int pos,Viereck parrent) {
		this.fenster = fenster;
		this.parrent = parrent;
		start = this;
		this.pos = pos;
		action();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}
	
	public void action() {
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pfeil_in!= -1) {fenster.pfeile.set(pfeil_in, null);
				fenster.canvas.repaint();}
				fenster.pfeilsetz = true;
				fenster.pfeiltyp = false;
				fenster.ob1 = start;
				
				fenster.ob2 = null;
				fenster.canvas.repaint();
				if(pos == 0) {
					parrent.pfeilStart1();
				}
				if(pos == 1) {
					parrent.pfeilStart2();
				}
				if(pos == 2) {
					parrent.pfeilStart3();
				}
				actionlistner1();
			}
		});
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0;i < fenster.vier.size();i++) {
					fenster.vier.get(i).start = false;
				}
				fenster.items.build = false;
				fenster.canvas.repaint();
			
				
			}
		});
	}
	
	public void notwendig() {
		
	}
	
	
	public void actionlistner1() {
		
	}

	public void set_pos(int x, int y) {
		setBounds(x, y, this.x, this.y);
	}

	public int getX1() {
		return x;
	}

	public void setX1(int x) {
		this.x = x;
	}

	public int getY1() {
		return y;
	}

	public void setY1(int y) {
		this.y = y;
	} 

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getPos() {
		return pos;
	}

	public gui_fenster getFenster() {
		return fenster;
	}

	public void setFenster(gui_fenster fenster) {
		this.fenster = fenster;
	}

	public Pfeilstart getStart() {
		return start;
	}

	public void setStart(Pfeilstart start) {
		this.start = start;
	}

	public int getPfeil_in() {
		return pfeil_in;
	}

	public void setPfeil_in(int pfeil_in) {
		this.pfeil_in = pfeil_in;
	}

	public Viereck getParrent() {
		return parrent;
	}

	public void setParrent(Viereck parrent) {
		this.parrent = parrent;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

}
