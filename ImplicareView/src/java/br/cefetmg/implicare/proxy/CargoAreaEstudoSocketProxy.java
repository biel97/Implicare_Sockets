/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CargoAreaEstudoManagement;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Gabriel
 */
public class CargoAreaEstudoSocketProxy implements CargoAreaEstudoManagement {

    @Override
    public Set<br.cefetmg.implicare.model.domain.CargoAreaEstudo> CargoAreaEstudo(List<FormacaoAcademica> FormAcad) throws BusinessException, PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
