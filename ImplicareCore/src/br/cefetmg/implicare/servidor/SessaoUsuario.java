package br.cefetmg.implicare.servidor;

import br.cefetmg.implicare.model.domain.Usuario;
import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @author João Victor Bonfim
 */
public class SessaoUsuario
{
    InetAddress enderecoIP;
    Usuario usuario;
    
    public SessaoUsuario(InetAddress enderecoIP, Usuario usuario) throws IOException
    {
        if(validaEnderecoIP(enderecoIP))
        {
            this.enderecoIP = enderecoIP;
            if(validaUsuario(usuario))
            {
                this.usuario = usuario;
            }
        }
    }
    
    private boolean validaEnderecoIP(InetAddress enderecoIP) throws IOException
    {
        /*TO DO:
            Fun,c~ao que valida IP, se precisar.
        */
        return true;
    }
    
    private boolean validaUsuario(Usuario usuario) throws IOException
    {
        /*TO DO:
            Fun,c~ao que valida usu´ario, se precisar.
        */
        return true;
    }
}