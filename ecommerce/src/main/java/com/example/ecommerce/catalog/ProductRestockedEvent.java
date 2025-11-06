package com.example.ecommerce.catalog;

import org.springframework.context.ApplicationEvent;

public class ProductRestockedEvent extends ApplicationEvent {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String productId;
    public ProductRestockedEvent(Object source, String productId) {
        super(source);
        this.productId = productId;
    }
    public String getProductId(){ return productId; }
}
