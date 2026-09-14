import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        //Character.toLowerCase();
        /*String texto = "Esta é uma frase de teste";
        System.out.println("O texto possui " + texto.length() + " caracteres.");
        if ()*/

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma frase (pode conter qualquer tipo de caractere): ");
        String fraseUsuario = sc.nextLine().toLowerCase();
        System.out.println("Agora, escolha um caractere para descobrir sua frequência na frase: ");

        String caractereEscolhidoS = sc.next().toLowerCase();
        //como não é possível atibuir uma String a um char, então tem que separar por partes
        //.charAt(0) extrai o caractere da variável String e passa a guardá-lo numa variável char
        char caractereEscolhidoC = caractereEscolhidoS.charAt(0);

        /*int qtdEspacos = contarCaracteres(fraseUsuario);
        System.out.println("A frase possui " + qtdEspacos + " espaços.");*/

        contarCaracteres(fraseUsuario);

        int qtdCaractereEscolhido = frequeciaLetraEscolhida(caractereEscolhidoC, fraseUsuario);
        System.out.println("O caractere " + caractereEscolhidoC + " aparece " + qtdCaractereEscolhido + " vezes na frase.");
    }
    public static void contarCaracteres(String fraseUsuario){
        
        int qtdCaracteres = fraseUsuario.length();
        int qtdLetras = 0;
        int qtdVogais = 0;
        int qtdConsoantes = 0;
        int qtdAlgarismos = 0;
        int qtdEspacos = 0;
        int qtdOutrosCaracteres = 0;

        

        for (int i = 0; i < fraseUsuario.length(); i++){
            char c = fraseUsuario.charAt(i);
            boolean ehLetra = (c >= 'a' && c <= 'z');

            if(c == ' '){
                qtdEspacos++;
            }else if(ehLetra){
                qtdLetras++;
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    qtdVogais++;
                }else{
                    qtdConsoantes++;
                }
            }else if(c>='0'&& c<='9'){
                qtdAlgarismos++;
            }else{
                qtdOutrosCaracteres++;
            }
        }
        System.out.println("A frase possui " + qtdLetras + " letras.");
        System.out.println("A frase possui " + qtdEspacos + " espaços.");
        System.out.println("A frase possui " + qtdVogais + " vogais.");
        System.out.println("A frase possui " + qtdConsoantes + " consoantes.");
        System.out.println("A frase possui " + qtdAlgarismos + " algarismos.");
        System.out.println("A frase possui " + qtdOutrosCaracteres + " outros caracteres.");

    }
    public static int frequeciaLetraEscolhida(char caractereEscolhidoC, String fraseUsuario){
        int qtdCaractereEscolhido = 0;
        for(int i = 0; i < fraseUsuario.length(); i++){
            if(fraseUsuario.charAt(i) == caractereEscolhido){
                qtdCaractereEscolhido++;
            }
        }
        return qtdCaractereEscolhido;
    }
}