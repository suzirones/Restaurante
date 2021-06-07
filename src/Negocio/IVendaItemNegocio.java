package Negocio;

import Entidade.VendaItem;
import java.util.ArrayList;

public interface IVendaItemNegocio {
    int inserirVenda(VendaItem vendaItem, int codigoVenda);
    ArrayList<VendaItem> listaVenda(int codigoVenda);
}
