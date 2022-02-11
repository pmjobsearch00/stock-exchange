package com.ice.exchange.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ice.exchange.model.Trade;

public class TradeParser {

	public static Trade parse(String line) throws Exception {
		
		if ((null == line) || (!line.trim().contains(";"))) {
			throw new Exception("Invalid element!");
		}
		
		String isin = null;
		Integer type = null;
		BigDecimal price = null;
		
		int isinCount = 0;
		int typeCount = 0;
		int priceCount = 0;
		
		List<String> fields = Stream.of(line.split(";"))
	      .map (elem -> new String(elem))
	      .collect(Collectors.toList());
	      
	    for (String elem: fields) {
	    	
	    	if ((null != elem) && (elem.length() > 1)) {
		    	if (elem.substring(0, 1).equalsIgnoreCase("i")) {
		    		isin = elem.substring(1, elem.length());
		    		isinCount++;
		    	} else if (elem.substring(0, 1).equalsIgnoreCase("t")) {
		    		
		    		if (!elem.substring(1, elem.length()).matches("\\d+")) {
		    			throw new Exception("Invalid element!");
		    		}
		    		
		    		type = Integer.parseInt(elem.substring(1, elem.length()));
		    		typeCount++;
		    	} else if (elem.substring(0, 1).equalsIgnoreCase("p")) {
		    		price = new BigDecimal(elem.substring(1, elem.length()));
		    		priceCount++;
		    	} 
	    	}	    	

	    }
	    
	    if ((null == isin) || (null == type) || (null == price)) {
	    	throw new Exception("Expected exception");
	    }
	    
	    if ((isinCount > 1) || (typeCount > 1) || (priceCount > 1)) {
	    	throw new Exception("Expected exception");
	    }
	    
		Trade trade = new Trade();
		
		trade.setIsin(isin);
		trade.setType(type);
		trade.setPrice(price);
		
		return trade;
	}
}