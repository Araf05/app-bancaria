import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre = "Tony Stark";
        String tipoCuenta = "corriente";
        double saldo = 1599.99;
        int opcion;

        String resumen = """
                *****************************
                
                Nombre del cliente: %s
                Tipo de cuenta: %s
                Saldo disponible: %f$
                """.formatted(nombre, tipoCuenta, saldo);

        String menu = """
                ******************************
                
                ** Escriba el número de la opción deseada **
                1- Consultar el saldo
                2- Retirar
                3- Depositar
                9- Salir
                
                ******************************
                """;
        String saldoActualizado = "El saldo actualizado es: ";
        String error = "Error! Ha ingresado un monto incorrecto";

        System.out.println(resumen);
        System.out.println(menu);
        opcion = teclado.nextInt();

        while (opcion != 9) {
            switch (opcion){
                case 1:
                    System.out.println(saldoActualizado + saldo);
                    break;
                case 2:
                    System.out.println("¿Cuál es el valor que desea retirar?");
                    double retira = teclado.nextDouble();
                    if(retira <= 0) {
                        System.out.println(error);
                        break;
                    }
                    if( retira > saldo){
                        System.out.println("Saldo insuficiente");
                    } else {
                        saldo -= retira;
                        System.out.println(saldoActualizado + saldo);
                    }
                    break;
                case 3:
                    System.out.println("¿Cuanto desea depositar?");
                    double depositar = teclado.nextDouble();
                    if (depositar > 0 ) {
                        saldo += depositar;
                        System.out.println(saldoActualizado + saldo);
                    } else {
                        System.out.println(error);
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
            System.out.println(menu);
            opcion = teclado.nextInt();
        }
        System.out.println("Finalizando sistema, muchas gracias por usar nuestro servicio");
    }
}