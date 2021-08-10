package com.example.appniceface;


public class ClienteDTO {
    //Atributos
    private int id;
    private String cpf;
    private String nasc;
    private String phone;
    private String usuarioCadastro;
    private String senhaCadastro;
    private String confSenhaCadastro;

    //Construtores


    public ClienteDTO() {

    }

    public ClienteDTO(String cpf, String nasc, String phone, String usuarioCadastro, String senhaCadastro, String confSenhaCadastro) {
        this.cpf = cpf;
        this.nasc = nasc;
        this.phone = phone;
        this.usuarioCadastro = usuarioCadastro;
        this.senhaCadastro = senhaCadastro;
        this.confSenhaCadastro = confSenhaCadastro;
    }

    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public String getSenhaCadastro() {
        return senhaCadastro;
    }

    public void setSenhaCadastro(String senhaCadastro) {
        this.senhaCadastro = senhaCadastro;
    }

    public String getConfSenhaCadastro() {
        return confSenhaCadastro;
    }

    public void setConfSenhaCadastro(String confSenhaCadastro) {
        this.confSenhaCadastro = confSenhaCadastro;
    }


    //ToString

    @Override
    public String toString() {
        return
                "Usuario:                            " + usuarioCadastro + "\n\n" +
                "CPF:                                  " + cpf + "\n\n" +
                "Data de Nascimento:     " + nasc + "\n\n" +
                "Telefone:                           " + phone + "\n\n" ;
    }


}
