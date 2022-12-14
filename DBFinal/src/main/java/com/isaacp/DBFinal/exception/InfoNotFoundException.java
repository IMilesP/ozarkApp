package com.isaacp.DBFinal.exception;

import jakarta.persistence.criteria.CriteriaBuilder;

public class InfoNotFoundException extends Exception {
    public InfoNotFoundException(String message) {
        super(message);
    }
}
