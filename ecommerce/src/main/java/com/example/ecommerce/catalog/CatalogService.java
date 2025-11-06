package com.example.ecommerce.catalog;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collection;

@Service
public class CatalogService {
    private final ApplicationEventPublisher publisher;
    private final Map<String, SimpleProduct> repo = new ConcurrentHashMap<>();

    public CatalogService(ApplicationEventPublisher publisher){
        this.publisher = publisher;
        // seed sample
        SimpleProduct p = new ProductBuilder().id("p1").name("Mouse").price(120).stock(0).buildSimple();
        repo.put(p.getId(), p);
    }

    public Collection<SimpleProduct> list() { return repo.values(); }

    public SimpleProduct get(String id) { return repo.get(id); }

    public SimpleProduct create(SimpleProduct p){
        repo.put(p.getId(), p);
        return p;
    }

    public void restock(String id, int qty){
        SimpleProduct p = repo.get(id);
        if (p==null) return;
        int old = p.getStock();
        p.setStock(p.getStock() + qty);
        if(old==0 && p.getStock()>0){
            publisher.publishEvent(new ProductRestockedEvent(this, id));
        }
    }
}
