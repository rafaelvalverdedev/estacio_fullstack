/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadasgtroee.controller;

import cadasgtroee.model.Produtos;
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
public interface ProdutosFacadeLocal {

    void create(Produtos produtos);

    void edit(Produtos produtos);

    void remove(Produtos produtos);

    Produtos find(Object id);

    List<Produtos> findAll();

    List<Produtos> findRange(int[] range);

    int count();
    
}
