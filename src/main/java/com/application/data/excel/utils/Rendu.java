package com.application.data.excel.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

public class Rendu extends JLabel implements ListCellRenderer<Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -49708162972833749L;
	ImageIcon okIcon; 
	ImageIcon errorIcon;
	Color selectCouleur = Color.RED;

	public  Rendu(){
		okIcon = new ImageIcon(this.getClass().getResource("/ok.png"));
		errorIcon = new ImageIcon(this.getClass().getResource("/error.png"));
	}
	
	@SuppressWarnings("rawtypes")
	public Component getListCellRendererComponent(JList list,Object value, int index, boolean isSelected,  boolean cellHasFocus) {
		String s = value.toString();
	//	System.out.println(s);
		if(s.length()>7)
			setText(s.substring(7));
		else
			setText(s);
		if (!isSelected) {
	 		if(s.startsWith("OK")){
		 		setBackground(Color.WHITE);
			    setForeground(UIManager.getColor("CheckBox.focus"));
			    setIcon(okIcon);
			}
	 		else if(s.startsWith("NONOK")){
	 			setBackground(Color.RED);
			    setForeground(Color.WHITE);
			    setIcon(errorIcon);
			}
	 		else{
	 			setBackground(Color.LIGHT_GRAY);
			    setForeground(Color.DARK_GRAY);
			    setText(s);
			}
	 	}else{
	 		if(s.startsWith("OK")){
		 		setBackground(UIManager.getColor("CheckBox.focus"));
			    setForeground(Color.WHITE);
			    setIcon(okIcon);
		 	}else if(s.startsWith("NONOK")){
	 			setBackground(Color.WHITE);
			    setForeground(Color.RED);
			    setIcon(errorIcon);
			}else{
		 		setBackground(Color.DARK_GRAY);
			    setForeground(Color.LIGHT_GRAY);
			    setText(s);
			}
	 	}
		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(true);
		return this;
	}

}