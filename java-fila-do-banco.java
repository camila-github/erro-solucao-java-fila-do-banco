import java.io.IOException;
import java.util.*;

public class FilaDoBanco {  
    public static void main(String[] args) throws IOException {
    
      int pessoasNaFila, numSmsAtual, numReordenacao;
      ArrayList<Integer> filaAtual = new ArrayList<>();
      HashMap<Integer, Integer> numIndexOriginal = new HashMap<>();
      
      Scanner scanner = new Scanner(System.in);
      int casosDeTestes = scanner.nextInt();
      scanner.nextLine();
      
      for(int i = 0; i < casosDeTestes; i++) {
        pessoasNaFila = scanner.nextInt();
        numReordenacao = 0;

        for(int j = 0; j < pessoasNaFila; j++) {
            numSmsAtual = scanner.nextInt();
            filaAtual.add(numSmsAtual);
            numIndexOriginal.put(numSmsAtual, filaAtual.size() - 1);
        }
      
        compararNumeroSms comparar = new compararNumeroSms();
        Collections.sort(filaAtual, comparar);
        
        for(int j = 0; j < filaAtual.size(); j++) {
            int indexOriginal = numIndexOriginal.get(filaAtual.get(j));
            if (indexOriginal != j) numReordenacao++;
        }

        System.out.println(pessoasNaFila - numReordenacao);
        filaAtual = new ArrayList<>();
      }
    scanner.close();
  }

  static class compararNumeroSms implements Comparator<Integer> {
    public int compare(Integer numUm, Integer numDois) {
        int resultado = numUm.compareTo(numDois);
        return -resultado;
    }
  }
}