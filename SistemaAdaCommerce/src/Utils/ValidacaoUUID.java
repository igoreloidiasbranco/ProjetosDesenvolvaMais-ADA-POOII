package Utils;

import java.util.Scanner;
import java.util.UUID;

public class ValidacaoUUID {
    static Scanner scanner = new Scanner(System.in);
    static UUID uuid = null;

    public static UUID validadorUUID() {
        System.out.print("Digite o Id: ");
        while (uuid == null) {
            String input = scanner.next();
            try {
                uuid = UUID.fromString(input);
            } catch (IllegalArgumentException e) {
                System.out.print("Entrada inválida. Digite um Id válido: ");
            }
        }
        return uuid;
    }
}
