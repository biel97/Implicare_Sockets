/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.servlet;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 */
class AlterarTelefone {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long CPF_CNPJ = (Long) request.getSession().getAttribute("CPF_CNPJ");
            String Num_Telefone = request.getParameter("Num_Telefone");
            String Tipo_Telefone = request.getParameter("Tipo_Telefone");
            int DDD = Integer.parseInt(request.getParameter("DDD"));
            int Ramal = Integer.parseInt(request.getParameter("Ramal"));

            TelefoneManagementImpl TelefoneImpl = new TelefoneManagementImpl();
            Telefone Tel = new Telefone();
            
            Tel.setCPF_CNPJ(CPF_CNPJ);
            Tel.setNum_Telefone(Num_Telefone);
            Tel.setTipo_Telefone(Tipo_Telefone);
            Tel.setDDD(DDD);
            Tel.setRamal(Ramal);
            
            boolean Telefone = TelefoneImpl.update(CPF_CNPJ, Num_Telefone, Tel);

            if (Telefone =! false) {
                jsp = "";
                request.setAttribute("Telefone", Tel);
            } else {
                String Erro = "Erro ao Editar Telefone";
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
