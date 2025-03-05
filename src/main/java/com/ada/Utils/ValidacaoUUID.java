package com.ada.Utils;

import java.util.Scanner;
import java.util.UUID;

public class ValidacaoUUID {
    static Scanner scanner = new Scanner(System.in);
    static UUID uuid = null;

    public static UUID validadorUUID() {
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
