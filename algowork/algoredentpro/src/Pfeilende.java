import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class Pfeilende extends JButton {

	int x = 20;
	int y = 20;
	private gui_fenster fenster;
	private Pfeilende end;
	int last_int = -1;
	ArrayList<Integer> pfeile_int = new ArrayList<Integer>();
	private boolean typ = false;
	
	public Pfeilende(gui_fenster fenster) {
		this.fenster = fenster;
		end = this;
		action();
	}
	
	public void notwendig() {
		
	}

	public void action() {
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			if(last_int != -1 && fenster.pfeilsetz == false) {
				fenster.pfeile.set(last_int, null);
				for(int i = 0;i < pfeile_int.size();i++) {
					fenster.pfeile.set((pfeile_int.get(i)), null);
					
				}
				fenster.canvas.repaint();
				}
				
			if(fenster.pfeilsetz==true&& fenster.pfeiltyp == typ) {
					fenster.ob2 = end;
					last_int = fenster.pfeile.size();
					pfeile_int.add(last_int);
					fenster.ob1.pfeil_in = last_int;
					fenster.pfeile.add(new pfeil(fenster.ob1, fenster.ob2,fenster,fenster.ob1.getPos(),fenster.pfeiltyp));
					fenster.canvas.repaint();
					fenster.pfeilsetz = false;
					}
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

	public gui_fenster getFenster() {
		return fenster;
	}

	public void setFenster(gui_fenster fenster) {
		this.fenster = fenster;
	}

	public Pfeilende getEnd() {
		return end;
	}

	public void setEnd(Pfeilende end) {
		this.end = end;
	}

	public int getLast_int() {
		return last_int;
	}

	public void setLast_int(int last_int) {
		this.last_int = last_int;
	}

	public ArrayList<Integer> getPfeile_int() {
		return pfeile_int;
	}

	public void setPfeile_int(ArrayList<Integer> pfeile_int) {
		this.pfeile_int = pfeile_int;
	}

	public boolean isTyp() {
		return typ;
	}

	public void setTyp(boolean typ) {
		this.typ = typ;
	}
	
	

}
