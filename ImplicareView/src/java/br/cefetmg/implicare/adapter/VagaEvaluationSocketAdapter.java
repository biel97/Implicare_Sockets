/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.adapter;

import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.VagaEvaluation;
import br.cefetmg.implicare.model.serviceImpl.VagaEvaluationImpl;
import br.cefetmg.inf.implicare.util.AbstractInOut;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Morato
 */
public class VagaEvaluationSocketAdapter implements Runnable{
    
    private final Socket Socket;
    private final VagaEvaluation vagaEvaluationMan;
    
    public VagaEvaluationSocketAdapter(Socket Socket) {
        this.Socket = Socket;
        this.vagaEvaluationMan = new VagaEvaluationImpl();
    }
    
    private Socket getSocket(){
        return Socket;
    }

    @Override
    public void run() {
        ObjectOutputStream writer;
        ObjectInputStream reader;
        
        try {

            writer = AbstractInOut.getObjectWriter(this.getSocket());
            reader = AbstractInOut.getObjectReader(this.getSocket());            
            
            String command;
            
            command = reader.readUTF();
        
            switch(command){
                case "aceitaVaga(candidatoVaga)":
                    CandidatoVaga candidatoVaga = (CandidatoVaga) reader.readObject();
                    vagaEvaluationMan.aceitaVaga(candidatoVaga);
                    break;
                
                case "recusaVaga(candidatoVaga)":
                    CandidatoVaga candidatoVaga2 = (CandidatoVaga) reader.readObject();
                    vagaEvaluationMan.recusaVaga(candidatoVaga2);
                    break;    
            }
            writer.flush();
        }catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(VagaEvaluationSocketAdapter.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        } catch (BusinessException ex) {
            Logger.getLogger(VagaEvaluationSocketAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenceException ex) {
            Logger.getLogger(VagaEvaluationSocketAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
