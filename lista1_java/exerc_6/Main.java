import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        int qtdParticipantes = 0;
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a quantidade de participantes: ");
        qtdParticipantes = sc.nextInt();
        sc.nextLine();

        String[] nomesParticipantes = new String[qtdParticipantes];
        int[] temposParticipantes = new int [qtdParticipantes];

        receberRetornarNomesTempos(nomesParticipantes, temposParticipantes, qtdParticipantes);
        apresentarParticipantes(nomesParticipantes, temposParticipantes, qtdParticipantes);

        double mediaTempos = 0;
        mediaTempos = mediaTempoParticipantes(temposParticipantes, mediaTempos);

        ordenarVetor(temposParticipantes, nomesParticipantes);

        temposAbaixoMedia(qtdParticipantes, temposParticipantes, mediaTempos, nomesParticipantes);

        temposLentoRapido(temposParticipantes, nomesParticipantes);

        calcularMediana(temposParticipantes);

        double desvioPadrao = calcularDesvioPadrao(temposParticipantes, mediaTempos);
        System.out.printf(">> Desvio Padrão dos Tempos: (%.2f)%n", desvioPadrao);

    }

    public static void receberRetornarNomesTempos(String[] nomesParticipantes, int[] temposParticipantes, int qtdParticipantes){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < qtdParticipantes; i++){
            System.out.print("Informe o nome do participante nº" + (i+1) + ": ");
            nomesParticipantes[i] = sc.nextLine();

            System.out.print("Informe o tempo de prova do participante nº" + (i+1) + ": ");
            temposParticipantes[i] = sc.nextInt();
            sc.nextLine();            
        }
    }

    /*public static void exibirNomesTempos(String[] nomesParticipantes, int[] temposParticipantes, int quantidade){
        for(int i = 0; i < quantidade; i++){
            System.out.println(nomesParticipantes[i] + " - " + temposParticipantes[i]);
        }
    }*/

    public static void apresentarParticipantes(String[] nomesParticipantes, int[] temposParticipantes, int qtdParticipantes){
        System.out.println("\n>> Nomes e Tempos dos participantes << ");

        for(int i = 0; i < qtdParticipantes; i++){
            System.out.println("\nParticipante " + (i+1) + ": " + "\nNome: " + nomesParticipantes[i] + "\nTempo: " + temposParticipantes[i] + "s"); 
        }
    }

    public static double mediaTempoParticipantes(int[] temposParticipantes, double mediaTempos){
        double somaTemposLista = 0;

        for (int i=0; i < temposParticipantes.length; i++){
            somaTemposLista += temposParticipantes[i];
        }

        mediaTempos = (somaTemposLista)/(temposParticipantes.length);

        System.out.printf("\nMédia dos tempos dos participantes: (%.2f)%n", mediaTempos);

        return mediaTempos;
    }

    public static void temposAbaixoMedia(int qtdParticipantes, int[] temposParticipantes, double mediaTempos, String[] nomesParticipantes){
        System.out.println("\n>> Participantes com tempo abaixo da média <<");

        int qtdAbaixoMedia = 0;
        /*System.out.print(qtdAbaixoMedia);
        System.out.print(Arrays.toString(temposParticipantes));
        System.out.print(mediaTempos);
        System.out.print(Arrays.toString(nomesParticipantes));*/

        for (int i = 0; i < qtdParticipantes; i++){
            if (temposParticipantes[i] < mediaTempos){
                System.out.println(">> " + nomesParticipantes[i] + " - " + temposParticipantes[i] + " segundos.");
                qtdAbaixoMedia += 1;
            }
        if (qtdAbaixoMedia == 0){
                System.out.println("Nenhum participante abaixo da média.");
            }
        }
        System.out.println("\nQuantidade de participantes com tempo abaixo da média: " + qtdAbaixoMedia + "\n");
        
    }

    public static int[] ordenarVetor(int[] temposParticipantes, String[] nomesParticipantes){
        int indiceTemposAux;
        String indiceNomesAux;
        for (int i = 0; i < temposParticipantes.length; i++){
            for (int j = 0; j < temposParticipantes.length-1; j++){
                if (temposParticipantes[j] > temposParticipantes[j+1]){

                    indiceTemposAux = temposParticipantes[j];
                    temposParticipantes[j] = temposParticipantes[j+1];
                    temposParticipantes[j+1] = indiceTemposAux;
                    
                    indiceNomesAux = nomesParticipantes[j];
                    nomesParticipantes[j] = nomesParticipantes[j+1];
                    nomesParticipantes[j+1] = indiceNomesAux;
                }
            }
        }
        return temposParticipantes;
    }

    public static void temposLentoRapido(int[] temposParticipantes, String[] nomesParticipantes){
        int maisRapidoTempo = temposParticipantes[0];
        int maisLentoTempo = temposParticipantes[temposParticipantes.length-1];
        String maisRapidoNome = nomesParticipantes[0];
        String maisLentoNome = nomesParticipantes[nomesParticipantes.length-1];

        System.out.println("\n>> Participante mais rápido <<\nNome: " + maisRapidoNome + "\nTempo: " + maisRapidoTempo);
        System.out.println("\n>> Participante mais lento <<\nNome: " + maisLentoNome + "\nTempo: " + maisLentoTempo);
        
        System.out.println("\n>> Ranking dos Participantes <<");
        for(int i = 0; i < temposParticipantes.length; i++){
            System.out.println("\nNome: " + nomesParticipantes[i] + "\nTempo: " + temposParticipantes[i] + "s");
        }
    }

    public static void calcularMediana(int[] temposParticipantes){
        int dividirVetor;
        double mediana;

        if((temposParticipantes.length) % 2 == 0){
            dividirVetor = (temposParticipantes.length)/2;
            int meio1 = temposParticipantes[dividirVetor];
            int meio2 = temposParticipantes[dividirVetor-1];
            mediana = (meio1+meio2)/2;
        } else{
            dividirVetor = (temposParticipantes.length-1)/2;
            mediana = temposParticipantes[dividirVetor];
        }

        System.out.println("\n>> Mediana dos Tempos: " + mediana);

    }

    public static double calcularDesvioPadrao(int[] temposParticipantes, double mediaTempos){
        double desvioPadrao = 0;
        int length = temposParticipantes.length;

        for(int i = 0; i < temposParticipantes.length; i++){
            desvioPadrao += Math.pow((temposParticipantes[i] - mediaTempos), 2);
        }
        return Math.sqrt(desvioPadrao/length);
    }

}