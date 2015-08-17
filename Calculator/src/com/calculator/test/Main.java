package com.calculator.test;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.calculator.gui.SwingOperatorView;

public class Main {
	
	/** Fenetre de conversion avec des composants Swing */ 
    public SwingOperatorView		swingFrame;
	
    /** Positions (x,y) sur lesquels vont se fonder le positionnement de la fenetre graphique. */
    public int 						conversionFrameWidthPosition;
    public int 						conversionFrameHeightPosition;
    

	public static void main(String[] args) {
		new Main();
	}
    
	public Main() {
		try
        {	
            setPosition();
	        createSwingConversionFrame();
        }
        catch(Exception e) {
        	handleException(e);
        }
    }

	
	
	/** Calcul des valeurs necessaires au positionnement de la fenetre contenant le convertisseur */
    public void setPosition()
    {
    	// recupère les dimensions de la fenetre du poste client 
        // Remarque: appel à la classe Singleton Toolkit (Design Pattern de construction) !
    	Dimension screenDimension		= Toolkit.getDefaultToolkit().getScreenSize();	
    	conversionFrameWidthPosition	= (screenDimension.width - swingFrame.INT_FRAME_WIDTH) / 2;		
        conversionFrameHeightPosition	= (screenDimension.height - swingFrame.INT_FRAME_HEIGHT) / 2;
    }
		
    /** Cette methode est chargee d'instancier la fenetre qui convertit les infos */
    public void createSwingConversionFrame()
    {	
    	swingFrame 						= new SwingOperatorView();
		
		// on fixe les valeurs importantes de notre fenetre : taille, position, sa visibilite
		swingFrame.setSize(		swingFrame.INT_FRAME_WIDTH, swingFrame.INT_FRAME_HEIGHT);
		swingFrame.setLocation(	conversionFrameWidthPosition, conversionFrameHeightPosition);
		swingFrame.setVisible(	true) ;
    }
	
    
    public void handleException(Exception e)
    {
		System.out.println("exception " + e.toString());
		e.printStackTrace();	
    }
}
