package com.warehouse.warehouse.SSecurity;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {

    admin, client;

    @Override
    public String getAuthority() {
        return name();
    }
}
