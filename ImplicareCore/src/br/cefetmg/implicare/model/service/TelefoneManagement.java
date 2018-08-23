/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.util.List;

/**
 *
 * @author Andre Matheus
 * @author Gabriel
 * 
 */
public interface TelefoneManagement {
    public void insert(Telefone Telefone) throws BusinessException, PersistenceException;
    public boolean update(long CPF_CNPJ, String Num_Telefone, Telefone Telefone) throws BusinessException, PersistenceException;
    public boolean delete(long CPF_CNPJ, String Num_Telefone) throws PersistenceException;
    public List<Telefone> getTelefones(long CPF_CNPJ) throws PersistenceException;
    public Telefone getTelefoneCod(long CPF_CNPJ, String Num_Telefone) throws PersistenceException;
}
