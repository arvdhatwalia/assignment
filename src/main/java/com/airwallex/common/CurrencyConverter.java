package com.airwallex.common;

import org.apache.commons.lang3.StringUtils;

import com.airwallex.enums.Currency;
import com.airwallex.exception.CurrencyException;

public class CurrencyConverter {

	private Currency source;
	private Currency target;
	private Double quantity;

	public Double process() throws CurrencyException {

		String curMapping = source.toString() + target.toString();
		String crossMatrixVal = DefaultCurrencyValue.getCrossCurrencyKey(curMapping);
		Double convertedAmount = null;
		String intermediate = null;

		if ("UNITY".equals(crossMatrixVal)) {
			convertedAmount = quantity;
		} else if ("DIRECT".equals(crossMatrixVal) || "INVERTED".equals(crossMatrixVal)) {
			convertedAmount = getConversionValue(source.toString(), target.toString(), quantity);
		} else {
			intermediate = crossMatrixVal;
			convertedAmount = getConversionValue(source.toString(), intermediate, quantity);
			convertedAmount = getConversionValue(intermediate, target.toString(), convertedAmount);
		}
		return convertedAmount;
	}

	private Double getConversionValue(String src, String trgt, double quantity) throws CurrencyException {
		String curMapping = src + trgt;
		Double converisonValue = DefaultCurrencyValue.getCurrencyConversionValue(curMapping);
		if (converisonValue == null) {
			curMapping = trgt + src;
			converisonValue = DefaultCurrencyValue.getCurrencyConversionValue(curMapping);
			if (converisonValue == null)
				throw new CurrencyException("Unable to find Inverted Currency !!");
			converisonValue = 1 / converisonValue;
		}
		return converisonValue * quantity;
	}

	public void validateSetValues(String src, String trgt, String qnty) throws CurrencyException {

		checkStringValue(src, "source");
		source = Currency.getCurreny(src.toUpperCase());
		checkStringValue(src, "source");

		checkStringValue(trgt, "target");
		target = Currency.getCurreny(trgt.toUpperCase());
		checkStringValue(trgt, "target");

		try {
			quantity = Double.parseDouble(qnty);
		} catch (NumberFormatException n) {
			throw new CurrencyException("Invalid Quantity value !!");
		}

	}

	private void checkStringValue(String value, String name) throws CurrencyException {
		if (StringUtils.isBlank(value)) {
			throw new CurrencyException("Invalid " + name + " currency!!");
		}
	}

	public Currency getSource() {
		return source;
	}

	public Currency getTarget() {
		return target;
	}

	public Double getQuantity() {
		return quantity;
	}

}
