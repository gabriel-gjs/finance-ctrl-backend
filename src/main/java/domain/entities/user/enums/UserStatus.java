package domain.entities.user.enums;

public enum UserStatus {
    ACTIVE("A"),
    INACTIVE("I");

    private String status;

    UserStatus(String status) {
        this.status = status;
    }

    String getUserStatus() {
        return this.status;
    }
}
