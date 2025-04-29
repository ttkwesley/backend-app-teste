package com.recrutamento.app.domain;

public enum UserRole {
    
    USER, 
    ADM;

    public String getRole(){
        return this.name();
    }
}
