package com.calculator.gui;

import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JPanel;

public interface IOperators {

	/** OPERATEUR DE CALCUL */
	public String 		STR_OPP_ADD			= "+";
	public String 		STR_OPP_SUB			= "-";
	public String 		STR_OPP_MULT		= "*";
	public String 		STR_OPP_DIV			= "/";
	
	/** OPERATEUR EGAL */
	public String 		STR_OPP_EQUAL		= "=";
	
	/** OPERATEUR NUMERAIRE */
	public String 		STR_NUM_ONE				= "1";
	public String 		STR_NUM_TWO				= "2";
	public String 		STR_NUM_THREE			= "3";
	public String 		STR_NUM_FOUR			= "4";
	public String 		STR_NUM_FIVE			= "5";
	public String 		STR_NUM_SIX				= "6";
	public String 		STR_NUM_SEVEN			= "7";
	public String 		STR_NUM_EIGHT			= "8";
	public String 		STR_NUM_NINE			= "9";
	public String 		STR_NUM_ZERO			= "0";
	public String 		STR_NUM_DOT				= ".";
	public String 		STR_NUM_CLEAR			= "C";
	
	
	/** FRAME SIZE */
	public static int			INT_FRAME_WIDTH			= 370;
	public static int			INT_FRAME_HEIGHT		= 400;
	
	/** Une Police de caractere */
	public Font			FONT_PANEL						= new Font("Arial", Font.PLAIN , 13);
	
	/** Object permettant de calculer la taille en pixel des textes utilises */
	public FontMetrics	FONT_METRICS						= new JPanel().getFontMetrics(FONT_PANEL);
	
}
