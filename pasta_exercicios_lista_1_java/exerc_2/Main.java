package exerc_2;import java.util.Scanner;
public class Main {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n>> Bem-vindo ao Analista de Datas <<");
        
        int[] data = new int[3];
        boolean ehBissexto = false;
        boolean validarDataWhile = false;
        
        do{
            lerData(data);
            ehBissexto = definirAnoBissexto(data); 
            validarDataWhile = validarData(data, ehBissexto);
        } while(validarDataWhile == false);

        /*boolean ehBissexto = definirAnoBissexto(data); 
        boolean validarDataWhile = validarData(data, ehBissexto);
        definirAnoBissexto(data, ehBissexto);*/
        
        obterQuantidadeDiasMes(data, ehBissexto);
        obterTrimestre(data);
        int posicaoDia = obterPosicaoDiaAno(data, ehBissexto);
        System.out.println("A posição do dia no ano é: " + posicaoDia + "º");
    }

    public static void lerData(int[] data){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o dia (ex.: 9): ");
        data[0] = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o mês (ex.: 12): ");
        data[1] = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o ano (ex.: 2023): ");
        data[2] = sc.nextInt();
        sc.nextLine();

    }

    public static boolean definirAnoBissexto(int[] data){
        if(data[2] % 4 == 0 && data[2] % 100 != 0 || data[2] % 400 == 0){
            System.out.println("O ano " + data[2] + " é bissexto.");
            return true;
        } else {
            System.out.println("O ano " + data[2] + " não é bissexto.");
            return false;
        }
    }

    public static void obterQuantidadeDiasMes(int[] data, boolean ehBissexto){
        switch (data[1]){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println("O mês " + data[1] + " possui 31 dias.");
                break;
            case 4: case 6: case 9: case 11:
                System.out.println("O mês " + data[1] + " possui 30 dias.");
                break;
            case 2:
                if(ehBissexto==true){
                    System.out.println("O mês " + data[1] + " possui 29 dias.");
                } else {
                    System.out.println("O mês " + data[1] + " possui 28 dias.");
                }
                break;
        }
    }

    public static boolean validarData(int[]data, boolean ehBissexto){
        if(data[0] <=31 && data[1] <=12 && data[2] > 1583 && data[2] <=9999){
            System.out.println("Data válida! " + data[0] + "/" + data[1] + "/" + data[2]);
            return true;
        } else {
            System.out.println("Data inválida! Os dias podem ir somente até 31, os meses até 12 e o ano até 9999.");
            return false;
        }
    }

    public static void obterTrimestre(int[] data){
        if(data[1]<4){
            System.out.println("Esta data está no primeiro trimestre do ano.");
        } else if(data[1]<7){
            System.out.println("Esta data está no segundo trimestre do ano.");
        } else if(data[1]<10){
            System.out.println("Esta data está no terceiro trimestre do ano.");
        } else {
            System.out.println("Esta data está no quarto trimestre do ano.");
        }
    }

    public static int obterPosicaoDiaAno(int[]data, boolean ehBissexto){
        int posicaoDiaAno = 0;

        int[] quantidadeDiasMes = new int[12];

        quantidadeDiasMes[0] = 31;
        quantidadeDiasMes[1] = 28;
        if(ehBissexto==true){
            quantidadeDiasMes[1] = 29;
        }
        quantidadeDiasMes[2] = 31;
        quantidadeDiasMes[3] = 30;
        quantidadeDiasMes[4] = 31;
        quantidadeDiasMes[5] = 30;
        quantidadeDiasMes[6] = 31;
        quantidadeDiasMes[7] = 31;
        quantidadeDiasMes[8] = 30;
        quantidadeDiasMes[9] = 31;
        quantidadeDiasMes[10] = 30;
        quantidadeDiasMes[11] = 31;

        for(int i=0; i<data[1]-1; i++){
            posicaoDiaAno += quantidadeDiasMes[i];
        }
        posicaoDiaAno += data[0];
        return posicaoDiaAno;
    }
}
