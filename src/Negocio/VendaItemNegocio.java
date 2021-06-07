package Negocio;

import Entidade.VendaItem;
import Persistencia.VendaItemDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaItemNegocio implements IVendaItemNegocio{
    
    private VendaItemDAO vendaItemDAO;

    public VendaItemNegocio() {
        vendaItemDAO = new VendaItemDAO();
    }

    @Override
    public int inserirVenda(VendaItem vendaItem, int codigoVenda) {
        try {
            return vendaItemDAO.inserirVendaItem(vendaItem, codigoVenda);
        } catch (Exception ex) {
            Logger.getLogger(VendaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }

    @Override
    public ArrayList<VendaItem> listaVenda(int codigoVenda) {
        try {
            return vendaItemDAO.listaVenda(codigoVenda);
        } catch (Exception ex) {
            Logger.getLogger(VendaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<VendaItem>();
    }
}
