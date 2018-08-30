/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.service;
import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;

/**
 *
 * @author Morato
 */
public interface VagaEvaluation {
    public void aceitaVaga(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException;
    public void recusaVaga(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException;
}
