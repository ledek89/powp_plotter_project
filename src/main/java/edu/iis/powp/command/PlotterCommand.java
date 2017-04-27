package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;

//Chodzi o wzorzec kompozyt

public interface PlotterCommand {

	public void execute(IPlotter driver);
}
