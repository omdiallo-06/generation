package com.application.data.excel.workbook.annuel.compteResultat;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class CompteResultatCharge extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(CompteResultatCharge.class);
	
	
	public CompteResultatCharge(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void CopieCRCharge(){
		//R1B
		copie(9,5);
		//R1C
		copie(10,6);
		//R1D
		copie(11,7);
		//R1E
		copie(12,8);
		//R1F
		copie(13,9);
		//R1H
		copie(14,10);
		//R1I
		copie(15,11);
		//R1K
		copie(16,12);
		//R1N
		copie(18,14);
		//R1P
		copie(19,15);
		//R1Q
		copie(20,16);
		//R2F
		copie(22,18);
		//R2G
		copie(23,19);
		//R2T
		copie(26,21);
		//R2Z
		copie(27,22);
		//R3D
		copie(32,25);
		//R3F
		copie(33,26);
		//R3G
		copie(34,27);
		//R3H
		copie(35,28);
		//R3J
		copie(36,29);
		//R3N
		copie(37,30);
		//R3Q
		copie(38,31);
		//R3T
		copie(39,32);
		//R4C
		copie(45,36);
		//R4K
		copie(46,37);
		//R4N
		copie(47,38);
		//R5C
		copie(51,40);
		//R5D
		copie(52,41);
		//R5H
		copie(57,44);
		//R5J
		copie(58,45);
		//R5K
		copie(59,46);
		//R5L
		copie(60,47);
		//R5N
		copie(62,49);
		//R5P
		copie(63,50);
		//R5Q
		copie(64,51);
		//R5R
		copie(65,52);
		//R5T
		copie(67,54);
		//R5U
		copie(68,55);
		//R5V
		copie(69,56);
		//R5X
		copie(70,57);
		//R5Y
		copie(71,58);
		//R6B
		copie(74,60);
		//R6C
		copie(75,61);
		//R6K
		copie(78,63);
		//R6L
		copie(79,64);
		//R6M
		copie(80,65);
		//R6P
		copie(81,66);
		//R6S
		copie(83,67);
		//R6T
		copie(84,68);
		//R6W
		copie(89,70);
		//R6X
		copie(90,71);
		//R7B
		copie(93,73);
		//R7C
		copie(94,74);
		//R7D
		copie(95,75);
		//Autres produits financiers net
		copie(98,76);
		//Autres charges financieres net
		copie(99,77);
		//Marge d'interet beneficiare
		copie(102,78);
		//produits financiers net
		copie(107,79);
		//R8G
		copie(110,81);
		//R8J
		copie(111,82);
		//R8L
		copie(112,83);
		//S03
		copie(118,86);
		//S04
		copie(119,87);
		//S05
		copie(120,88);
		//S1B
		copie(123,90);
		//S1D
		copie(125,92);
		//S1G
		copie(126,93);
		//S1H
		copie(127,94);
		//S1J
		copie(128,95);
		//S1K
		copie(129,96);
		//S2C
		copie(132,99);
		//S2D
		copie(133,100);
		//S2F
		copie(134,101);
		//S2H
		copie(135,102);
		//S2J
		copie(136,103);
		//S2K
		copie(138,104);
		//S2M
		copie(139,105);
		//S2L
		copie(140,106);
		//S3B
		copie(143,108);
		//S3C
		copie(144,109);
		//S3E
		copie(145,110);
		//S3G
		copie(146,111);
		//S3J
		copie(148,112);
		//S3L
		copie(150,113);
		//S3M
		copie(151,114);
		//S3N
		copie(152,115);
		//S3P
		copie(153,116);
		//S4B
		copie(159,118);
		//S4D
		copie(160,119);
		//S4I
		copie(161,120);
		//S4L
		copie(163,122);
		//S4M
		copie(164,123);
		//S4Q
		copie(166,125);
		//S4R
		copie(167,126);
		//S4S
		copie(168,127);
		//T50
		copie(170,128);
		//T53
		copie(172,130);
		//T54
		copie(173,131);
		//T55
		copie(174,132);
		//T56
		copie(175,133);
		//T57
		copie(176,134);
		//T58
		copie(177,135);
		//T6D
		copie(181,138);
		//T6E
		copie(182,139);
		//T6F
		copie(183,140);
		//T6G
		copie(184,141);
		//T6H
		copie(185,142);
		//T6J
		copie(186,143);
		//T6K
		copie(187,144);
		//T6L
		copie(188,145);
		//T80
		copie(190,146);
		//T81
		copie(192,147);
		//T82
		copie(194,148);
		//L80
		copie(196,149);
	}
	
	public void copie(Integer source, Integer destination){
		//Amortissement
		copie("C"+source,"C"+destination);
	}
	
	public void operation(){
		CopieCRCharge();
	}
}
