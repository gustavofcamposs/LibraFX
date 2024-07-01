package br.com.library_management.Model;


public class AuthenticatedUser {
    
    private static AuthenticatedUser instance;
    private Employee authenticatedEmployee;


    public static AuthenticatedUser getInstance() {
        if (instance == null) {
            instance = new AuthenticatedUser();
        }
        return instance;
    }

    public Employee getAuthenticatedEmployee() {
        return authenticatedEmployee;
    }

    public void setAuthenticatedEmployee(Employee employee) {
        this.authenticatedEmployee = employee;
    }
}