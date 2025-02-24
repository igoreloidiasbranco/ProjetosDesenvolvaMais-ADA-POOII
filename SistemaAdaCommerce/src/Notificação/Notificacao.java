package Notificação;

public class Notificacao {


        public void enviarEmail(String destinatario, String mensagem) {
            System.out.println("Enviando email para " + destinatario + ": " + mensagem);
        }

        public void enviarWhatsapp(String numero, String mensagem) {
            System.out.println("Enviando WhatsApp para " + numero + ": " + mensagem);
        }

        public void enviarSMS(String numero, String mensagem) {
            System.out.println("Enviando SMS para " + numero + ": " + mensagem);
        }
    }


