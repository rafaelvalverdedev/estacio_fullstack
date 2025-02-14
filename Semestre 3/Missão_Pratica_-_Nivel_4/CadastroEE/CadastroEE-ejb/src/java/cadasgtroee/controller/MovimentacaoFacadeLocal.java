/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadasgtroee.controller;

import cadasgtroee.model.Movimentacao;
import jakarta.ejb.Local;
import java.util.List;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

/**
 *
 * @author r3
 */
@Local
public interface MovimentacaoFacadeLocal {

    void create(Movimentacao movimentacao);

    void edit(Movimentacao movimentacao);

    void remove(Movimentacao movimentacao);

    Movimentacao find(Object id);

    List<Movimentacao> findAll();

    List<Movimentacao> findRange(int[] range);

    int count();
    
}
