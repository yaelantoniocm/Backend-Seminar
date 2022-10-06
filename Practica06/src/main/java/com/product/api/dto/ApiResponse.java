package com.product.api.dto;

//Modelo que muestra un JSON con message y el mensaje que agreguemos

//ApiResponse es lo que devolveremos con una respuesta cuando se crea una region, se actualiza, se elimina, etc..
public class ApiResponse {

    private String message;

    public ApiResponse(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
