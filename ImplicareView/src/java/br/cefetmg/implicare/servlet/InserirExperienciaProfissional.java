/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.serviceImpl.ExperienciaProfissionalManagementImpl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 */
class InserirExperienciaProfissional {

    static String execute(HttpServletRequest request) {
        String jsp="";
        try {
            
            Long CPF = (Long) request.getSession().getAttribute("CPF_CNPJ");
            int Seq_Experiencia = Integer.parseInt(request.getParameter("Seq_Experiencia"));
            String Nom_Empresa = request.getParameter("Nom_Empresa");
            int Cod_Cargo = Integer.parseInt(request.getParameter("Cod_Cargo"));
            Long Cod_CEP = Long.parseLong(request.getParameter("Cod_CEP"));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date Dat_Inicio = (Date) formato.parse(request.getParameter("Data_Inicio"));
            Date Data_Termino = (Date) formato.parse(request.getParameter("Data_Termino"));
            String Desc_Experiencia_Profissional = request.getParameter("Desc_Experiencia_Profissional");
            Long Cod_Cidade = Long.parseLong(request.getParameter("Cod_Cidade"));
            Long Cod_Estado = Long.parseLong(request.getParameter("Cod_Estado"));
            
            ExperienciaProfissionalManagementImpl ExperienciaImpl = new ExperienciaProfissionalManagementImpl();            
            ExperienciaProfissional Exp = new ExperienciaProfissional();
            
            Exp.setCPF(CPF);
            Exp.setSeq_Experiencia(Seq_Experiencia);
            Exp.setNom_Empresa(Nom_Empresa);
            Exp.setCod_Cargo(Cod_Cargo);
            Exp.setCod_CEP(Cod_CEP);
            Exp.setData_Inicio(Dat_Inicio);
            Exp.setData_Termino(Data_Termino);
            Exp.setDesc_Experiencia_Profissional(Desc_Experiencia_Profissional);
            Exp.setCod_Cidade(Cod_Cidade);
            Exp.setCod_Estado(Cod_Estado);

            ExperienciaImpl.insert(Exp);

            if (ExperienciaImpl.getExperienciaProfissionalCod(CPF, Seq_Experiencia, Cod_Cargo) == null) {
                String Erro = "Erro ao inserir Experiencia Profissional";
                jsp="/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            } else {
                jsp="";
            }
        } catch(Exception e) {
            e.printStackTrace();
            jsp="";
        }
        
        return jsp;
    }
    
}
