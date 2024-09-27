import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Filme filme = new Filme();

        System.out.println("Seja Bem-Vindo ao CINEDAY\n");
        filme.listarCatalogo();

        System.out.println("");


    }
}