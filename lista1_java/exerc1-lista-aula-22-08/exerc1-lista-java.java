import java.util.Scanner;

public class Main{
    public static void main(String[]args){

        System.out.println("Olá! Bem-vindo ao sistema de classificação da situação dos estudantes.");

        Scanner sc = new Scanner(System.in);

        String nome;
        double notas [] = new double[3];
        int frequencia;

        System.out.println("Escreva o nome do estudante: ");
        nome = sc.nextLine();

        System.out.println("Escreva a fequência do estudante sem o sinal de porcentagem (ex.: 80): ");
        frequencia = sc.nextInt();
        sc.nextLine();


        for (int i = 0; i <= 2; i++){
            System.out.println("Escreva a " +(i+1) + "º nota do estudante: ");
            notas[i] = sc.nextDouble();
            sc.nextLine();
        }

        System.out.println("A nome é: " + nome);

        double media = calcularMedia(notas);
        System.out.println("A média é: " + String.format("%.2f", media));

        System.out.println("A frequência  é: " + frequencia + "%");

        String situacao = calcularSituacao(media, frequencia);
        System.out.println("A situação do estudante é: " + situacao);
    }

    public static double calcularMedia(double[]notas){
        double soma = 0;
        for (int i = 0; i < notas.length; i++){
            soma += notas[i];
        }
        return (soma/notas.length);
    }

    public static String calcularSituacao(double media, int frequencia){
        if ((media >=7)  && (frequencia >= 75)){
            return "Aprovado!";
        }
        else if ((media >= 5 && media < 7) && (frequencia < 75)){
            return "Recuperação!";
        }
        else if ((media > 7) && (frequencia < 75)){
            return "Reprovado por falta!";
        }
        else if((media < 7) && (frequencia > 75)){
            return "Reprovado por nota!";
        }
        else{
            return "Reprovado por nota e falta!";
        }
    }
}