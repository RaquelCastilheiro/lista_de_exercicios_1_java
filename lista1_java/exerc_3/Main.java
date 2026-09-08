import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        
        System.out.println("Bem-vindo à calculadora!");
        do{
            System.out.println("\n>> Menu <<\n1 - Soma" + "\n2 - Subtração" + "\n3 - Multiplicação" + "\n4 - Divisão" + "\n5 - Potenciação" + "\n6 - Resto da Divisão" + "\n7 - Encerrar");
            System.out.println("Escolha uma opção: ");
            try{
                menu = sc.nextInt();
                sc.nextLine();

                switch(menu){
                    case 1:
                        System.out.println("Você escolheu somar");
                        System.out.println("\nQuais números você deseja somar? Digite os números separados por espaço (ex.: 12 13.5 14.3): ");
                        String numSoma = sc.nextLine();
                        somar(numSoma);
                        break;
                    case 2:
                        System.out.println("Você escolheu subtrair");
                        System.out.println("\nQuais números você deseja subtrair? Digite os números separados por espaço e na ordem correta que deseja fazer a operação (ex.: 20 5.5):");
                        String numSubtracao = sc.nextLine();
                        subtrair(numSubtracao);
                        break;
                    case 3:
                        System.out.println("Você escolheu multiplicar");
                        System.out.println("\nQuais números você deseja multiplicar? Digite os números separados por espaço (ex.: 6 4): ");
                        String numMultiplicacao = sc.nextLine();
                        multiplicar(numMultiplicacao);
                        break;
                    case 4:
                        System.out.println("Você escolheu dividir");
                        System.out.println("\nQuais números você deseja dividir? Digite os números separados por espaço e na ordem correta que deseja fazer a operação (ex.: 20 5.5):");
                        String numDivisao = sc.nextLine();
                        dividir(numDivisao);
                        break;
                    case 5:
                        System.out.println("Você escolheu realizar exponenciação");
                        System.out.println("\nQual número você deseja elevar? Digite primeiro o número base e depois o expoente separados por espaço (ex.: 2 3):");
                        String numPotenciacao = sc.nextLine();
                        exponenciar(numPotenciacao);
                        break;
                    case 6:
                        System.out.println("Você escolheu verificar o resto da divisão");
                        System.out.println("\nQuais números você deseja dividir? Digite os números separados por espaço e na ordem correta que deseja fazer a operação (ex.: 20 6):");
                        String numRestoDivisao = sc.nextLine();
                        restoDivisao(numRestoDivisao);
                        break;
                    case 7:
                        System.out.println("Encerrando calculadora...");
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha um dos números do menu.");
                }
            }
                
            catch (ArithmeticException e){
                System.out.println("Erro: Divisão por zero não é permitida.");
            }

        } while(menu != 7);
    }

    public static void somar(String numSoma){
        String[] soma = numSoma.split(" ");
        double resultadoSoma = 0;

        for (int i = 0; i < soma.length; i++){
            resultadoSoma += (Double.parseDouble(soma[i]));
        }
        System.out.println("O resultado da soma é: " + resultadoSoma);
    }

    public static void subtrair(String numSubtracao){
        String[] subtracao = numSubtracao.split(" ");
        double resultadoSubtracao = Double.parseDouble(subtracao[0]);
        
        for (int i = 1; i < subtracao.length; i++){
            double numero = Double.parseDouble(subtracao[i]);
            resultadoSubtracao -= numero;
        }
        System.out.println("O resultado da subtração é: " + resultadoSubtracao);
    }

    public static void multiplicar(String numMultiplicacao){
        String[] multiplicacao = numMultiplicacao.split(" ");
        double resultadoMultiplicacao = 1;

        for (int i = 0; i < multiplicacao.length; i++){
            resultadoMultiplicacao *= (Double.parseDouble(multiplicacao[i]));
        }
        System.out.println("O resultado da multiplicação é: " + resultadoMultiplicacao);
    }

    public static void dividir(String numDivisao){
        String[] divisao = numDivisao.split(" ");
        double resultadoDivisao = Double.parseDouble(divisao[0]);

        for (int i = 1; i < divisao.length; i++){
            double numero = Double.parseDouble(divisao[i]);
            resultadoDivisao /= numero;
        }
        System.out.println("O resultado da divisão é: " + resultadoDivisao);
    }

    public static void exponenciar(String numExponenciacao){
        String[] exponenciacao = numExponenciacao.split(" ");
        double resultadoExponenciacao = 0;

        for (int i = 0; i < exponenciacao.length; i++){
            resultadoExponenciacao = Math.pow(Double.parseDouble(exponenciacao[0]), Double.parseDouble(exponenciacao[1]));
        }
        System.out.println("O resultado da exponenciação é: " + resultadoExponenciacao);
    }

    public static void restoDivisao(String numRestoDivisao){
        String[] numCalculoRestoDivisao = numRestoDivisao.split(" ");
        double resultadoRestoDivisao = Double.parseDouble(numCalculoRestoDivisao[0]) % Double.parseDouble(numCalculoRestoDivisao[1]);
        System.out.println("O resultado do resto da divisão é: " + resultadoRestoDivisao);
    }

        
}