# Proyecto PSP: Comunicación entre procesos en Java

Este repositorio contiene dos clases Java (`Grep` y `Lanzador`) que demuestran cómo ejecutar procesos externos desde Java y comunicarse con ellos mediante flujos de entrada y salida. El ejemplo utiliza el comando `grep` para filtrar líneas que contienen la palabra "psp", ignorando mayúsculas y minúsculas.

## Descripción de las clases

### Grep.java

- Ejecuta el comando `grep -i psp` como proceso hijo.
- Envía un conjunto de líneas de texto al proceso mediante su flujo de entrada.
- Lee la salida del proceso y muestra las líneas que contienen la palabra "psp".

### Lanzador.java

- Realiza la misma operación que `Grep.java`, pero incluye mejoras:
  - Añade un prefijo a cada línea recibida del proceso hijo.
  - Espera a que el proceso hijo finalice y muestra su código de salida.
  - Captura posibles errores durante la espera del proceso.

## Requisitos

- Java instalado en el sistema.
- Sistema operativo compatible con el comando `grep` (Linux, macOS o Windows con Git Bash).

## Compilación y ejecución

```bash
javac Grep.java Lanzador.java
java es.etg.psp.mangel.Grep
java es.etg.psp.mangel.Lanzador
https://github.com/MiguelPrieto98/Grep/tree/main

- basado en parte en el codigo de ejemplo de grep de los apuntes 
