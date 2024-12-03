package com.example.ngtest.user.add.enums;

import java.util.Arrays;

public enum AuthenticationType {

    IN_MEMORY("In-Memory"),
    SYSTEM("System"),
    SAML("SAML"),
    OAUTH("OAUTH"),
    LDAP("LDAP");

    public final String value;

    AuthenticationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AuthenticationType getEnumByValue(String value) {
        return Arrays.stream(AuthenticationType.values())
                .filter(enumItem -> enumItem.value.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }

    public static AuthenticationType getEnumByNameOrValue(String searchText) {
        return Arrays.stream(AuthenticationType.values())
                .filter(
                        enumItem ->
                                enumItem.value.equalsIgnoreCase(searchText)
                                        || enumItem.name().equalsIgnoreCase(searchText))
                .findFirst()
                .orElse(null);
    }
}
