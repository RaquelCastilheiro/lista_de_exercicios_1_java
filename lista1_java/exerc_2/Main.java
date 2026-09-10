package lista_1_java.lista1_java.exerc_2;
import java.util.Scanner;
public class Main {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        
        int[] numeros = new int[3];

        System.out.println("\n>> Bem-vindo ao Analista de Datas <<");
        for(int i = 0; i < numeros.length; i++){
            System.out.println("Digite o número referente ao dia (ex.: 9): ");
            int dia = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite o número referente ao dia (ex.: 9): ");
            int mes = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite o número referente ao dia (ex.: 9): ");
            int ano = sc.nextInt();
            sc.nextLine();
        }
    }
}
