import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o texto a ser cifrado:");
        String texto = scanner.nextLine();

        int chave = 0;
        boolean chaveValida = false;
        while (!chaveValida) {
            System.out.println("Digite a chave de cifração (um número inteiro positivo):");
            if (scanner.hasNextInt()) {
                chave = scanner.nextInt();
                if (chave > 0) {
                    chaveValida = true;
                } else {
                    System.out.println("A chave deve ser um número inteiro positivo.");
                }
            } else {
                System.out.println("A chave deve ser um número inteiro.");
                scanner.next();
            }
        }

        String textoCifrado = cifrar(texto, chave);
        System.out.println("Texto cifrado: " + textoCifrado);

        System.out.println("Deseja decifrar o texto cifrado? (s/n)");
        scanner.nextLine(); 
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            String textoDecifrado = decifrar(textoCifrado, chave);
            System.out.println("Texto decifrado: " + textoDecifrado);
        }

        scanner.close();
    }
    
    public static String cifrar(String texto, int chave) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);

            if (Character.isLetter(caractere)) {
                char base = Character.isUpperCase(caractere) ? 'A' : 'a';
                caractere = (char) (((caractere - base + chave) % 26) + base);
            }

            resultado.append(caractere);
        }

        return resultado.toString();
    }

    public static String decifrar(String textoCifrado, int chave) {
        return cifrar(textoCifrado, 26 - chave);
    }
}
