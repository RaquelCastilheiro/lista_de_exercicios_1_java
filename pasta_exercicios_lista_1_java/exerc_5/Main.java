import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int num;
        int quantidade = 0;
        int soma = 0;

        int maiorValor = 0;
        int menorValor = 0;

        int qtdPositivos = 0;
        int qtdNegativos = 0;

        int qtdPares = 0;
        int qtdImpares = 0;

        int qtdMultiploTres = 0;
        
        System.out.println("Bem-vindo! Digite uma sequência de números inteiros, tanto negativos quanto positivos (digite 0 para encerrar):");

        do{
            num = sc.nextInt();
            sc.nextLine();

            if(num != 0){
                quantidade++;
                maiorValor = verificarMaior(num, quantidade, maiorValor);
                menorValor = verificarMenor(num, quantidade, menorValor);
                soma += num;
                qtdPositivos = verificarPositivo(num, qtdPositivos);
                qtdNegativos = verificarNegativo(num, qtdNegativos);
                qtdPares = verificarPar(num, qtdPares);
                qtdImpares = verificarImpar(num, qtdImpares);
                qtdMultiploTres = verificarMultiploTres(num, qtdMultiploTres);
            }
        }while(num!=0);

        if(quantidade == 0){System.out.println("Nenhum número foi digitado.");}
        else{
            double media = calcularMedia(soma, quantidade);
            System.out.println("""
                Fim do programa.
                >> RESULTADOS <<
                Quantidade de números digitados: %d
                Soma de todos os valores: %d
                Média geral: %.2f
                Maior e menor valor: %d e %d
                Quantidade de valores positivos: %d
                Quantidade de valores negativos: %d
                Quantidade de valores pares: %d
                Quantidade de valores ímpares: %d
                Quantidade de múltiplos de três: %d
            """.formatted(quantidade, soma, media, maiorValor, menorValor, qtdPositivos, qtdNegativos, qtdPares, qtdImpares, qtdMultiploTres));
        }
    }

    public static int verificarMaior(int num, int quantidade, int maiorValor){
        if(quantidade == 1){
            maiorValor = num;
        }else{
            if(num > maiorValor){maiorValor = num;}
        }
        return maiorValor;
    }

    public static int verificarMenor(int num, int quantidade, int menorValor){
        if(quantidade == 1){
            menorValor = num;
            menorValor = num;
        }else{
            if(num < menorValor){menorValor = num;}
        }
        return menorValor;
    }

    public static int verificarPositivo(int num, int qtdPositivos){
        if(num > 0){qtdPositivos++;}
        return qtdPositivos;
    }
    public static int verificarNegativo(int num, int qtdNegativos){
        if(num < 0){qtdNegativos++;}
        return qtdNegativos;
    }
    public static int verificarPar(int num, int qtdPares){
        if(num % 2 == 0){qtdPares++;}
        return qtdPares;
    }
    public static int verificarImpar(int num, int qtdImpares){
        if(num % 2 != 0){qtdImpares++;}
        return qtdImpares;
    }
    public static int verificarMultiploTres(int num, int qtdMultiploTres){
        if(num % 3 == 0){qtdMultiploTres++;}
        return qtdMultiploTres;
    }
    public static double calcularMedia(int soma, int quantidade){
        return soma / quantidade;
    }
}