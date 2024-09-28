import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Filme filme = new Filme();
        Options option = new Options();

        System.out.println("Seja Bem-Vindo ao CINEDAY\n");
        filme.listarCatalogo();
        option.exibirOptions();




        //        System.out.println("FAÇA SEU CADASTRO: \n");
//        cliente.cadastroCliente();



    }
}