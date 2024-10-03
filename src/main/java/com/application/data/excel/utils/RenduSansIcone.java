package com.application.data.excel.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RenduSansIcone extends JLabel implements ListCellRenderer<Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -49708162972833749L;
	ImageIcon okIcon; 
	ImageIcon errorIcon;
	Color selectCouleur = Color.RED;

	public  RenduSansIcone(){
	}
	
	@SuppressWarnings("rawtypes")
	public Component getListCellRendererComponent(JList list,Object value, int index, boolean isSelected,  boolean cellHasFocus) {
		String s = value.toString();
		setText(s);
		//s.substring(1);
	 	if (!isSelected) {
	 		//set
	 		setBackground(Color.WHITE);
		    setForeground(Color.BLACK);
	 	}else{
	 		setBackground(Color.lightGray);
			setForeground(Color.WHITE);
	 	}
	 	setOpaque(true);
		return this;
	}
	
/*	public Component setOk(JList list,Object value, int index){
		setBackground(Color.WHITE);
	    setForeground(Color.BLACK);
	    setIcon(okIcon);
	    return this;
	}
	public Component setError(JList list,Object value, int index){
		setBackground(Color.RED);
	    setForeground(Color.WHITE);
		
		setText(value.toString()+"  "+index);
	    setIcon(errorIcon);
	    return this;
	}*/

}