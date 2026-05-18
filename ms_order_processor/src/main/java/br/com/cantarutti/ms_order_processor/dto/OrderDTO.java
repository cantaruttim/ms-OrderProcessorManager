package br.com.cantarutti.ms_order_processor.dto;

import java.util.UUID;


public class OrderDTO {
    
    private UUID id;
    private String description;

    public OrderDTO() {}

    public OrderDTO(UUID id, String description) {
        this.id = id;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}