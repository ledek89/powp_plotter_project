package edu.iis.powp.adapter;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import edu.iis.client.plottermagic.IPlotter;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.panel.DrawPanelUI;
import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;


/**
 * Plotter adapter to drawer with several bugs. 
 */
public class PlotterAdapter implements IPlotter
{ 
	private int startX = 0, startY = 0;
	DrawPanelController dpc;
	
    public PlotterAdapter(DrawPanelController dpc) {
    	this.dpc = dpc;
	}
    
	@Override
    public void setPosition(int x, int y)
    {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void drawTo(int x, int y)
    {
        ILine line = LineFactory.getBasicLine();
    	line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
		dpc.drawLine(line);
		setPosition(x, y);
    }

    @Override
    public String toString()
    {
        return "Draw Simulator";
    }
    
}
