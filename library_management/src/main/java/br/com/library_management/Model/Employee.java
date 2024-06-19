package br.com.library_management.Model;

public class Employee {

    // Atributo que armazena o ID de registro do funcionário.
    private int id_registration;
    
    private String nomeEmployee;

    private String email;

    private String phone;

    /**
     * Construtor da classe Employee.
     * @param id_registration ID de registro do funcionário.
     * @param nomeEmployee Nome do funcionário.
     * @param email E-mail do funcionário.
     * @param phone Phone do funcionário
     */
    Employee (int id_registration, String nomeEmployee, String email, String phone) {
        this.id_registration =  id_registration;
        this.nomeEmployee = nomeEmployee;
        this.email = email;
        this.phone = phone;
    }


    //Métodos Get para obter as Informações
    public int getId_registration() {
        return id_registration;
    }

    public String getNomeEmployee() {
        return nomeEmployee;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}