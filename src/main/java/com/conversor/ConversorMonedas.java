package com.conversor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;

public class ConversorMonedas {

    private static final String API_KEY = "42718f3546f20791bd022ea5";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("******************************************************");
        System.out.println("Bienvenido al Conversor de Monedas");

        // Mostrar menú hasta que el usuario elija salir
        do {
            System.out.println("\nElija una opción válida:");
            System.out.println("1. Dólar a Peso Argentino");
            System.out.println("2. Peso Argentino a Dólar");
            System.out.println("3. Dólar a Real Brasileño");
            System.out.println("4. Real Brasileño a Dólar");
            System.out.println("5. Dólar a Peso Colombiano");
            System.out.println("6. Peso Colombiano a Dólar");
            System.out.println("7. Dólar a Soles Peruanos");
            System.out.println("8. Soles Peruanos a Dólar");
            System.out.println("9. Salir");
            System.out.println("Por favor, elija una opción válida:");
            System.out.println("******************************************************");

            opcion = scanner.nextInt();

            // Solicitar la cantidad a convertir si la opción no es salir
            if (opcion >= 1 && opcion <= 8) {
                System.out.println("Introduce la cantidad a convertir:");
                double cantidad = scanner.nextDouble();

                switch (opcion) {
                    case 1:
                        realizarConversion("USD", "ARS", cantidad);
                        break;
                    case 2:
                        realizarConversion("ARS", "USD", cantidad);
                        break;
                    case 3:
                        realizarConversion("USD", "BRL", cantidad);
                        break;
                    case 4:
                        realizarConversion("BRL", "USD", cantidad);
                        break;
                    case 5:
                        realizarConversion("USD", "COP", cantidad);
                        break;
                    case 6:
                        realizarConversion("COP", "USD", cantidad);
                        break;
                    case 7:
                        realizarConversion("USD", "PEN", cantidad);
                        break;
                    case 8:
                        realizarConversion("PEN", "USD", cantidad);
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            }

        } while (opcion != 9);  // Salir cuando elija la opción 9

        System.out.println("Gracias por usar el conversor.¡Hasta luego!");
    }

    //Metodo para realizar la conversión
    public static void realizarConversion(String monedaOrigen, String monedaDestino, double cantidad) {
        String urlString = BASE_URL + API_KEY + "/latest/" + monedaOrigen;

        try {
            // Crear la URL y abrir la conexión
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Comprobar si la solicitud fue exitosa
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) { // 200 OK
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                // Cerrar las conexiones
                in.close();
                connection.disconnect();

                // Parsear el JSON de la respuesta
                JsonObject jsonObject = JsonParser.parseString(content.toString()).getAsJsonObject();
                JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

                if (rates.has(monedaDestino)) {
                    double tasaCambio = rates.get(monedaDestino).getAsDouble();
                    double resultado = cantidad * tasaCambio;
                    System.out.println(cantidad + " " + monedaOrigen + " son " + resultado + " " + monedaDestino);
                } else {
                    System.out.println("Moneda destino no válida.");
                }

            } else {
                System.out.println("Error en la solicitud: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
