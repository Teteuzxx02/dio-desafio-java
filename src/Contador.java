import java.util.Scanner;
import java.util.InputMismatchException;

public class Contador {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean sucesso = false;

        while (!sucesso) {
            try {
                System.out.println("Digite o primeiro parâmetro:");
                int parametroUm = obterNumeroInteiro(scan);
    
                System.out.println("Digite o segundo parâmetro:");
                int parametroDois = obterNumeroInteiro(scan);

                contar(parametroUm, parametroDois);
                sucesso = true; 
            } catch (ParametrosInvalidosException exception) {
                System.out.println(exception.getMessage());
                System.out.println("Tente novamente.");
            }
        }

        scan.close();
    }

    static int obterNumeroInteiro(Scanner scan) throws InputMismatchException {
        if (!scan.hasNextInt()) {
            throw new InputMismatchException("Você deve digitar um número inteiro!");
        }
        return scan.nextInt();
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm >= parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro!");
        }

        int ocorrencias = 0;

        for (int i = parametroUm; i < parametroDois; i++) {
            System.out.println("Imprimindo o número: " + i);

            ocorrencias++;
        }

        System.out.println("Foi realizado um total de " + ocorrencias + " ocorrências");
    }
}
