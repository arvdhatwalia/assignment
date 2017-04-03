package com.airwallex.common;
import java.util.HashMap;
import java.util.Map;

import com.airwallex.exception.CurrencyException;

public class DefaultCurrencyValue {
	
	private static Map<String,String> currencyMapping = new HashMap<String,String>(121); 
	private static Map<String, Double> ccy= new HashMap<String,Double>();
	
	static{
		
		ccy.put("AUDUSD",0.8371);
		ccy.put("CADUSD",0.8711);
		ccy.put("USDCNY",6.1715);
		ccy.put("EURUSD",1.2315);
		ccy.put("GBPUSD",1.5683);
		ccy.put("NZDUSD",0.7750);
		ccy.put("USDJPY",119.95);
		ccy.put("EURCZK",27.6028);
		ccy.put("EURDKK",7.4405);
		ccy.put("EURNOK",8.6651);

		//## AUD Conversion
		currencyMapping.put("AUDAUD", "UNITY");
		currencyMapping.put("AUDCAD", "USD");
		currencyMapping.put("AUDCNY", "USD");
		currencyMapping.put("AUDCZK", "USD");
		currencyMapping.put("AUDDKK", "USD");
		currencyMapping.put("AUDEUR", "USD");
		currencyMapping.put("AUDGBP", "USD");
		currencyMapping.put("AUDJPY", "USD");
		currencyMapping.put("AUDNOK", "USD");
		currencyMapping.put("AUDNZD", "USD");
		currencyMapping.put("AUDUSD", "DIRECT");
		
		//## CAD Conversion
		currencyMapping.put("CADAUD", "USD");
		currencyMapping.put("CADCAD", "UNITY");
		currencyMapping.put("CADCNY", "USD");
		currencyMapping.put("CADCZK", "USD");
		currencyMapping.put("CADDKK", "USD");
		currencyMapping.put("CADEUR", "USD");
		currencyMapping.put("CADGBP", "USD");
		currencyMapping.put("CADJPY", "USD");
		currencyMapping.put("CADNOK", "USD");
		currencyMapping.put("CADNZD", "USD");
		currencyMapping.put("CADUSD", "DIRECT");
		
		//## CNY Conversion		
		currencyMapping.put("CNYAUD", "USD");
		currencyMapping.put("CNYCAD", "USD");
		currencyMapping.put("CNYCNY", "UNITY");
		currencyMapping.put("CNYCZK", "USD");
		currencyMapping.put("CNYDKK", "USD");
		currencyMapping.put("CNYEUR", "USD");
		currencyMapping.put("CNYGBP", "USD");
		currencyMapping.put("CNYJPY", "USD");
		currencyMapping.put("CNYNOK", "USD");
		currencyMapping.put("CNYNZD", "USD");
		currencyMapping.put("CNYUSD", "DIRECT");
		
		currencyMapping.put("CZKAUD", "USD");
		currencyMapping.put("CZKCAD", "USD");
		currencyMapping.put("CZKCNY", "USD");
		currencyMapping.put("CZKCZK", "UNITY");
		currencyMapping.put("CZKDKK", "EUR");
		currencyMapping.put("CZKEUR", "INVERTED");
		currencyMapping.put("CZKGBP", "USD");
		currencyMapping.put("CZKJPY", "USD");
		currencyMapping.put("CZKNOK", "EUR");
		currencyMapping.put("CZKNZD", "USD");
		currencyMapping.put("CZKUSD", "EUR");
		
		currencyMapping.put("DKKAUD", "USD");
		currencyMapping.put("DKKCAD", "USD");
		currencyMapping.put("DKKCNY", "USD");
		currencyMapping.put("DKKCZK", "EUR");
		currencyMapping.put("DKKDKK", "UNITY");
		currencyMapping.put("DKKEUR", "INVERTED");
		currencyMapping.put("DKKGBP", "USD");
		currencyMapping.put("DKKJPY", "USD");
		currencyMapping.put("DKKNOK", "EUR");
		currencyMapping.put("DKKNZD", "USD");
		currencyMapping.put("DKKUSD", "EUR");

		currencyMapping.put("EURAUD", "USD");
		currencyMapping.put("EURCAD", "USD");
		currencyMapping.put("EURCNY", "USD");
		currencyMapping.put("EURCZK", "DIRECT");
		currencyMapping.put("EURDKK", "DIRECT");
		currencyMapping.put("EUREUR", "UNITY");
		currencyMapping.put("EURGBP", "USD");
		currencyMapping.put("EURJPY", "USD");
		currencyMapping.put("EURNOK", "DIRECT");
		currencyMapping.put("EURNZD", "USD");
		currencyMapping.put("EURUSD", "DIRECT");

		currencyMapping.put("GBPAUD", "USD");
		currencyMapping.put("GBPCAD", "USD");
		currencyMapping.put("GBPCNY", "USD");
		currencyMapping.put("GBPCZK", "USD");
		currencyMapping.put("GBPDKK", "USD");
		currencyMapping.put("GBPEUR", "USD");
		currencyMapping.put("GBPGBP", "UNITY");
		currencyMapping.put("GBPJPY", "USD");
		currencyMapping.put("GBPNOK", "USD");
		currencyMapping.put("GBPNZD", "USD");
		currencyMapping.put("GBPUSD", "DIRECT");

		currencyMapping.put("JPYAUD", "USD");
		currencyMapping.put("JPYCAD", "USD");
		currencyMapping.put("JPYCNY", "USD");
		currencyMapping.put("JPYCZK", "USD");
		currencyMapping.put("JPYDKK", "USD");
		currencyMapping.put("JPYEUR", "USD");
		currencyMapping.put("JPYGBP", "USD");
		currencyMapping.put("JPYJPY", "UNITY");
		currencyMapping.put("JPYNOK", "USD");
		currencyMapping.put("JPYNZD", "USD");
		currencyMapping.put("JPYUSD", "INVERTE");

		currencyMapping.put("NOKAUD", "USD");
		currencyMapping.put("NOKCAD", "USD");
		currencyMapping.put("NOKCNY", "USD");
		currencyMapping.put("NOKCZK", "EUR");
		currencyMapping.put("NOKDKK", "EUR");
		currencyMapping.put("NOKEUR", "INVERTED");
		currencyMapping.put("NOKGBP", "USD");
		currencyMapping.put("NOKJPY", "USD");
		currencyMapping.put("NOKNOK", "UNITY");
		currencyMapping.put("NOKNZD", "USD");
		currencyMapping.put("NOKUSD", "EUR");

		currencyMapping.put("NZDAUD", "USD");
		currencyMapping.put("NZDCAD", "USD");
		currencyMapping.put("NZDCNY", "USD");
		currencyMapping.put("NZDCZK", "USD");
		currencyMapping.put("NZDDKK", "USD");
		currencyMapping.put("NZDEUR", "USD");
		currencyMapping.put("NZDGBP", "USD");
		currencyMapping.put("NZDJPY", "USD");
		currencyMapping.put("NZDNOK", "USD");
		currencyMapping.put("NZDNZD", "UNITY");
		currencyMapping.put("NZDUSD", "DIRECT");

		currencyMapping.put("USDAUD", "INVERTED");
		currencyMapping.put("USDCAD", "INVERTED");
		currencyMapping.put("USDCNY", "INVERTED");
		currencyMapping.put("USDCZK", "EUR");
		currencyMapping.put("USDDKK", "EUR");
		currencyMapping.put("USDEUR", "INVERTED");
		currencyMapping.put("USDGBP", "INVERTED");
		currencyMapping.put("USDJPY", "DIRECT");
		currencyMapping.put("USDNOK", "EUR");
		currencyMapping.put("USDNZD", "INVERTED");
		currencyMapping.put("USDUSD", "UNITY");

	}
	
	public static String getCrossCurrencyKey(String key) throws CurrencyException{
		String val=currencyMapping.get(key);
		if(val==null)
			throw new CurrencyException("Unable to find Cross currency Key !!");
		return val;
	}
	
	public static Double getCurrencyConversionValue(String key) {
		return ccy.get(key);
	}

}