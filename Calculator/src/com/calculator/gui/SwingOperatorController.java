package com.calculator.gui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import com.calculator.utils.Executor;

public class SwingOperatorController {

	private SwingOperatorView view = null;
	
	public SwingOperatorController(SwingOperatorView view) {
		this.setView(view);
	}
	
	// key pad action listener method 
	public void KeyPadActionPerformed(ActionEvent e) {
		System.out.println("numPad :: " + e.getActionCommand());
		String label = (!this.view.getResultLabel().equals("")) ? this.view.getResultLabel() : "";
		if (e.getActionCommand() != "C") 
			label += e.getActionCommand();
		else	
			label = "";
		SwingOperatorView.updateLabel(label);
	}
	
	// the opperator action listener method
	public void OppPadActionPerformed(ActionEvent e) {
		System.out.println("oppPad :: " + e.getActionCommand());
		String label = (!this.view.getResultLabel().equals("")) ? this.view.getResultLabel() : "";
		double result = 0;
		switch (e.getActionCommand()) {
		case "+" : 
			if (!this.checkError() && this.valideEntry(label)) {
				result = this.executeOpperation(this.view.getResultLabel());
				label = Double.toString(result) + " + ";
			} else {
				label += " + ";
			}
			SwingOperatorView.updateLabel(label);
			result = 0;
			break;
			
		case "-" :
			if (!this.checkError() && this.valideEntry(label)) {
				result = this.executeOpperation(this.view.getResultLabel());
				label = Double.toString(result) +  " - ";
			} else {
				label += " - ";
			}
			SwingOperatorView.updateLabel(label);
			result = 0;
			break;
			
		case "*" :
			if (!this.checkError() && this.valideEntry(label)) {
				result = this.executeOpperation(this.view.getResultLabel());
				label = Double.toString(result) +  " * ";
			} else {
				label += " x ";
			}
			SwingOperatorView.updateLabel(label);
			result = 0;
			break;
			
		case "/" : 
			if (!this.checkError() && this.valideEntry(label)) {
				result = this.executeOpperation(this.view.getResultLabel());
				label = Double.toString(result) + " / ";
			} else {
				label += " / ";
			}
			SwingOperatorView.updateLabel(label);
			result = 0;
			break;
			
		case "=" : 
			result = this.executeOpperation(this.view.getResultLabel());
			SwingOperatorView.updateLabel(Double.toString(result));
			result = 0;
			break;
		}	
	}
	
	// execute the operation set in the label
	// if the label contains two successive operator, will have an error
	private double executeOpperation(String label) {
		if (!label.contains("  ")) {
			String split [] = label.split(" ");
			double value1 = Double.parseDouble(split[0]);
			double value2 = Double.parseDouble(split[2]);
			double result = 0;
			switch (split[1]) {
				case "+" :
					result = Executor.add(value1, value2);
					break;
				case "-" :
					result = Executor.sub(value1, value2);
					break;
				case "*" :
					result = Executor.mult(value1, value2);
					break;
				case "/" :
					result = Executor.div(value1, value2);
					break;
			}
			return result;	
		}
		else {
			SwingOperatorView.updateLabel("ERROR : TWO SUCCESIVE OPPERATOR !");
			return -1;
		}
		
	}
	
	// check if the view JLabel we have "ERROR" 
	private boolean checkError() {
		return this.view.getResultLabel().contains("ERROR") ? true : false;
	}
	
	// check if the label String we get is a valid
	// two value plus an operator
	private boolean valideEntry(String label) {
		return label.contains( "+") ||
				label.contains( "-") ||
				label.contains( "/") || 
				label.contains( "*") ? true : false;			
	}
	

////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Application ending
////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int byeBye() {
		// la fenetre fixe sa propriete de visibilite à "faux"
		view.setVisible(false);

		// Declaration d'inutilite de l'object courant en vue de son traitement
		// par le Garbage Collector
		view.dispose();

		// Exit de la machine virtuelle, en specifiant une valeur de retour.
		return JFrame.EXIT_ON_CLOSE;
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//GET SET
////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public SwingOperatorView getView() {
		return view;
	}

	public void setView(SwingOperatorView view) {
		this.view = view;
	}

}
