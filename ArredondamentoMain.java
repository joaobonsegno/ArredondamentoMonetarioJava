package arredondamento;

/**
 *
 * @author joaobonsegno
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ArredondamentoMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> entradas = new ArrayList<>();
        
        System.out.printf("Quantidade de entradas desejadas: ");
        try{
            Integer quantidadeEntradas = Integer.parseInt(input.nextLine());
            System.out.println("");
            for (int i = 0; i < quantidadeEntradas; i++){
                System.out.printf("Insira o valor "+(i+1)+": ");
                String valorString = input.nextLine();
                entradas.add(Double.parseDouble(Arredondamento.arredondarValor(valorString)));
                valorString = String.format("%.2f", entradas.get(i));
                System.out.println("ENTRADA ["+(i+1)+"]: "+valorString+"\n");
            }
        }catch(java.lang.NumberFormatException ex){
            System.out.println("Entrada inválida!");
        }
    }
}