package com.application.data.excel.utils;


import java.io.File;
import java.util.ArrayList;

import com.jgoodies.common.collect.ArrayListModel;

public class LectureDesFichiersDunDossier {
	private ArrayList<String> listeFicXlsx=new ArrayList<String>();
	private ArrayList<String> listeFicXls = new ArrayList<String>();
	private ArrayListModel<String> listeFic =new ArrayListModel<String>();
	private String directory;
	private String directoryEFGen;
	
	public LectureDesFichiersDunDossier(){
	}
	public LectureDesFichiersDunDossier(String directory){
		this.directory=directory;
		listeFile();
		creerRepertoireEtatFinancierGenere();
	}
	
	public void creerRepertoireEtatFinancierGenere(){
		//File fb=new File(directory+"\\EtatFinancierGenere");
		File fb=new File(directory+"//EtatFinancierGenere");
		setDirectoryEFGen(fb.getAbsolutePath());
		fb.mkdirs();
	}
	public void listeFile(){
		try{
		    File dir = new File(directory);
		    String[] children = dir.list();
	        if (children == null) {
	        	System.out.println("Directory does not exist or is not a Directory");
	        } else {
	            for (int i=0; i<children.length;i++){                // Get filename of file or directory
		            String filename = children[i];
		            if(filename.endsWith("xls")){
		            	getListeFicXls().add(filename);
		            	getListeFic().add(filename);
		            }
		            else if(filename.endsWith("xlsx")){
		            	getListeFicXlsx().add(filename);
		            	getListeFic().add(filename);
		            }
	            }
	        }
	      
		}catch (Exception ioe){
	    	    ioe.printStackTrace();
	    }
	}
	
	public ArrayListModel<String> convert(ArrayList<String> enter){
		return ( ArrayListModel<String>) enter;
	}
	
	public int nbFile(){
		return getListeFicXls().size()+getListeFicXlsx().size();
	}
	
	public ArrayList<String> getListeFicXlsx() {
		return listeFicXlsx;
	}
	
	public void setListeFicXlsx(ArrayList<String> listeFicXlsx) {
		this.listeFicXlsx = listeFicXlsx;
	}
	
	public ArrayList<String> getListeFicXls() {
		return listeFicXls;
	}
	
	public void setListeFicXls(ArrayList<String> listeFicXls) {
		this.listeFicXls = listeFicXls;
	}
	
	public String getDirectory() {
		return directory;
	}
	
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public ArrayListModel<String> getListeFic() {
		return listeFic;
	}
	public void setListeFic(ArrayListModel<String> listeFic) {
		this.listeFic = listeFic;
	}
	public String getDirectoryEFGen() {
		return directoryEFGen;
	}
	public void setDirectoryEFGen(String directoryEFGen) {
		this.directoryEFGen = directoryEFGen;
	}
	
}
