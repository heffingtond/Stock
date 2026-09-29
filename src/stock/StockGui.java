package stock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class StockGui 
{
    public static void main(String[] args) 
    {
        // Ensure GUI updates are performed on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> 
        {
            runGui();
        });
    }
    
    private static void runGui()
    {
        // Create the main application frame
        JFrame frame = new JFrame( "Stock Research" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); // Close operation
        frame.setSize( 450, 995 ); // width, height
        frame.setLocationRelativeTo( null ); // Center the frame on the screen

        // Create a panel to hold components
        JPanel panel = new JPanel();
        frame.add( panel );
        placeDeltaComponents( panel );
        placeTargetComponents( panel );
        // placeCurrentPriceComponents( panel );

        ImageIcon imageIcon = new ImageIcon( "Icon1.jpg" );
        frame.setIconImage( imageIcon.getImage() );

        // Make the frame visible
        frame.setVisible( true );
    }
    
    private static void resetTool( JLabel statusLabel, JTextArea textArea )
    {
        textArea.setText( "" );
        statusLabel.setText( "Running..." );
    }

    private static void placeDeltaComponents( JPanel panel ) 
    {
    	final int MAX_DISPLAYED_EARNINGS = 4;
        panel.setLayout( null ); // Use null layout for absolute positioning (for simplicity)

        // Create labels for the first tool
        JLabel synopsisLabel = new JLabel( "This tool reports any ticker(s) that" );
        synopsisLabel.setBounds( 100, 10, 300, 25 ); // x, y, width, height
        panel.add( synopsisLabel );
        JLabel synopsisLabel2 = new JLabel( "decreased >= the entered delta value" );
        synopsisLabel2.setBounds( 100, 25, 300, 25 ); // x, y, width, height
        panel.add( synopsisLabel2 );
        JLabel synopsisLabel3 = new JLabel( "since the previous close." );
        synopsisLabel3.setBounds( 100, 40, 300, 25 ); // x, y, width, height
        panel.add( synopsisLabel3 );

        
        JLabel tickerLabel = new JLabel( "Enter ticker symbol(s).  If more" );
        tickerLabel.setBounds( 100, 70, 200, 25 ); // x, y, width, height
        panel.add( tickerLabel );
        JLabel tickerLabel2 = new JLabel( "than one, separate with comma: " );
        tickerLabel2.setBounds( 100, 85, 200, 25 ); // x, y, width, height
        panel.add( tickerLabel2 );

        // Create field for input
        JTextField tickerInputField = new JTextField( 40 );
        tickerInputField.setBounds( 100, 115, 250, 25 ); // x, y, width, height
        panel.add( tickerInputField );

        JLabel deltaLabel = new JLabel( "Enter Delta: %" );
        deltaLabel.setBounds( 100, 145, 200, 25 ); // x, y, width, height
        panel.add( deltaLabel );

        JTextField deltaInputField = new JTextField( 20 );
        deltaInputField.setBounds( 100, 175, 50, 25 ); // x, y, width, height
        panel.add( deltaInputField );

        
        // Create a delta button
        JButton submitDeltaButton = new JButton( "Submit" );
        submitDeltaButton.setBounds( 200, 145, 100, 30 );
        panel.add( submitDeltaButton );

        JLabel statusLabel = new JLabel( "" );
        statusLabel.setBounds( 200, 180, 200, 25 ); // x, y, width, height
        panel.add( statusLabel );

        JTextArea textArea = new JTextArea();
        textArea.setEditable( false ); // Make it non-editable

        JScrollPane scrollPane = new JScrollPane( textArea );
        scrollPane.setBounds( 50, 210, 350, 211 );
        panel.add( scrollPane );
        
        // Add an ActionListener to the button
        submitDeltaButton.addActionListener( new ActionListener() 
        {
            @Override
            public void actionPerformed( ActionEvent e ) 
            {
            	resetTool( statusLabel, textArea );
                String tickerText = tickerInputField.getText(); // Get text from the input field
                String deltaText = deltaInputField.getText(); // Get text from the input field
                ArrayList<DisplayDataBean> returnList = StockUtils.checkDeltas( tickerText, deltaText );
                for ( DisplayDataBean display : returnList )
                {
                    textArea.append("Symbol " + display.getSymbol() + ".\n");
                    textArea.append("Name " + display.getName() + ".\n");
                    textArea.append("Current Price " + display.getPrice() + ".\n");
                    textArea.append("Delta " + display.getChangePercentage() + ".\n");
                    textArea.append("Open " + display.getOpen() + ".\n");
                    textArea.append("High " + display.getDayHigh() + ".\n");
                    textArea.append("Low " + display.getDayLow() + ".\n");
                    textArea.append("Previous close " + display.getPreviousClose() + ".\n");
                    textArea.append("Volume " + display.getVolume() + ".\n");
                    textArea.append("Rating " + display.getRating() + ".\n");
                    textArea.append("AltmanZ Score " + display.getAltmanZScore() + ".\n");
                    textArea.append("Piotroski Score " + display.getPiotroskiScore() + ".\n");

                    textArea.append("EARNINGS:" + ".\n");
                    EarningsBean tempEarningsBean = null;
                    
                    int numberOfDisplayedEarnings = MAX_DISPLAYED_EARNINGS;
                    if ( numberOfDisplayedEarnings > display.getAllEarnings().size() )
                    	numberOfDisplayedEarnings = display.getAllEarnings().size();
                    
                    for ( int i = 0; i < numberOfDisplayedEarnings; i++ )
                    {
                    	tempEarningsBean = display.getAllEarnings().get( i );
                        String earningsReport = "Date: " + tempEarningsBean.getDate() 
                        					  + ", EPS Est: " + tempEarningsBean.getEpsEstimated()
                        					  + ", EPS Act: " + tempEarningsBean.getEpsActual();
                        if ( tempEarningsBean.getEpsEstimated() != null && tempEarningsBean.getEpsActual() != null )
                        {
                            // See if 'missed' or 'beat':
                        	double epsEst = Double.parseDouble( tempEarningsBean.getEpsEstimated() );
                        	double epsAct = Double.parseDouble( tempEarningsBean.getEpsActual() );
                        	if ( epsEst > epsAct ) // missed
                        		earningsReport += " MISSED";
                        	else
                        	if ( epsEst < epsAct ) // beat
                        		earningsReport += " **BEAT**";
                        }
                        textArea.append( earningsReport + ".\n");
                    }
                    
                    textArea.append("Timestamp " + display.getTimestamp() + ".\n");
                    textArea.append("----------------------------------" + "\n");
                }
                if ( returnList.size() == 0 )
                	statusLabel.setText( "None found" );
                else
                	statusLabel.setText( "Done" );
            }
        });
     }

    private static void placeTargetComponents( JPanel panel ) 
    {
    	final int MAX_DISPLAYED_EARNINGS = 4; 
        panel.setLayout( null ); // Use null layout for absolute positioning (for simplicity)

        // Create labels for the first tool
        JLabel synopsisLabel = new JLabel( "This tool reports the ticker(s) current snapshot" );
        synopsisLabel.setBounds( 100, 425, 300, 25 ); // x, y, width, height
        panel.add( synopsisLabel );
        JLabel synopsisLabel2 = new JLabel( "along with the consensus target value." );
        synopsisLabel2.setBounds( 100, 440, 300, 25 ); // x, y, width, height
        panel.add( synopsisLabel2 );
        
        // Create field for input
        JTextField tickerInputField = new JTextField( 40 );
        tickerInputField.setBounds( 50, 465, 250, 25 ); // x, y, width, height
        panel.add( tickerInputField );
        
        // Create a target button
        JButton submitTargetButton = new JButton( "Submit" );
        submitTargetButton.setBounds( 310, 460, 100, 30 );
        panel.add( submitTargetButton );

        JLabel targetStatusLabel = new JLabel( "" );
        targetStatusLabel.setBounds( 310, 485, 200, 25 ); // x, y, width, height
        panel.add( targetStatusLabel );

        JTextArea targetTextArea = new JTextArea();
        targetTextArea.setEditable( false ); // Make it non-editable

        JScrollPane targetScrollPane = new JScrollPane( targetTextArea );
        targetScrollPane.setBounds( 50, 505, 350, 205 );
        panel.add( targetScrollPane );
        
        JCheckBox increasedEps = new JCheckBox("Estimated Increase in EPS", true); 
        increasedEps.setBounds( 50, 720, 500, 30 );
        panel.add( increasedEps );

        JCheckBox upside20Percent = new JCheckBox("20% upside or better", true); 
        upside20Percent.setBounds( 50, 740, 500, 30 );
        panel.add( upside20Percent );

        JCheckBox bMinusOrBetter = new JCheckBox("Overall Rating B- or Better", true); 
        bMinusOrBetter.setBounds( 50, 760, 500, 30 );
        panel.add( bMinusOrBetter );
        
        // Add an ActionListener to the button
        submitTargetButton.addActionListener( new ActionListener() 
        {
            @Override
            public void actionPerformed( ActionEvent e ) 
            {
            	resetTool( targetStatusLabel, targetTextArea );
                String tickerText = tickerInputField.getText(); // Get text from the input field
                ArrayList<DisplayPriceToTargetBean> returnList = StockUtils.displayPriceToTarget( tickerText );
                for ( DisplayPriceToTargetBean display : returnList )
                {
                	boolean displayOnReport = true;
                	// If the 'Estimated Increase in EPS' check box is checked, disregard any tickers that do not project an increase.
                	if ( increasedEps.isSelected() )
                	{
                		// Spin through the entire group and collect the latest entries for actual and estimated EPS.
                        String lastEpsAct = null;
                        String lastEpsEst = null;
                        ArrayList<EarningsBean> tempAllEarnings = new ArrayList<EarningsBean>();
                        tempAllEarnings.addAll( display.getAllEarnings() );
                        
                        // Sort by the 'date' String property (Descending)
                        tempAllEarnings.sort( Comparator.comparing( EarningsBean::getDate ) );
                        
                        for ( EarningsBean tempEarningsBean : tempAllEarnings )
                        {
                        	if ( ! StockUtils.isEmpty( tempEarningsBean.getEpsActual() ) )
                        		lastEpsAct = tempEarningsBean.getEpsActual();
                        	if ( ! StockUtils.isEmpty( tempEarningsBean.getEpsEstimated() ) )
                        		lastEpsEst = tempEarningsBean.getEpsEstimated();
                        }
                        // Now compare the last estimated EPS to the last actual EPS and see if there is a projected increase.
                        if ( ! StockUtils.isEmpty( lastEpsAct ) && ! StockUtils.isEmpty( lastEpsEst ) )
                        {
                        	double lastActual = Double.parseDouble( lastEpsAct );
                        	double lastEstimated = Double.parseDouble( lastEpsEst );
                        	if ( lastEstimated < lastActual )
                        	{
                            	System.out.println( "EPS decrease anticipated.  Drop from display. " + display.getSymbol() );
                        		displayOnReport = false;
                        	}
                        }
                	}

                    String upside = StockUtils.getUpside( display.getPrice(), display.getTargetConsensus() );

                    if ( upside20Percent.isSelected() )
	                	if ( displayOnReport )
	                	{
	                		Double upsideDouble = 0.0;
	                		// Then check to see if the projected upside is 20 percent or more (only if the 20% upside check box is checked)
	                		try
	                		{
	                			upsideDouble = Double.parseDouble( upside );
	                		}
	                		catch( Exception ex )
	                		{
	                			ex.printStackTrace();
	                			System.out.println( "Could not parse upside to double: " + upsideDouble );
	                		}
	                		if ( upsideDouble < 20 )
	                		{
                            	System.out.println( "Projected upside less than 20%.  Drop from display. " + display.getSymbol() );
	                			displayOnReport = false;
	                		}
	                	}
                    
                    if ( bMinusOrBetter.isSelected() )
	                	if ( displayOnReport )
	                	{
	                		final ArrayList<String> ACCEPTABLE_RANGE = new ArrayList<String>();
	                		ACCEPTABLE_RANGE.add( "B-" );
	                		ACCEPTABLE_RANGE.add( "B" );
	                		ACCEPTABLE_RANGE.add( "B+" );
	                		ACCEPTABLE_RANGE.add( "A-" );
	                		ACCEPTABLE_RANGE.add( "A" );
	                		ACCEPTABLE_RANGE.add( "A+" );
	                		ACCEPTABLE_RANGE.add( "S-" );
	                		ACCEPTABLE_RANGE.add( "S" );
	                		ACCEPTABLE_RANGE.add( "S+" );
	                		String overallRating = display.getRating();
	                		if ( overallRating != null )
	                			overallRating = overallRating.trim();
	                		
	                		if ( ! ACCEPTABLE_RANGE.contains( overallRating ) )
	                		{
                            	System.out.println( "Rating lower than B-.  Drop from display. " + display.getSymbol() );
	                			displayOnReport = false;
	                		}
	                	}
                    
                	
                	if ( displayOnReport )
                	{
	                    targetTextArea.append("Symbol " + display.getSymbol() + ".\n");
	                    targetTextArea.append("Target Consensus " + display.getTargetConsensus() + ".\n");
	                    targetTextArea.append("Current Price " + display.getPrice() + ".\n");
	                    targetTextArea.append("Upside % " + upside  + ".\n");
	                    if ( display.getVolume() == null )
	                    	targetTextArea.append("Volume not listed (after hours)" + ".\n");
	                    else
	                    	targetTextArea.append("Volume " + display.getVolume() + ".\n");
	                    targetTextArea.append("Rating " + display.getRating() + ".\n");
	                    targetTextArea.append("AltmanZ Score " + display.getAltmanZScore() + ".\n");
	                    targetTextArea.append("Piotroski Score " + display.getPiotroskiScore() + ".\n");
	                    
	                    int numberOfDisplayedEarnings = MAX_DISPLAYED_EARNINGS;
	                    if ( numberOfDisplayedEarnings > display.getAllEarnings().size() )
	                    	numberOfDisplayedEarnings = display.getAllEarnings().size();
	
	                    targetTextArea.append("EARNINGS:" + ".\n");
	                    EarningsBean tempEarningsBean = null;
	                    for ( int i = 0; i < numberOfDisplayedEarnings; i++ )
	                    {
	                    	tempEarningsBean = display.getAllEarnings().get( i );
	                        String earningsReport = "Date: " + tempEarningsBean.getDate() 
	                        					  + ", EPS Est: " + tempEarningsBean.getEpsEstimated()
	                        					  + ", EPS Act: " + tempEarningsBean.getEpsActual();
	                        if ( tempEarningsBean.getEpsEstimated() != null && tempEarningsBean.getEpsActual() != null )
	                        {
	                            // See if 'missed' or 'beat':
	                        	double epsEst = Double.parseDouble( tempEarningsBean.getEpsEstimated() );
	                        	double epsAct = Double.parseDouble( tempEarningsBean.getEpsActual() );
	                        	if ( epsEst > epsAct ) // missed
	                        		earningsReport += " MISSED";
	                        	else
	                        	if ( epsEst < epsAct ) // beat
	                        		earningsReport += " **BEAT**";
	                        }
	                        targetTextArea.append( earningsReport + ".\n");
	                    }
	                    
	                    targetTextArea.append("Timestamp " + display.getTimestamp() + ".\n");
	                    targetTextArea.append("----------------------------------" + "\n");
	                }
                }
                if ( returnList.size() == 0 )
                	targetStatusLabel.setText( "None found" );
                else
                	targetStatusLabel.setText( "Done" );
            }
        });
     }
}
