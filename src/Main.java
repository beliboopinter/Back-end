import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== DETECTOR DE GOLPES DIGITAIS ===");
        System.out.println("Cole a mensagem suspeita abaixo para análise:");
        String mensagem = scanner.nextLine().toLowerCase();

        int scoreDeRisco = 0;

        // Regra de Negócio: Verificação de sinais de risco
        if (mensagem.contains("urgente") || mensagem.contains("imediato")) {
            scoreDeRisco += 1;
        }
        if (mensagem.contains("pix") || mensagem.contains("transferencia") || mensagem.contains("premio")) {
            scoreDeRisco += 1;
        }
        if (mensagem.contains("bloquead") || mensagem.contains("cancelad")) {
            scoreDeRisco += 1;
        }
        if (mensagem.contains("http") || mensagem.contains("bit.ly") || mensagem.contains("link")) {
            scoreDeRisco += 1;
        }

        // Tomada de Decisão (Saída)
        System.out.println("\n--- RESULTADO DA ANÁLISE ---");
        System.out.println("Pontuação de Risco: " + scoreDeRisco + "/4");

        if (scoreDeRisco >= 3) {
            System.out.println("Status: [ALERTA MÁXIMO] Esta mensagem possui fortes indícios de GOLPE!");
        } else if (scoreDeRisco >= 1) {
            System.out.println("Status: [CUIDADO] Mensagem suspeita. Verifique com a fonte oficial.");
        } else {
            System.out.println("Status: [SEGURA] Nenhum padrão de golpe comum foi detectado.");
        }

        scanner.close();
    }
}