/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.serviceImpl.FormacaoAcademicaManagementImpl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 */
class AlterarFormacaoAcademica {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long CPF = (Long) request.getSession().getAttribute("CPF_CNPJ");
            int Seq_Formacao = Integer.parseInt(request.getParameter("Seq_Formacao"));
            String Instituicao_Ensino = request.getParameter("Instituicao_Ensino");
            int Cod_Area_Estudo = Integer.parseInt(request.getParameter("Cod_Area_Estudo"));
            String Atividades_Desenvolvidas = request.getParameter("Atividades_Desenvolvidas");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date Dat_Inicio = (Date) formato.parse(request.getParameter("Dat_Inicio"));
            Date Dat_Termino = (Date) formato.parse(request.getParameter("Dat_Termino"));
            String Desc_Formacao_Academica = request.getParameter("Desc_Formacao_Academica");

            FormacaoAcademicaManagementImpl FormacaoImpl = new FormacaoAcademicaManagementImpl();
            FormacaoAcademica Form = new FormacaoAcademica();
            
            Form.setCPF(CPF);
            Form.setSeq_Formacao(Seq_Formacao);
            Form.setInstituicao_Ensino(Instituicao_Ensino);
            Form.setCod_Area_Estudo(Cod_Area_Estudo);
            Form.setAtividades_Desenvolvidas(Atividades_Desenvolvidas);
            Form.setData_Inicio(Dat_Inicio);
            Form.setData_Termino(Dat_Termino);
            Form.setDesc_Formacao_Academica(Desc_Formacao_Academica);
            
            boolean Formacao = FormacaoImpl.update(CPF, Seq_Formacao, Cod_Area_Estudo, Form);

            if (Formacao =! false) {
                jsp = "";
                request.setAttribute("FormacaoAcademica", Form);
            } else {
                String Erro = "Erro ao Editar Formacao Academica";
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
}
