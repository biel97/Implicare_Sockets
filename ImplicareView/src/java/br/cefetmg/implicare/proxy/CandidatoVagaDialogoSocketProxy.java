/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.CandidatoVagaDialogo;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CandidatoVagaDialogoManagement;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class CandidatoVagaDialogoSocketProxy implements CandidatoVagaDialogoManagement {

    @Override
    public void insert(CandidatoVagaDialogo CandidatoVagaDialogo) throws BusinessException, PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CandidatoVagaDialogo> getCandidatoVagaDialogo(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CandidatoVagaDialogo getCandidatoVagaDialogoCod(long CPF, int Cod_Cargo, long CNPJ, Date Dat_Publicacao, Timestamp Dat_Dialogo) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
