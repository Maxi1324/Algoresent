import java.awt.Graphics;
import java.awt.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class menu_bar extends JMenuBar {

	private gui_fenster fenster;
	private JMenuBar bar = new JMenuBar();
	private ArrayList<JMenu> menu = new ArrayList<JMenu>();
	private ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();
	private File altpath = new File(""); 
	
	public menu_bar(gui_fenster fenster) {
		this.fenster = fenster;
		menu.add(new JMenu("File"));
		menu.add(new JMenu("export"));
		items.add(new JMenuItem("export PNG"));
		bar.add(menu.get(0));
		menu.get(0).add(menu.get(1));
		menu.get(1).add(items.get(0));
		fenster.setJMenuBar(bar);

		items.get(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
	}

	public void save() {
//		fenster.canvas.getGraphics().create()
		try {
			JFileChooser choose = new JFileChooser("chooselocation");
//			choose.setFileSelectionMod(JFileChooser.DIRECTORIES_ONLY);
			if(!altpath.equals(new File("")))choose.setSelectedFile(altpath);
			choose.showOpenDialog(fenster);
			altpath = choose.getSelectedFile();
			BufferedImage bild = new BufferedImage(fenster.canvas.getWidth(), fenster.canvas.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics g1 = bild.createGraphics();
			fenster.canvas.print(g1);
			File pa = choose.getSelectedFile();
			
			if(!lastchars(4, choose.getSelectedFile().getPath()).equals(".png"))
			{
			
				pa = new File(punktweg(pa.getPath())+".png");
			}
			
			
			ImageIO.write(bild, "png",pa);
			
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	

    public String punktweg(String str) {
        String new1 = str;
        String new2 = "";
      
            for(int i = 0;i < new1.length();i++)
            {
                if(new1.charAt(i) != '.') {
                    new2+= new1.charAt(i);
                }
            }
      
        return new2;
    }
	
	public String lastchars(int n,String str) {
		String str1 = "";
		if(n > str.length())return "";
		for(int i = 0;i <n;i++) {
			
		   str1 += str.charAt((str.length())-n+i);
		}
		return str1;
	}
}