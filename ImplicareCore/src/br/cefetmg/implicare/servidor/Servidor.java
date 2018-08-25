/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servidor;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Gabriel
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ServerSocket server = null;
        
        try {
            server = new ServerSocket(2223);

            while(true) {
                Socket socket = server.accept();
                
                AreaEstudoSocketAdapter AreaEstudo = new AreaEstudoSocketAdapter(socket);
                Thread AreaEstudo = new Thread(AreaEstudo);
                AreaEstudo.start();
                
                CandidatoVagaDialogoSocketAdapter CandidatoVagaDialogo = new CandidatoVagaDialogoSocketAdapter(socket);
                Thread CandidatoVagaDialogo = new Thread(CandidatoVagaDialogo);
                CandidatoVagaDialogo.start();
                
                CandidatoVagaSocketAdapter CandidatoVaga = new CandidatoVagaSocketAdapter(socket);
                Thread CandidatoVaga = new Thread(CandidatoVaga);
                CandidatoVaga.start();
                
                CargoAreaEstudoSocketAdapter CargoAreaEstudo = new CargoAreaEstudoSocketAdapter(socket);
                Thread CargoAreaEstudo = new Thread(CargoAreaEstudo);
                CargoAreaEstudo.start();
                
                CargoInteresseSocketAdapter CargoInteresse = new CargoInteresseSocketAdapter(socket);
                Thread CargoInteresse = new Thread(CargoInteresse);
                CargoInteresse.start();
                
                CargoSocketAdapter Cargo = new CargoSocketAdapter(socket);
                Thread Cargo = new Thread(Cargo);
                Cargo.start();
                
                CepSocketAdapter Cep = new CepSocketAdapter(socket);
                Thread Cep = new Thread(Cep);
                Cep.start();
                
                CidadeSocketAdapter Cidade = new CidadeSocketAdapter(socket);
                Thread Cidade = new Thread(Cidade);
                Cidade.start();
                
                CompetenciaSocketAdapter Competencia = new CompetenciaSocketAdapter(socket);
                Thread Competencia = new Thread(Competencia);
                Competencia.start();
                
                CompetenciaPessoaFsicaSocketAdapter CompetenciaPessoaFsica = new CompetenciaPessoaFsicaSocketAdapter(socket);
                Thread CompetenciaPessoaFsica = new Thread(CompetenciaPessoaFsica);
                CompetenciaPessoaFsica.start();
                
                EmpresaSocketAdapter Empresa = new EmpresaSocketAdapter(socket);
                Thread Empresa = new Thread(Empresa);
                Empresa.start();
                
                EmpresaSocketAdapter Empresa = new EmpresaSocketAdapter(socket);
                Thread Empresa = new Thread(Empresa);
                Empresa.start();
                
                ExperienciaProfissionalSocketAdapter ExperienciaProfissional = new ExperienciaProfissionalSocketAdapter(socket);
                Thread ExperienciaProfissional = new Thread(ExperienciaProfissional);
                ExperienciaProfissional.start();
                
                FormacaoAcademicaSocketAdapter FormacaoAcademica = new FormacaoAcademicaSocketAdapter(socket);
                Thread FormacaoAcademica = new Thread(FormacaoAcademica);
                FormacaoAcademica.start();
                
                PessoaFisicaSocketAdapter PessoaFisica = new PessoaFisicaSocketAdapter(socket);
                Thread PessoaFisica = new Thread(PessoaFisica);
                PessoaFisica.start();
                
                ProficienciaSocketAdapter Proficiencia = new ProficienciaSocketAdapter(socket);
                Thread Proficiencia = new Thread(Proficiencia);
                Proficiencia.start();
                
                TelefoneSocketAdapter Telefone = new TelefoneSocketAdapter(socket);
                Thread Telefone = new Thread(Telefone);
                Telefone.start();
                
                UsuarioSocketAdapter Usuario = new UsuarioSocketAdapter(socket);
                Thread Usuario = new Thread(Usuario);
                Usuario.start();
                
                VagaSocketAdapter Vaga = new VagaSocketAdapter(socket);
                Thread Vaga = new Thread(Vaga);
                Vaga.start();
            }
        }
        catch(Exception e) {
            if (server != null)
                server.close();
        }
        
    }
    
}
