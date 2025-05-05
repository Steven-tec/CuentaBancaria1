package com.steven.cuentabancaria;

import java.util.Scanner;

// Main
public class Main {

    public static void main(String[] args) {

        // Crear objeto Scanner para leer entradas del usuario
        Scanner scanner = new Scanner(System.in);

        // variable float para saldo y tasa de interés
        float saldo, tasa;
        CuentaBancaria cuenta;
        int opcion;

        // Solicitar datos iniciales al usuario
        System.out.print("Ingrese el saldo inicial: ");
        saldo = scanner.nextFloat();

        System.out.print("Ingrese la tasa de interés anual (%): ");
        tasa = scanner.nextFloat();

        // Bucle para asegurarse de que se elige un tipo de cuenta válido
        do {
            System.out.println("\nSeleccione el tipo de cuenta:");
            System.out.println("1. Ahorros");
            System.out.println("2. Corriente");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cuenta = new CuentaAhorros(saldo, tasa);
                    break;
                case 2:
                    cuenta = new CuentaCorriente(saldo, tasa);
                    break;
                default:
                    System.out.println("Ingrese un número válido (1 o 2).");
                    cuenta = null;
            }

        } while (cuenta == null);

        // Bucle principal del menú para realizar operaciones con la cuenta
        int eleccion;
        do {
            System.out.println("\n========= MENÚ PRINCIPAL =========");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Calcular interés mensual");
            System.out.println("4. Generar extracto mensual");
            System.out.println("5. Imprimir información");
            System.out.println("0. Salir");
            System.out.println("==================================");
            System.out.print("Seleccione una opción: ");

            eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1:
                    System.out.print("Cantidad a depositar: ");
                    cuenta.depositar(scanner.nextFloat());
                    break;
                case 2:
                    System.out.print("Cantidad a retirar: ");
                    cuenta.retirar(scanner.nextFloat());
                    break;
                case 3:
                    cuenta.calcularInteresMensual();
                    break;
                case 4:
                    cuenta.extractoMensual();
                    break;
                case 5:
                    cuenta.imprimir();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema bancario.");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente nuevamente.");
            }

        } while (eleccion != 0);
    }
}
