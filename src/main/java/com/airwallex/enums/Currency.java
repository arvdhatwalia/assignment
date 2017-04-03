package com.airwallex.enums;
import java.util.HashMap;
import java.util.Map;

public enum Currency {

	AUD("AUD"), CAD("CAD"), CNY("CNY"), CZK("CZK"), DKK("DKK"), EUR("EUR"), GBP("GBP"), JPY("JPY"), NOK("NOK"), NZD(
			"NZD"), USD("USD");

	private String value;

	private static Map<String, Currency> currencyMap = new HashMap<String, Currency>();

	static {
		for (Currency curEnum : values()) {
			currencyMap.put(curEnum.value, curEnum);
		}
	}

	private Currency(final String cur) {
		value = cur;
	}

	public static Currency getCurreny(String value) {
		return currencyMap.get(value);
	}

}
