package com.projet.springsecurity.user;

import java.util.Arrays;
import java.util.List;

public enum Role {
ClIENT(Arrays.asList(Permission.READ_ALL_PRODUCTS)),
RESPONSABLE(Arrays.asList(
Permission.READ_ALL_ETAPES,
Permission.CREATE_ETAPE,
Permission.READ_ONE_ETAPE,
Permission.DELETE_ONE_ETAPE,
Permission.UPDATE_ONE_ETAPE
)),
TECHNICIEN(Arrays.asList(Permission.READ_ALL_PRODUCTS)),
    CUSTOMER(Arrays.asList(Permission.READ_ALL_PRODUCTS)),

    ADMIN(Arrays.asList(Permission.READ_ALL_PRODUCTS, 
    Permission.SAVE_ONE_PRODUCT,
    Permission.CREATE_USER,
    Permission.UPDATE_ONE_USER,
    Permission.DELETE_ONE_USER,
    Permission.READ_ALL_Users
    ));

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
