package com.solncev.enums;

public enum RoleName {
    ADMIN("Админ"),
    USER("Пользователь");

    private final String nameOnRus;

    RoleName(String nameOnRus) {
        this.nameOnRus = nameOnRus;
    }

    public String getNameOnRus() {
        return nameOnRus;
    }
}
