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
public class Ferramenta {

    private String nome;
    private String nomefuncionario;
    private String numero_serie;
    private String data_enviado;
    private int quantidade;
    private String data_retirado;
    private int IdFerramenta;

    public int getIdFerramenta() {
        return IdFerramenta;
    }

    public void setIdFerramenta(int IdFerramenta) {
        this.IdFerramenta = IdFerramenta;
    }

    public String getNomefuncionario() {
        return nomefuncionario;
    }

    public void setNomefuncionario(String nomefuncionario) {
        this.nomefuncionario = nomefuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
  

    public String getData_enviado() {
        return data_enviado;
    }

    public void setData_enviado(String data_enviado) {
        this.data_enviado = data_enviado;
    }

    public String getData_retirado() {
        return data_retirado;
    }

    public void setData_retirado(String data_retirado) {
        this.data_retirado = data_retirado;
    }
    
 

}
