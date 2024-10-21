# Bienvenido al repositorio del Conversor de Monedas

Este es un proyecto de **conversor de monedas** desarrollado en **Java 17** utilizando **Maven**. El programa permite realizar conversiones entre diversas monedas, como el dólar, peso argentino, real brasileño, peso colombiano y soles peruanos, utilizando una API externa para obtener las tasas de cambio actualizadas.

## Características

- Conversión entre diferentes monedas.
- Acceso a tasas de cambio actualizadas a través de la API [ExchangeRate-API](https://www.exchangerate-api.com/).
- Interfaz interactiva en consola para facilitar la selección de las conversiones.
  
## Monedas disponibles para la conversión

- Dólar (USD)
- Peso Argentino (ARS)
- Real Brasileño (BRL)
- Peso Colombiano (COP)
- Soles Peruanos (PEN)

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

- **Java 17** o superior
- **Maven** para gestionar las dependencias del proyecto

## Instalación

1. Clona el repositorio a tu máquina local:

   ```bash
   git clone https://github.com/tu_usuario/nombre_repositorio.git

## Ejemplo de uso
******************************************************
Bienvenido al Conversor de Monedas

Elija una opción válida:
1. Dólar a Peso Argentino
2. Peso Argentino a Dólar
3. Dólar a Real Brasileño
4. Real Brasileño a Dólar
5. Dólar a Peso Colombiano
6. Peso Colombiano a Dólar
7. Dólar a Soles Peruanos
8. Soles Peruanos a Dólar
9. Salir
Por favor, elija una opción válida:
******************************************************

## API utilizada
Este proyecto utiliza la API de ExchangeRate-API para obtener las tasas de cambio actualizadas. Para utilizar este servicio, debes obtener tu propia clave API y reemplazarla en el código fuente, en la variable API_KEY.

private static final String API_KEY = "tu_clave_api";
