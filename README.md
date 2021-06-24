## Exercicio (Java): Fila do Banco

O exercicio publicado é referente ao treinamento do Bootcamp Java Developer - Ordenação e Filtros em Java 
(https://digitalinnovation.one)

#### Descrição do Desafio:

O banco que você trabalha sempre tem problemas para organizar as filas de atendimento dos clientes.

Após uma reunião com a gerência ficou decidido que os clientes ao chegar na agência receberão uma senha numérica em seu aparelho de celular via sms e que a ordem da fila será dada não pela ordem de chegada, mas sim pelo número recebido via sms. A ordem de atendimento será decrescente: aqueles que receberam número maior deverão ser atendidos primeiro. 

Então, dada a ordem de chegada dos clientes reordene a fila de acordo com o número recebido via sms, e diga quantos clientes não precisaram trocar de lugar nessa reordenação.

#### Entrada: 

A primeira linha contém um inteiro N, indicando o número de casos de teste a seguir.

Cada caso de teste inicia com um inteiro M (1 ≤ M ≤ 1000), indicando o número de clientes. Em seguida haverá M inteiros distintos Pi (1 ≤ Pi ≤ 1000), onde o i-ésimo inteiro indica o número recebido via sms do i-ésimo cliente.

Os inteiros acima são dados em ordem de chegada, ou seja, o primeiro inteiro diz respeito ao primeiro cliente a chegar na fila, o segundo inteiro diz respeito ao segundo cliente, e assim sucessivamente.

#### Saída: 

Para cada caso de teste imprima uma linha, contendo um inteiro, indicando o número de clientes que não precisaram trocar de lugar mesmo após a fila ser reordenada.

Exemplos de Entrada  | Exemplos de Saída
------------- | -------------
3 | 1
3 | 0
100 80 90 | 4
4
100 120 30 50
4
100 90 30 25


#### Java　

```java
//SOLUCAO 1
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

```

