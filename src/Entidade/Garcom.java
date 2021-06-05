package Entidade;

public class Garcom {
   private int idGarcom;
   private String nome;

    public Garcom() {
    }

    public Garcom(int idGarcom) {
        this.idGarcom = idGarcom;
    }
   
   public int getIdGarcom() {
        return idGarcom;
    }

    public void setIdGarcom(int idGarcom) {
        this.idGarcom = idGarcom;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
