package edu.iis.powp.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.iis.powp.adapter.LinePlotterAdapter;
import edu.iis.client.plottermagic.ClientPlotter;
import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.adapter.PlotterAdapter;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.Context;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.appext.ApplicationWithDrawer;
import edu.iis.powp.events.predefine.SelectTestFigureOptionListener;
import edu.kis.powp.drawer.shape.LineFactory;


public class TestPlotSoftPatterns
{
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
    /**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param context Application context.
	 */
	private static void setupPresetTests(Context context) {
	    SelectTestFigureOptionListener selectTestFigureOptionListener = new SelectTestFigureOptionListener(1);
	    SelectTestFigureOptionListener selectTestSecFigureOptionListener = new SelectTestFigureOptionListener(2);
	    SelectTestFigureOptionListener selectTestThFigureOptionListener = new SelectTestFigureOptionListener(3);
	    SelectTestFigureOptionListener selectTestFourthFigureOptionListener = new SelectTestFigureOptionListener(4);
	    
		context.addTest("Figure Joe 1", selectTestFigureOptionListener);	
		context.addTest("Figure Joe 2", selectTestSecFigureOptionListener);
		context.addTest("Figure Joe 3", selectTestThFigureOptionListener);
		context.addTest("Figure Joe 4", selectTestFourthFigureOptionListener);
	}

	/**
	 * Setup driver manager, and set default IPlotter for application.
	 * 
	 * @param context Application context.
	 */
	private static void setupDrivers(Context context) {
		IPlotter clientPlotter = new ClientPlotter();
		context.addDriver("Client Plotter", clientPlotter);
		Application.getComponent(DriverManager.class).setCurrentPlotter(clientPlotter);
		
		IPlotter plotter = new PlotterAdapter(ApplicationWithDrawer.getDrawPanelController());
		context.addDriver("Draw Simulator", plotter);
		
		IPlotter linePlotter = new LinePlotterAdapter(ApplicationWithDrawer.getDrawPanelController(), LineFactory.getSpecialLine());
		context.addDriver("Line Plotter Adapter Simulator", linePlotter);

		context.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param context Application context.
	 */
//	private static void setupDefaultDrawerVisibilityManagement(Context context) {
//		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
//        context.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility", 
//        		new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
//        defaultDrawerWindow.setVisible(true);
//	}
	
	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param context Application context.
	 */
	private static void setupLogger(Context context) {
		Application.addComponent(Logger.class);
		context.addComponentMenu(Logger.class, "Logger", 0);
		context.addComponentMenuElement(Logger.class, "Clear log", (ActionEvent e) -> context.flushLoggerOutput());
		context.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> LOGGER.setLevel(Level.FINE));
		context.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> LOGGER.setLevel(Level.INFO));
		context.addComponentMenuElement(Logger.class, "Warning level", (ActionEvent e) -> LOGGER.setLevel(Level.WARNING));
		context.addComponentMenuElement(Logger.class, "Severe level", (ActionEvent e) -> LOGGER.setLevel(Level.SEVERE));
		context.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> LOGGER.setLevel(Level.OFF));
	}
		
    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ApplicationWithDrawer.configureApplication();
                Context context = Application.getComponent(Context.class);
                
                //setupDefaultDrawerVisibilityManagement(context);
                
            	setupDrivers(context);
            	setupPresetTests(context);
            	setupLogger(context);
            }

        });
    }

}
