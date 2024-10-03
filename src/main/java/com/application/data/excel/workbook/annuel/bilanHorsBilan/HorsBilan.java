package com.application.data.excel.workbook.annuel.bilanHorsBilan;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class HorsBilan extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(HorsBilan.class);
	
	
	public HorsBilan(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void CopieHorsBilan(){
		//N1A
		copie(127,4);
		//N1H
		copie(128,5);
		//N1J
		copie(129,6);
		//N1K
		copie(130,7);
		//N2A
		copie(131,9);
		//N2H
		copie(132,10);
		//N2J
		copie(133,11);
		//N2M
		copie(134,12);
		//N3B
		copie(138,15);
		//N3C
		copie(139,16);
		//N3D
		copie(140,17);
		//NRF
		copie(142,19);
		//NRG
		copie(143,20);
		//N3H
		copie(144,21);
		//P1A
		copie(149,24);
		//P1B
		copie(150,25);
		//P1C
		copie(151,26);
		//P1D
		copie(152,27);
		//P1E
		copie(155,29);
		//P1F
		copie(156,30);
		//P1G
		copie(159,32);
		//P1H
		copie(160,33);
		//P1J
		copie(161,34);
		//P1K
		copie(162,35);
		//P1L
		copie(163,36);
		//P1M
		copie(164,37);
		//P1R
		copie(165,38);
		//P1S
		copie(166,39);
		//P1V
		copie(167,40);
		//Q1A
		copie(171,42);
		//Q1B
		copie(172,43);
		//Q1C
		copie(174,45);
		//Q1F
		copie(175,46);
		//Q1J
		copie(177,47);
		//Q1K
		copie(178,48);
		//Q1L
		copie(179,49);
		//Q1M
		copie(181,50);
		//N90
		copie(183,51);
		
	}
	public void copie(Integer source, Integer destination){
		//Amortissement
		copie("C"+source,"C"+destination);
	}
	
	public void operation(){
		CopieHorsBilan();
	}
}
