package edu.iis.powp.events.predefine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.FactoryCommand;

public class SelectTestFigureOptionListener implements ActionListener
{
	private int selectedFigure;
	
	public SelectTestFigureOptionListener(int selectedFigure) {
		this.selectedFigure = selectedFigure;
	}

    @Override
    public void actionPerformed(ActionEvent e)
    {
    	if(selectedFigure == 1){
    		FiguresJoe.figureScript1(Application.getComponent(DriverManager.class).getCurrentPlotter());
    	}else if(selectedFigure == 2){
    		FiguresJoe.figureScript2(Application.getComponent(DriverManager.class).getCurrentPlotter());
    	}else if(selectedFigure == 3){
    		FactoryCommand.createRectangle(-100, -100, 200, 270).execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
    	}else if(selectedFigure == 4){
    		FactoryCommand.createIsoscelesTriangle(0, -50, 150, 250).execute(Application.getComponent(DriverManager.class).getCurrentPlotter());
    	}    	
    }
}
