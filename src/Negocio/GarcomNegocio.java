package Negocio;

import Entidade.Garcom;
import Persistencia.GarcomDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GarcomNegocio implements IGarcomNegocio {
private GarcomDAO garcomDAO;

    public GarcomNegocio() {
        garcomDAO = new GarcomDAO();
    }

    
    @Override
    public int inserirGarcom(Garcom garcom) {
        try {
            return garcomDAO.inserirGarcom(garcom);
        } catch (Exception ex) {
            Logger.getLogger(GarcomNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    @Override
    public ArrayList<Garcom> listaGarcomTodos() {
        try {
            return garcomDAO.listaGarcomTodos();
        } catch (Exception ex) {
            Logger.getLogger(GarcomNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<Garcom>();
    }

    @Override
    public Garcom listaGarcomPorNome(String nome) {
        try {
            return garcomDAO.listaGarcomPorNome(nome);
        } catch (Exception ex) {
            Logger.getLogger(GarcomNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Garcom();
    }

    @Override
    public boolean excluirGarcom(int idGarcom) {
        boolean resultado = false;
        
        try {
            resultado = garcomDAO.excluirGarcom(idGarcom);
        } catch (Exception ex) {
            Logger.getLogger(GarcomNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
}
