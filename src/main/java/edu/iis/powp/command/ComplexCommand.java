package edu.iis.powp.command;

import java.util.List;

import edu.iis.client.plottermagic.IPlotter;

public class ComplexCommand implements PlotterCommand{

	private List<PlotterCommand> queue;
	
	public List<PlotterCommand> getQueue() {
		return queue;
	}

	public void setQueue(List<PlotterCommand> queue) {
		this.queue = queue;
	}

	public ComplexCommand(List<PlotterCommand> queue) {
		super();
		this.queue = queue;
	}
	
	@Override
	public void execute(IPlotter driver) {
		for(Object command : queue){
			((PlotterCommand)command).execute(driver);
		}
	}
	

}
