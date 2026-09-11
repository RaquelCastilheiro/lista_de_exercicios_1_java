import java.util.Scanner;

public class Main {
    public static void main (String[]args){
        Scanner sc = new Scanner (System.in);
        int alvo = 0;
        
        System.out.println("\n>> Bem-vindo ao somador de pares de números <<\n");
        System.out.println("Para começar, por favor, digite a quantidade de números que você quer inserir na lista: ");
        int qtd = sc.nextInt();
        sc.nextLine();

        int[] numeros = new int[qtd];

        for(int i = 0; i < numeros.length; i++){
            System.out.println("Agora, escreva o " + (i+1) + "º da sequência de números: ");
            numeros[i] = sc.nextInt();
            sc.nextLine();
        }
        
        System.out.println("Por favor, escreva o número alvo da soma: ");
        alvo = sc.nextInt();
        sc.nextLine();

        somaPares(numeros, alvo);
    }

    public static void somaPares(int[] numeros, int alvo){
        int qtdPares = 0;
        for(int i = 0; i < numeros.length; i++){
            for(int j = i+1; j < numeros.length; j++){
                if ((numeros[i] + numeros[j]) == alvo){
                    //se adicionar a quantidade de pares à qtdPares antes do segundo if, o segundo if será ==1 mesmo. mas se for depois do segundo if, será ==0
                    qtdPares++;
                    if(qtdPares==1){System.out.println("Par encontrado:");}else{System.out.println("Novo par encontrado:");}
                    System.out.println("Primeiro valor: " + numeros[i] + " > Índice: " + (i+1));
                    System.out.println("Segundo valor: " + numeros[j] + " > Índice: " + (j+1));
                    System.out.println("Soma dos pares: " + (numeros[i] + numeros[j]));
                }
            }
        }

        if(qtdPares == 0){
            System.out.println("Não foi encontrado nenhumpar com a soma resultante no valor alvo.");
        } else{
            System.out.println("Quantidade de pares encontrados: " + qtdPares);
        }
        
    }
}
