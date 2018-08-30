/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.dao;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.exception.PersistenceException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface VagaDao {
    public void insert(Vaga Vaga) throws PersistenceException;
    public boolean update(long CNPJ, int Cod_Cargo, Date Dat_Publicacao,Vaga Vaga) throws PersistenceException;
    public boolean delete(long CNPJ, int Cod_Cargo, Date Dat_Publicacao) throws PersistenceException;
    public List<Vaga> getVagaCNPJ(long CNPJ) throws PersistenceException;
    public List<Vaga> getVagaCod_Cargo(List<CargoInteresse> CarInteresse) throws PersistenceException;
    public Vaga getVagaCod(long CNPJ, int Cod_Cargo, Date Dat_Publicacao) throws PersistenceException;
}
