package com.example.demo.observer.model;

import org.springframework.context.ApplicationEvent;

public class StockPriceChangeEvent extends ApplicationEvent {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Stock stock;

    public StockPriceChangeEvent(Object source, Stock stock) {
        super(source);
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }
}
