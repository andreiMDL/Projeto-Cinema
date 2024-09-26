public class Reserva {

    // Atributos
    private int numAssentos;
    private int codigoConfirm;
    private String status;
    

    // Construtor
    public Reserva(int numAssentos, int codigoConfirm, String status) {
        this.numAssentos = numAssentos;
        this.codigoConfirm = codigoConfirm;
        this.status = status;
    }
    

    // Getters and Setters
    public int getNumAssentos() {
        return numAssentos;
    }

    public void setNumAssentos(int numAssentos) {
        this.numAssentos = numAssentos;
    }

    public int getCodigoConfirm() {
        return codigoConfirm;
    }

    public void setCodigoConfirm(int codigoConfirm) {
        this.codigoConfirm = codigoConfirm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   

    // Ações
    public void escolherAssento(){

    }

    public void confirmarCodigo(){

    }
}
