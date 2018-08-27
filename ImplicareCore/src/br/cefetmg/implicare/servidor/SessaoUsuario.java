package br.cefetmg.implicare.servidor;

import br.cefetmg.implicare.model.domain.Usuario;
import java.net.InetAddress;

/**
 *
 * @author João Victor Bonfim
 */
public class SessaoUsuario
{
    InetAddress enderecoIP;

    public SessaoUsuario(InetAddress enderecoIP, Usuario usuario)
    {
        if(validaEnderecoIP(enderecoIP))
        {this.enderecoIP = enderecoIP;}
    }
    
    private boolean validaEnderecoIP(InetAddress enderecoIP)
    {
        /*TO DO:
            Fun,c~ao que valida IP, se precisar.
        */
        return true;
    }
}