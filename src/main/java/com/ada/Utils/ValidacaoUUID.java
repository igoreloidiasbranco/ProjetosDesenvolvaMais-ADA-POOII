package com.ada.Utils;

import java.util.Scanner;
import java.util.UUID;

public class ValidacaoUUID {
     Scanner scanner = new Scanner(System.in);
     UUID uuid;

    public UUID validadorUUID() {
        this.uuid = null;
        while (uuid == null) {
            String input = scanner.next();
            System.out.println();
            try {
                uuid = UUID.fromString(input);
            } catch (IllegalArgumentException e) {
                System.out.print("Entrada inválida. Digite um Id válido: ");
            }
        }
        return uuid;
    }
}
