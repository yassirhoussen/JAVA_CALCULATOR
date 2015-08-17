package com.calculator.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/** add the import for the proxy here 
 *	to allow the interception of the action event 
 **/ 
import static com.calculator.utils.ListenerProxies.actionListener;

public class SwingOperatorView extends JFrame implements IOperators {

	private static final long serialVersionUID = -3830527684084799346L;

	/** JButton */
	private JButton buttonAdd 	= null;
	private JButton buttonSub 	= null;
	private JButton buttonDiv 	= null;
	private JButton buttonMult 	= null;
	private JButton buttonEqual = null;

	private JButton buttonOne 	= null;
	private JButton buttonTwo 	= null;
	private JButton buttonThree = null;
	private JButton buttonFour 	= null;
	private JButton buttonFive 	= null;
	private JButton buttonSix 	= null;
	private JButton buttonSeven = null;
	private JButton buttonEight = null;
	private JButton buttonNine 	= null;
	private JButton buttonZero 	= null;
	private JButton buttonDot 	= null;
	private JButton buttonClear = null;

	/** Jlabel */
	private JLabel resultLabel = null;

	/** Controller */
	private SwingOperatorController controller = null;

	/** Static this*/
	private static SwingOperatorView _this = null;
	
	public SwingOperatorView() {
		super();
		this.initController();
		SwingOperatorView._this = this;
		this.init();
	}

	/**invoke the GUI in a new thread **/
	private void init () {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SwingOperatorView.stateOnCurrentObject();
            }
		});
	}
	
	private void initController() {
		this.controller = new SwingOperatorController(this);
	}

	
    private static void stateOnCurrentObject() {
    	_this.setDefaultCloseOperation(_this.controller.byeBye());
    	_this.setLayout(new BorderLayout());
    	_this.getContentPane().add(	SwingOperatorView.setLabel(), 		BorderLayout.PAGE_START	);
    	_this.getContentPane().add(	SwingOperatorView.setKeyPad(), 		BorderLayout.LINE_START	);
    	_this.getContentPane().add(	SwingOperatorView.setOperatorPad(), BorderLayout.LINE_END	);
    	_this.pack();
        _this.setVisible(true);
    }
    
    private static JPanel setKeyPad () {
    	JPanel panKey 			= new JPanel();
    	GridLayout grid			= new GridLayout (4,3);
    	
    	_this.buttonOne 		= new JButton(	STR_NUM_ONE		);
    	_this.buttonTwo 		= new JButton(	STR_NUM_TWO		);
    	_this.buttonThree 		= new JButton(	STR_NUM_THREE	);
    	_this.buttonFour 		= new JButton(	STR_NUM_FOUR	);
    	_this.buttonFive 		= new JButton(	STR_NUM_FIVE	);
    	_this.buttonSix 		= new JButton(	STR_NUM_SIX		);
    	_this.buttonSeven 		= new JButton(	STR_NUM_SEVEN	);
    	_this.buttonEight 		= new JButton(	STR_NUM_EIGHT	);
    	_this.buttonNine 		= new JButton(	STR_NUM_NINE	);
    	_this.buttonZero 		= new JButton(	STR_NUM_ZERO	);
    	_this.buttonDot 		= new JButton(	STR_NUM_DOT		);
    	_this.buttonClear		= new JButton(	STR_NUM_CLEAR	);
    	
    	// a sample for using the proxy
    	// we used the method actionListener define in ListenerProxies.class
    	// we have two params : 
    	// - first is the target object
    	// - the method we want to use
    	_this.buttonOne.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	_this.buttonTwo.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	_this.buttonThree.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	_this.buttonFour.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	_this.buttonFive.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	_this.buttonSix.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	_this.buttonSeven.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	_this.buttonEight.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	_this.buttonNine.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	_this.buttonZero.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	_this.buttonDot.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	_this.buttonClear.addActionListener	(	actionListener	(_this.controller, "KeyPadActionPerformed")	);
    	
    	panKey.setLayout(grid);
    	panKey.add( _this.buttonOne 	);
    	panKey.add( _this.buttonTwo 	);
    	panKey.add( _this.buttonThree 	);
    	panKey.add( _this.buttonFour 	);
    	panKey.add( _this.buttonFive 	);
    	panKey.add( _this.buttonSix 	);
    	panKey.add( _this.buttonSeven 	);
    	panKey.add( _this.buttonEight 	);
    	panKey.add( _this.buttonNine 	);
    	panKey.add( _this.buttonZero 	);
    	panKey.add( _this.buttonDot 	);
    	panKey.add( _this.buttonClear   );
    	
    	return panKey;
    }
    
    private static JPanel setOperatorPad () {
    	JPanel panOpp 			= new JPanel();
    	GridLayout grid			= new GridLayout (5,1);
    	
    	_this.buttonAdd 	= new JButton(	STR_OPP_ADD		);
    	_this.buttonSub 	= new JButton(	STR_OPP_SUB		);
    	_this.buttonDiv 	= new JButton(	STR_OPP_DIV		);
    	_this.buttonMult 	= new JButton(	STR_OPP_MULT	);
    	_this.buttonEqual 	= new JButton(	STR_OPP_EQUAL	);
    	
    	_this.buttonAdd.addActionListener	(	actionListener	(_this.controller, "OppPadActionPerformed")	);
    	_this.buttonSub.addActionListener	(	actionListener	(_this.controller, "OppPadActionPerformed")	);
    	_this.buttonDiv.addActionListener	(	actionListener	(_this.controller, "OppPadActionPerformed")	);
    	_this.buttonMult.addActionListener	(	actionListener	(_this.controller, "OppPadActionPerformed")	);
    	_this.buttonEqual.addActionListener	(	actionListener	(_this.controller, "OppPadActionPerformed")	);
    	
    	panOpp.setLayout(grid);
    	panOpp.add( _this.buttonAdd 	);
    	panOpp.add( _this.buttonSub 	);
    	panOpp.add( _this.buttonDiv 	);
    	panOpp.add( _this.buttonMult 	);
    	panOpp.add( _this.buttonEqual 	);
    	
    	return panOpp;
    }
    
    private static JPanel setLabel () {
    	JPanel panLab 			= new JPanel();
    	GridLayout grid			= new GridLayout(1,1);
    	
    	_this.resultLabel = new JLabel("");
    	_this.resultLabel.setPreferredSize( new Dimension( INT_FRAME_WIDTH - 10, 20) );
    	_this.resultLabel.setForeground(new Color(0, 0, 0));
    	
    	panLab.setPreferredSize( new Dimension(INT_FRAME_WIDTH - 10, 30) );
    	panLab.setBackground( new Color(255,255,255) );
    	
    	panLab.setLayout(grid);
    	panLab.add( _this.resultLabel 	);

    	return panLab;
    }
    
    public static void updateLabel(String value) {
    	_this.resultLabel.setText(value);
    }

	public String getResultLabel() {
		return resultLabel.getText();
	}

	public void setResultLabel(String resultLabel) {
		this.resultLabel.setText(resultLabel);
	}
    
}
