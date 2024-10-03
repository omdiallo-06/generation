package com.application.data.excel.workbook.annuel.compteResultat;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class CompteResultatProduit extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(CompteResultatProduit.class);
	
	
	public CompteResultatProduit(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void CopieCRProduit(){
		//V1B
		copie(9,5);
		//V1C
		copie(10,6);
		//V1D
		copie(11,7);
		//V1E
		copie(12,8);
		//V1F
		copie(13,9);
		//V1H
		copie(14,10);
		//V1I
		copie(15,11);
		//V1K
		copie(16,12);
		//V1Q
		copie(18,14);
		//V1R
		copie(19,15);
		//V1S
		copie(20,16);
		//V2C
		copie(22,18);
		//V2G
		copie(23,19);
		//V2S
		copie(26,21);
		//V2T
		copie(27,22);
		//V3G
		copie(32,25);
		//V3M
		copie(33,26);
		//V3N
		copie(34,27);
		//V3T
		copie(38,29);
		//V3X
		copie(39,30);
		//V4C
		copie(45,34);
		//V4D
		copie(46,35);
		//V4E
		copie(47,36);
		//V4F
		copie(48,37);
		//V5C
		copie(50,39);
		//V5D
		copie(51,40);
		//V5F
		copie(52,41);
		//V5J
		copie(57,44);
		//V5K
		copie(58,45);
		//V5L
		copie(59,46);
		//V5M
		copie(60,47);
		//V5P
		copie(62,49);
		//V5Q
		copie(63,50);
		//V5R
		copie(64,51);
		//V5S
		copie(66,52);
		//V5V
		copie(68,54);
		//V5W
		copie(69,55);
		//V5X
		copie(70,56);
		//V5Y
		copie(71,57);
		//V6B
		copie(74,59);
		//V6C
		copie(75,60);
		//V6K
		copie(78,62);
		//V6L
		copie(79,63);
		//V6N
		copie(80,64);
		//V6P
		copie(81,65);
		//V6Q
		copie(82,66);
		//V6R
		copie(83,67);
		//V6S
		copie(84,68);
		//V6V
		copie(88,70);
		//V6W
		copie(89,71);
		//V7B
		copie(93,73);
		//V7C
		copie(94,74);
		//V7D
		copie(95,75);
		//Autres charges financieres nets	
		copie(98,76);
		//Autres produits financiers nets		
		copie(99,77);
		//Marge d'interet deficitaire		
		copie(102,78);
		//Charge financiere nette		
		copie(107,79);
		//V8B
		copie(110,81);
		//V8C
		copie(111,82);
		//V8Dcopie(,83);
		//W4B
		copie(119,86);
		//W4D
		copie(120,87);
		//W4H
		copie(124,89);
		//W4J
		copie(125,90);
		//W4K
		copie(126,91);
		//W4M
		copie(128,93);
		//W4N
		copie(129,94);
		//W4P
		copie(130,95);
		//W4Q
		copie(133,96);
		//W51
		copie(136,98);
		//W52
		copie(137,99);
		//W53
		copie(139,100);
		//X50
		copie(170,101);
		//X54
		copie(173,103);
		//X56
		copie(175,104);
		//X6D
		copie(181,107);
		//X6E
		copie(182,108);
		//X6F
		copie(183,109);
		//X6G
		copie(184,110);
		//X6H
		copie(185,111);
		//X6I
		copie(186,112);
		//X6J
		copie(187,113);
		//X80
		copie(190,114);
		//X81
		copie(192,115);
		//L80
		copie(196,116);
		
	}
	
	public void copie(Integer source, Integer destination){
		//Amortissement
		copie("G"+source,"C"+destination);
	}
	
	public void operation(){
		CopieCRProduit();
	}
}
