package com.application.data.excel.workbook.annuel.bilanHorsBilan;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class BilanActif extends MetaSheet {
	//protected static final Logger log = LoggerFactory.getLogger(BilanActif.class);
	
	
	public BilanActif(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void CopieBilanActif(){
		//A11 Armortissement Provision
		copieAmortissementProvision(10,5);
	//	log.info("copie a11");
		//A12
		copieAmortissementProvision(17,6);
		//A2H
		copieAmortissementProvision(19,8);
		//A2I
		copieAmortissementProvision(20,9);
		//A2J
		copieAmortissementProvision(21,10);
		//A3B
		copieAmortissementProvision(25,12);
		//A3C
		copieAmortissementProvision(26,13);
		//A60
		copieAmortissementProvision(27,14);
		//prets immobilises
		copieAmortissementProvision(29,16);
		//A71
		copieAmortissementProvision(30,17);
		//A72
		copieAmortissementProvision(31,18);
		//A73
		copieAmortissementProvision(32,19);
		//B2D
		copieAmortissementProvision(36,21);
		//B2N
		copieAmortissementProvision(37,22);
		//B30
		copieAmortissementProvision(40,23);
		//B40
		copieAmortissementProvision(41,24);
		//B65
		copieAmortissementProvision(44,25);
		//credit immobilise
		copieAmortissementProvision(46,27);
		//B71
		copieAmortissementProvision(47,28);
		//B72
		copieAmortissementProvision(48,29);
		//B73
		copieAmortissementProvision(49,30);
		//C10
		copieAmortissementProvision(54,32);
		//C31
		copieAmortissementProvision(56,34);
		//C32
		copieAmortissementProvision(57,35);
		//C33
		copieAmortissementProvision(58,36);
		//C34
		copieAmortissementProvision(59,37);
		//C40
		copieAmortissementProvision(60,38);
		//C55
		copieAmortissementProvision(61,39);
		//C56
		copieAmortissementProvision(62,40);
		//C59
		copieAmortissementProvision(63,41);
		//C6B
		copieAmortissementProvision(65,43);
		//C6C
		copieAmortissementProvision(66,44);
		//C6G
		copieAmortissementProvision(67,45);
		//C6Q
		copieAmortissementProvision(68,46);
		//C6R
		copieAmortissementProvision(69,47);
		//D10
		copieAmortissementProvision(75,50);
		//D1E
		copieAmortissementProvision(73,51);
		//D1L
		copieAmortissementProvision(74,52);
		//D1S
		copieAmortissementProvision(76,53);
		//D24
		copieAmortissementProvision(78,55);
		//D25
		copieAmortissementProvision(79,56);
		//D31
		copieAmortissementProvision(81,58);
		//D36
		copieAmortissementProvision(82,59);
		//D41
		copieAmortissementProvision(84,61);
		//D45
		copieAmortissementProvision(85,62);
		//D46
		copieAmortissementProvision(87,64);
		//D47
		copieAmortissementProvision(89,65);
		//D51
		copieAmortissementProvision(93,67);
		//D52
		copieAmortissementProvision(94,68);
		//D53
		copieAmortissementProvision(95,69);
		//D60
		copieAmortissementProvision(106,70);
		//credit immobilisés
		//copieAmortissementProvision(,);
		//D71
		copieAmortissementProvision(109,72);
		//D72
		copieAmortissementProvision(110,73);
		//D73
		copieAmortissementProvision(111,74);
		//E02
		copieAmortissementProvision(115,76);
		//E03
		copieAmortissementProvision(116,77);
		//E05
		copieAmortissementProvision(119,78);
	}

	public void copieAmortissementProvision(Integer source, Integer destination){
		//Amortissement
		copie("C"+source,"C"+destination);
		//provision
		copie("D"+source,"D"+destination);
	}
	
	public void copieAmortissementProvisionPeriodique(Integer source, Integer destination){
		//Amortissement
		copie("C"+source,"C"+(destination-1));
		//provision
		copie("D"+source,"D"+(destination-1));
	}
	
	public void operation(){
		CopieBilanActif();
	}
}
