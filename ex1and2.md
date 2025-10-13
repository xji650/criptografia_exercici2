# Práctica 2 Ejercicio 1 y 2 - README

Este programa en Java implementa paso a paso el algoritmo **RSA (Rivest–Shamir–Adleman)**, un sistema criptográfico de clave pública.  
Permite al usuario ejecutar un ejemplo predeterminado o introducir sus propios valores para observar el proceso completo de generación de claves, cifrado y descifrado.

---

## Funcionalidades

- Cálculo del máximo común divisor (MCD) mediante el algoritmo de Euclides.  
- Verificación de coprimalidad y cálculo del inverso modular usando el algoritmo extendido de Euclides.  
- Implementación de exponenciación binaria para el cálculo eficiente de potencias modulares.  
- Generación de claves RSA (**p**, **q**, **e**, **d**, **n**, **φ(n)**).  
- Cifrado y descifrado de mensajes.  
- Verificación de la propiedad fundamental RSA: **m^(e*d) ≡ m (mod n)**.

---

## Estructura del código

El programa está dividido en varias secciones principales:

1. **Algoritmos matemáticos básicos:**
   - `mcd(int a, int b)`: Calcula el máximo común divisor.
   - `inversoModular(int a, int m)`: Calcula el inverso modular.
   - `exponenciacionBinaria(long m, long e, long n)`: Calcula `m^e mod n` de forma eficiente.

2. **Interfaz interactiva:**
   - Permite al usuario elegir entre usar un ejemplo predefinido o introducir sus propios valores.
   - Muestra paso a paso el proceso de generación de claves, cifrado y descifrado.

3. **Resultados finales:**
   - Muestra las claves generadas (pública y privada), el mensaje cifrado, el descifrado y la comprobación final.

---

## Ejecución del programa

1. Compilar el archivo Java:
   ```bash
   javac PracticaRSA.java
   ```

2. Ejecutar el programa:
   ```bash
   java PracticaRSA
   ```

3. Seguir las instrucciones interactivas que aparecen en la consola.

---

## Ejemplo de ejecución

Usando el ejemplo del enunciado:

- p = 11  
- q = 17  
- e = 7  
- m = 88  

**Resultados esperados:**

- n = 187  
- φ(n) = 160  
- d = 23 (inverso de 7 mod 160)  
- Mensaje cifrado: 11  
- Mensaje descifrado: 88  
- Propiedad fundamental cumplida: `m^(e*d) ≡ m (mod n)`

---

## Requisitos

- Java JDK 8 o superior  
- Consola o terminal para entrada/salida estándar

---

## Autor

Desarrollado por **XiaoLong y Alex Lillo**  
Materia: Seguridad Informática - Criptografía 
Año: 2025
