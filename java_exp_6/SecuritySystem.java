package Experiment6;
final class SecuritySystem {
    public boolean authenticateUser(String username, String password) {
        return "admin".equals(username) && "password123".equals(password);
    }
    public static void main(String[] args) {
        SecuritySystem security = new SecuritySystem();
        boolean isAuthenticated = security.authenticateUser("admin", "password123");
        System.out.println("Authentication Status: " + isAuthenticated);
    }
}