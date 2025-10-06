import java.util.Scanner;

public class PracticaRSA {

    // 1a) Algoritmo de Euclides para MCD
    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 1b) Comprobar si son coprimos y calcular inverso
    public static int[] comprobarCoprimosEInverso(int d, int n) {
        int[] resultado = new int[2];

        if (mcd(d, n) == 1) {
            resultado[0] = 1; // Son coprimos
            resultado[1] = inversoModular(d, n);
        } else {
            resultado[0] = 0; // No son coprimos
            resultado[1] = -1; // No existe inverso
        }
        return resultado;
    }

    // Algoritmo extendido para inverso modular
    public static int inversoModular(int a, int m) {
        int m0 = m;
        int y = 0, x = 1;

        if (m == 1) return 0;

        while (a > 1) {
            int q = a / m;
            int t = m;

            m = a % m;
            a = t;
            t = y;

            y = x - q * y;
            x = t;
        }

        if (x < 0) x += m0;
        return x;
    }

    // 1c) Exponenciación binaria
    public static long exponenciacionBinaria(long m, long e, long n) {
        long resultado = 1;
        m = m % n;

        while (e > 0) {
            if ((e & 1) == 1) {
                resultado = (resultado * m) % n;
            }
            e = e >> 1;
            m = (m * m) % n;
        }
        return resultado;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" PRÁCTICA RSA - VERSIÓN INTERACTIVA");
        System.out.println("=====================================\n");

        System.out.println("¿Quieres usar el ejemplo del enunciado o introducir tus propios valores?");
        System.out.println("1. Usar ejemplo del enunciado (p=11, q=17, e=7, m=88)");
        System.out.println("2. Introducir mis propios valores");
        System.out.print("Elige una opción (1/2): ");

        int opcion = scanner.nextInt();

        int p, q, e, m;

        if (opcion == 1) {
            // Valores del ejemplo
            p = 11;
            q = 17;
            e = 7;
            m = 88;
            System.out.println("\nUsando valores del ejemplo: p=11, q=17, e=7, m=88");
        } else {
            // Valores personalizados
            System.out.println("\nIntroduce los valores:");
            System.out.print("p (número primo): ");
            p = scanner.nextInt();
            System.out.print("q (número primo): ");
            q = scanner.nextInt();
            System.out.print("e (exponente público, coprimo con φ(n)): ");
            e = scanner.nextInt();
            System.out.print("m (mensaje a cifrar, 0 <= m < " + (p*q) + "): ");
            m = scanner.nextInt();
        }

        // Pausa para mostrar cada paso
        System.out.println("\nPresiona Enter para ver cada paso...");
        scanner.nextLine(); // Limpiar buffer
        scanner.nextLine();

        System.out.println("\nPASO 1: Generación de claves");
        System.out.println("-----------------------------");

        // ii) Calcular n
        int n = p * q;
        System.out.println("n = p * q = " + p + " * " + q + " = " + n);
        scanner.nextLine();

        // iii) Calcular φ(n)
        int phi = (p - 1) * (q - 1);
        System.out.println("φ(n) = (p-1)*(q-1) = " + (p-1) + " * " + (q-1) + " = " + phi);
        scanner.nextLine();

        // iv) Verificar e
        System.out.println("e = " + e);
        int gcd = mcd(e, phi);
        System.out.println("gcd(e, φ(n)) = gcd(" + e + ", " + phi + ") = " + gcd);

        if (gcd != 1) {
            System.out.println(" ERROR: e y φ(n) no son coprimos!");
            return;
        } else {
            System.out.println(" e y φ(n) son coprimos");
        }
        scanner.nextLine();

        // v) Calcular d
        int[] resultado = comprobarCoprimosEInverso(e, phi);
        int d = resultado[1];
        System.out.println("d = inverso de e mod φ(n) = " + d);
        System.out.println("Verificación: " + e + " * " + d + " mod " + phi + " = " + (e * d % phi));
        scanner.nextLine();

        // vi) Mostrar claves
        System.out.println("\nCLAVES GENERADAS:");
        System.out.println("Clave pública: (n, e) = (" + n + ", " + e + ")");
        System.out.println("Clave privada: (n, d) = (" + n + ", " + d + ")");
        scanner.nextLine();

        System.out.println("\nPASO 2: Cifrado del mensaje");
        System.out.println("----------------------------");
        System.out.println("Mensaje original m = " + m);
        scanner.nextLine();

        // vii) Cifrar
        long cifrado = exponenciacionBinaria(m, e, n);
        System.out.println("Cifrado: c = m^e mod n = " + m + "^" + e + " mod " + n + " = " + cifrado);
        scanner.nextLine();

        System.out.println("\nPASO 3: Descifrado del mensaje");
        System.out.println("------------------------------");
        System.out.println("Mensaje cifrado c = " + cifrado);
        scanner.nextLine();

        // viii) Descifrar
        long descifrado = exponenciacionBinaria(cifrado, d, n);
        System.out.println("Descifrado: m = c^d mod n = " + cifrado + "^" + d + " mod " + n + " = " + descifrado);
        scanner.nextLine();

        System.out.println("\nRESULTADO FINAL");
        System.out.println("=================");
        System.out.println("Mensaje original: " + m);
        System.out.println("Mensaje descifrado: " + descifrado);
        System.out.println("¿Coinciden? " + (m == descifrado ? " SÍ" : " NO"));

        // Propiedad fundamental
        System.out.println("\nPROPIEDAD FUNDAMENTAL:");
        long propFundamental = exponenciacionBinaria(m, (long)e * d, n);
        System.out.println("m^(e*d) mod n = " + m + "^(" + e + "*" + d + ") mod " + n + " = " + propFundamental);
        System.out.println("¿Se cumple m^(e*d) ≡ m mod n? " + (propFundamental == m % n ? " SÍ" : " NO"));

        scanner.close();
    }
}