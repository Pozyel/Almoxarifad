/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inatel.almoxarifad;

/**
 *
 * @author antun
 */
public class Funcionario {

    private String nome;
    private String nomeferramenta;
    private String cpf;
    private String registro;
    private String senha;
    private String data_retirado;
    private String data_enviado;
    private int IdFuncionario;

    public String getData_retirado() {
        return data_retirado;
    }

    public void setData_retirado(String data_retirado) {
        this.data_retirado = data_retirado;
    }

    public String getNomeferramenta() {
        return nomeferramenta;
    }

    public void setNomeferramenta(String nomeferramenta) {
        this.nomeferramenta = nomeferramenta;
    }

    public String getData_enviado() {
        return data_enviado;
    }

    public void setData_enviado(String data_enviado) {
        this.data_enviado = data_enviado;
    }

    public int getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(int IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getSenha(){
        return senha;
    }

    Object getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
