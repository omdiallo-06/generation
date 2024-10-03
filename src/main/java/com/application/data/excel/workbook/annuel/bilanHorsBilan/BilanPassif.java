package com.application.data.excel.workbook.annuel.bilanHorsBilan;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class BilanPassif extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(BilanPassif.class);
	
	
	public BilanPassif(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void CopieBilanPassif(){
		//F1A
		copie(9,4);
		//F2B
		copie(11,6);
		//F2C
		copie(12,7);
		//F2D
		copie(13,8);
		//F3E
		copie(17,10);
		//F3F
		copie(18,11);
		//F50
		copie(19,12);
		//F55
		copie(20,13);
		//F60
		copie(21,14);
		//G10
		copie(36,16);
		//G15
		copie(37,17);
		//G2A
		copie(38,18);
		//G30
		copie(40,19);
		//G35
		copie(41,20);
		//G60
		copie(42,21);
		//G70
		copie(43,22);
		//G90
		copie(44,23);
		//H10
		copie(53,25);
		//H40
		copie(54,26);
		//H6B
		copie(56,28);
		//H6C
		copie(57,29);
		//H6G
		copie(58,30);
		//H6P
		copie(60,31);
		//K20
		copie(72,33);
		//L10
		copie(76,35);
		//L21
		copie(78,37);
		//L22
		copie(79,38);
		//L23
		copie(80,39);
		//L24
		copie(81,40);
		//L25
		copie(82,41);
		//L27
		copie(83,42);
		//L31
		copie(85,44);
		//L32
		copie(86,45);
		//L33
		copie(87,46);
		//L36
		copie(89,48);
		//L37
		copie(90,49);
		//L41
		copie(91,50);
		//L43
		copie(92,51);
		//L45
		copie(93,52);
		//L50
		copie(94,53);
		//L56
		copie(96,55);
		//L57
		copie(97,56);
		//L58
		copie(98,57);
		//L59
		copie(99,58);
		//L61
		copie(101,60);
		//L62
		copie(102,61);
		//L65
		copie(103,62);
		//L70
		copie(104,63);
		//L75
		copie(115,64);
		//L81
		copie(117,66);
		//L82
		copie(118,67);
	}
	
	public void copie(Integer source, Integer destination){
		//Amortissement
		copie("I"+source,"C"+destination);
	}
	public void operation(){
		CopieBilanPassif();
	}
}
