import java.awt.Color;

public class pfeil_kreis_zuruck extends Pfeilstart{
	
	private gui_fenster fenster;
	
	public pfeil_kreis_zuruck(gui_fenster fenster,Viereck parrent)
	{
		super(fenster, 0, parrent);
		setSize(20,20);
		this.fenster = fenster;
	}
	
	@Override
	public void actionlistner1() {
		super.actionlistner1();
		fenster.pfeiltyp = true;
		
	}
	
}
