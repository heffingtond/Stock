package stock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
        placeCurrentPriceComponents( panel );

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
        scrollPane.setBounds( 50, 210, 350, 176 );
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
        panel.setLayout( null ); // Use null layout for absolute positioning (for simplicity)

        // Create labels for the first tool
        JLabel synopsisLabel = new JLabel( "This tool reports the ticker(s) current snapshot" );
        synopsisLabel.setBounds( 100, 400, 300, 25 ); // x, y, width, height
        panel.add( synopsisLabel );
        JLabel synopsisLabel2 = new JLabel( "along with the consensus target value." );
        synopsisLabel2.setBounds( 100, 415, 300, 25 ); // x, y, width, height
        panel.add( synopsisLabel2 );
        
        JLabel tickerLabel = new JLabel( "Enter ticker symbol(s).  If more" );
        tickerLabel.setBounds( 100, 435, 200, 25 ); // x, y, width, height
        panel.add( tickerLabel );
        JLabel tickerLabel2 = new JLabel( "than one, separate with comma: " );
        tickerLabel2.setBounds( 100, 450, 200, 25 ); // x, y, width, height
        panel.add( tickerLabel2 );

        // Create field for input
        JTextField tickerInputField = new JTextField( 40 );
        tickerInputField.setBounds( 50, 480, 250, 25 ); // x, y, width, height
        panel.add( tickerInputField );
        
        // Create a target button
        JButton submitTargetButton = new JButton( "Submit" );
        submitTargetButton.setBounds( 310, 470, 100, 30 );
        panel.add( submitTargetButton );

        JLabel targetStatusLabel = new JLabel( "" );
        targetStatusLabel.setBounds( 310, 500, 200, 25 ); // x, y, width, height
        panel.add( targetStatusLabel );

        JTextArea targetTextArea = new JTextArea();
        targetTextArea.setEditable( false ); // Make it non-editable

        JScrollPane targetScrollPane = new JScrollPane( targetTextArea );
        targetScrollPane.setBounds( 50, 520, 350, 170 );
        panel.add( targetScrollPane );
        
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
                    targetTextArea.append("Symbol " + display.getSymbol() + ".\n");
                    targetTextArea.append("Target Consensus " + display.getTargetConsensus() + ".\n");
                    targetTextArea.append("Current Price " + display.getPrice() + ".\n");
                    if ( display.getVolume() == null )
                    	targetTextArea.append("Volume not listed (after hours)" + ".\n");
                    else
                    	targetTextArea.append("Volume " + display.getVolume() + ".\n");
                    targetTextArea.append("Rating " + display.getRating() + ".\n");
                    targetTextArea.append("AltmanZ Score " + display.getAltmanZScore() + ".\n");
                    targetTextArea.append("Piotroski Score " + display.getPiotroskiScore() + ".\n");
                    targetTextArea.append("Timestamp " + display.getTimestamp() + ".\n");
                    targetTextArea.append("----------------------------------" + "\n");
                }
                if ( returnList.size() == 0 )
                	targetStatusLabel.setText( "None found" );
                else
                	targetStatusLabel.setText( "Done" );
            }
        });
     }

    private static void placeCurrentPriceComponents( JPanel panel ) 
    {
        panel.setLayout( null ); // Use null layout for absolute positioning (for simplicity)

        JLabel synopsisLabel = new JLabel( "This tool reports the ticker(s) current price" );
        synopsisLabel.setBounds( 100, 700, 300, 25 ); // x, y, width, height
        panel.add( synopsisLabel );
        JLabel synopsisLabel2 = new JLabel( "(after hours included)." );
        synopsisLabel2.setBounds( 100, 715, 300, 25 ); // x, y, width, height
        panel.add( synopsisLabel2 );
        
        // Create field for input
        JTextField tickerInputField = new JTextField( 40 );
        tickerInputField.setBounds( 50, 735, 250, 25 ); // x, y, width, height
        panel.add( tickerInputField );
        
        // Create a button
        JButton submitCurrentPriceButton = new JButton( "Submit" );
        submitCurrentPriceButton.setBounds( 310, 730, 100, 30 );
        panel.add( submitCurrentPriceButton );

        JLabel currentPriceStatusLabel = new JLabel( "" );
        currentPriceStatusLabel.setBounds( 310, 755, 200, 25 ); // x, y, width, height
        panel.add( currentPriceStatusLabel );

        JTextArea currentPriceTextArea = new JTextArea();
        currentPriceTextArea.setEditable( false ); // Make it non-editable

        JScrollPane currentPriceScrollPane = new JScrollPane( currentPriceTextArea );
        currentPriceScrollPane.setBounds( 50, 780, 350, 170 );
        panel.add( currentPriceScrollPane );

        // Add an ActionListener to the button
        submitCurrentPriceButton.addActionListener( new ActionListener() 
        {
            @Override
            public void actionPerformed( ActionEvent e ) 
            {
            	resetTool( currentPriceStatusLabel, currentPriceTextArea );
                String tickerText = tickerInputField.getText(); // Get text from the input field
                ArrayList<DisplayCurrentPriceBean> returnList = StockUtils.displayCurrentPrice( tickerText );
                for ( DisplayCurrentPriceBean display : returnList )
                {
                    currentPriceTextArea.append("Symbol " + display.getSymbol() + ".\n");
                    currentPriceTextArea.append("Current Price " + display.getPrice() + ".\n");
                    if ( display.getVolume() == null )
                        currentPriceTextArea.append("Volume not listed (after hours)" + ".\n");
                    else
                    	currentPriceTextArea.append("Volume " + display.getVolume() + ".\n");
                    currentPriceTextArea.append("Timestamp " + display.getTimestamp() + ".\n");
                    currentPriceTextArea.append("----------------------------------" + "\n");
                }
                if ( returnList.size() == 0 )
                	currentPriceStatusLabel.setText( "None found" );
                else
                	currentPriceStatusLabel.setText( "Done" );
            }
        });
     }
}
