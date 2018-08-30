/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.proxy;

import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.VagaEvaluation;
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
public class VagaEvaluationSocketProxy implements VagaEvaluation{
    private String serverAddress;
    private int serverPort;
    
    public VagaEvaluationSocketProxy(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;        
    }
       
    public VagaEvaluationSocketProxy() {
        this("localhost", 2223);
    }

    @Override
    public void aceitaVaga(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException {
        Socket socket;
        ObjectOutputStream writer;
        ObjectInputStream reader;
        
        try {
            socket = new Socket(this.serverAddress, this.serverPort);            
            writer = AbstractInOut.getObjectWriter(socket);
            reader = AbstractInOut.getObjectReader(socket);                 
            
            writer.writeUTF("aceitaVaga(CandidatoVaga candidatoVaga)");
            writer.writeObject(candidatoVaga);           
            writer.flush();
            
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(VagaEvaluationSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void recusaVaga(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException {
        Socket socket;
        ObjectOutputStream writer;
        ObjectInputStream reader;
        
        try {
            socket = new Socket(this.serverAddress, this.serverPort);            
            writer = AbstractInOut.getObjectWriter(socket);
            reader = AbstractInOut.getObjectReader(socket);                 
            
            writer.writeUTF("recusaVaga(CandidatoVaga candidatoVaga)");
            writer.writeObject(candidatoVaga);           
            writer.flush();
            
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(VagaEvaluationSocketProxy.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
    }
}
