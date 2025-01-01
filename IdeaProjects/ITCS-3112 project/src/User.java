public record User(String username, String password, boolean isAdmin) {

    // Password verification instead of getter
    public boolean verifyPassword(String passwordToCheck) {
        return this.password.equals(passwordToCheck);
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', isAdmin=" + isAdmin + "}";
    }
}


