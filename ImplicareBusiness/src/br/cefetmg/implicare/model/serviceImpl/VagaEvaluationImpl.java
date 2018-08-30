/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;
import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.VagaEvaluation;

/**
 *
 * @author Morato
 */
public class VagaEvaluationImpl implements VagaEvaluation {

    @Override
    public void aceitaVaga(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException {
        candidatoVaga.setStatus_Candidato("A"); //Muda o status da vaga para Aprovada (A)
    }

    @Override
    public void recusaVaga(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException {
        candidatoVaga.setStatus_Candidato("R"); //Muda o status da vaga para Reprovada (R)
    }
    
}
