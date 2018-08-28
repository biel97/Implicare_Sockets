/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.model.dao.FormacaoAcademicaDao;
import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class FormacaoAcademicaDaoImpl implements FormacaoAcademicaDao {

    @Override
    public void insert(FormacaoAcademica FormacaoAcademica) throws PersistenceException {
        try {
            Long Seq_FormacaoAcademica;
                    
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO FormacaoAcademica (CPF, Seq_Formacao, Instituicao_Ensino, Cod_Area_Estudo,"
                    + "Atividades_Desenvolvidas, Data_Inicio, Data_Termino, Desc_Formacao_Academica) "
                    + "VALUES(?,?,?,?,?,?,?,?) RETURNING Seq_FormacaoAcademica";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, FormacaoAcademica.getCPF());
            ps.setInt(2, FormacaoAcademica.getSeq_Formacao());
            ps.setString(3, FormacaoAcademica.getInstituicao_Ensino());
            ps.setInt(4, FormacaoAcademica.getCod_Area_Estudo());
            ps.setString(5, FormacaoAcademica.getAtividades_Desenvolvidas());
            ps.setDate(6, FormacaoAcademica.getData_Inicio());
            ps.setDate(7, FormacaoAcademica.getData_Termino());
            ps.setString(8, FormacaoAcademica.getDesc_Formacao_Academica());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Seq_FormacaoAcademica = rs.getLong("Seq_FormacaoAcademica");
            }

            rs.close();
            ps.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public boolean update(long CPF, int Seq_Formacao, int Cod_Area_Estudo, FormacaoAcademica FormacaoAcademica) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "UPDATE FormacaoAcademica SET Seq_Formacao = ?, Instituicao_Ensino = ?, "
                    + "Cod_Area_Estudo = ? , Atividades_Desenvolvidas = ?, Data_Inicio = ?, "
                    + "Data_Termino = ?, Desc_Formacao_Academica = ?"
                    + "WHERE CPF = ?, Seq_Formacao = ?, Cod_Area_Estudo = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setInt(1, FormacaoAcademica.getSeq_Formacao());
            ps.setString(2, FormacaoAcademica.getInstituicao_Ensino());
            ps.setInt(3, FormacaoAcademica.getCod_Area_Estudo());
            ps.setString(4, FormacaoAcademica.getAtividades_Desenvolvidas());
            ps.setDate(5, FormacaoAcademica.getData_Inicio());
            ps.setDate(6, FormacaoAcademica.getData_Termino());
            ps.setString(7, FormacaoAcademica.getDesc_Formacao_Academica());
            ps.setLong(8, CPF);
            ps.setInt(9, Seq_Formacao);
            ps.setInt(10, Cod_Area_Estudo);
            
            ps.executeQuery(SQL);
            ps.close();
            connection.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public boolean delete(long CPF, int Seq_Formacao, int Cod_Area_Estudo) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();
            
            String SQL = "DELETE FROM FormacaoAcademica"
                    + "WHERE CPF = ?, Seq_Formacao = ?, Cod_Area_Estudo = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ps.setLong(1, CPF);
            ps.setInt(2, Seq_Formacao);
            ps.setInt(3, Cod_Area_Estudo);
            
            ps.executeQuery(SQL);
            ps.close();
            connection.close();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    
    @Override
    public List<FormacaoAcademica> getFormacaoAcademica(long CPF) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM FormacaoAcademica WHERE CPF = ? ORDER BY Seq_Formacao;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, CPF);
            ResultSet rs = ps.executeQuery();

            List<FormacaoAcademica> FormAcad = new ArrayList<>();
            
            if (rs.next()) {
                do {
                    FormacaoAcademica Acad = new FormacaoAcademica();
                    Acad.setCPF(rs.getLong("CPF"));
                    Acad.setSeq_Formacao(rs.getInt("Seq_Formacao"));
                    Acad.setInstituicao_Ensino(rs.getString("Instituicao_Ensino"));
                    Acad.setCod_Area_Estudo(rs.getInt("Cod_Area_Estudo"));
                    Acad.setAtividades_Desenvolvidas(rs.getString("Atividades_Desenvolvidas"));
                    Acad.setData_Inicio(rs.getDate("Data_Inicio"));
                    Acad.setData_Termino(rs.getDate("Data_Termino"));
                    Acad.setDesc_Formacao_Academica(rs.getString("Desc_Formacao_Academica"));
                    FormAcad.add(Acad);
                } while (rs.next());
            }

            rs.close();
            ps.close();
            connection.close();

            return FormAcad;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public FormacaoAcademica getFormacaoAcademicaCod(long CPF, int Seq_Formacao, int Cod_Area_Estudo) throws PersistenceException {
        try {
            Connection connection = JDBCConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM FormacaoAcademica WHERE CPF = ?, Seq_Formacao = ?, Cod_Area_Estudo = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, CPF);
            ps.setInt(2, Seq_Formacao);
            ps.setInt(3, Cod_Area_Estudo);
            
            ResultSet rs = ps.executeQuery();

           FormacaoAcademica Acad = new FormacaoAcademica();
            
            if (rs.next()) {
                Acad.setCPF(rs.getLong("CPF"));
                Acad.setSeq_Formacao(rs.getInt("Seq_Formacao"));
                Acad.setInstituicao_Ensino(rs.getString("Instituicao_Ensino"));
                Acad.setCod_Area_Estudo(rs.getInt("Cod_Area_Estudo"));
                Acad.setAtividades_Desenvolvidas(rs.getString("Atividades_Desenvolvidas"));
                Acad.setData_Inicio(rs.getDate("Data_Inicio"));
                Acad.setData_Termino(rs.getDate("Data_Termino"));
                Acad.setDesc_Formacao_Academica(rs.getString("Desc_Formacao_Academica"));
            }

            rs.close();
            ps.close();
            connection.close();

            return Acad;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
}
