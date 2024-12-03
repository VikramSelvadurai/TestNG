package com.example.ngtest.user.add.enums;

public enum UserStatus {
    REGISTERED("Registered"),
    ACTIVE("Active"),
    REVOKED("Revoked"),
    LOCKED("Locked");

    private final String value;

    UserStatus(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static UserStatus getEnumByName(String enumName) {
        UserStatus[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            UserStatus e = var1[var3];
            if (e.name().equals(enumName)) {
                return e;
            }
        }

        return null;
    }
}
