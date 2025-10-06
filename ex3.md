# 🔐 Práctica RSA con OpenSSL

Este documento sirve como **guía práctica paso a paso** para realizar el ejercicio RSA con claves reales usando `openssl`.  
Incluye **espacios editables** para que completes tus valores (claves, mensajes, resultados).

---

## 🧩 Parte (a) — Generación de la clave privada RSA

### 1️⃣ Generar la clave privada
```bash
openssl genpkey -algorithm RSA -out private.pem -pkeyopt rsa_keygen_bits:2048
```

📄 Archivo generado: `private.pem`

---

### 2️⃣ Extraer los valores de la clave (p, q, n, e)
```bash
openssl rsa -in private.pem -text -noout
```

✏️ **Anota los valores en decimal (usa `bc` para convertirlos si es necesario):**

| Parámetro | Valor (Decimal) |
|------------|----------------|
| p (prime1) | |
| q (prime2) | |
| n (modulus = p × q) | |
| e (exponente público) | |

---

## 🧩 Parte (b) — Generar clave pública y cifrar mensaje

### 1️⃣ Generar la clave pública a partir de la privada
```bash
openssl rsa -in private.pem -pubout -out public.pem
```

📄 Archivo generado: `public.pem`

---

### 2️⃣ Compartir la clave pública con tu compañero

🔁 Envía tu archivo `public.pem`  
🔁 Recibe la clave pública de tu compañero: `public_compañero.pem`

---

### 3️⃣ Crear un mensaje de texto y cifrarlo con la clave pública recibida
```bash
echo "Escribe tu mensaje aquí" > mensaje.txt
openssl pkeyutl -encrypt -pubin -inkey public_compañero.pem -in mensaje.txt -out mensaje.enc -pkeyopt rsa_padding_mode:oaep
```

📄 Archivo cifrado: `mensaje.enc` (binario)

✏️ **Mensaje original:**  
```
(pón aquí tu texto original)
```

✏️ **Archivo cifrado (hex/base64 si deseas visualizar):**  
```
(base64 mensaje.enc)
```

---

## 🧩 Parte (c) — Descifrar el mensaje recibido

📥 Archivo recibido de tu compañero: `mensaje_recibido.enc`

```bash
openssl pkeyutl -decrypt -inkey private.pem -in mensaje_recibido.enc -out mensaje_descifrado.txt
cat mensaje_descifrado.txt
```

✏️ **Mensaje descifrado recibido:**  
```
(pón aquí el texto descifrado)
```

---

## 🧮 Verificación

✏️ **Comprobación matemática:**  
```
n = p × q = 
φ(n) = (p - 1)(q - 1) = 
d = inverso de e mod φ(n) = 
```

✏️ **Verificación de congruencia:**  
```
m^(e*d) ≡ m mod n → (se cumple / no se cumple)
```

---

## ⚙️ Resumen final

| Concepto | Valor / Archivo |
|-----------|-----------------|
| Clave privada | `private.pem` |
| Clave pública propia | `public.pem` |
| Clave pública del compañero | `public_compañero.pem` |
| Mensaje enviado | `mensaje.txt` |
| Mensaje cifrado enviado | `mensaje.enc` |
| Mensaje recibido cifrado | `mensaje_recibido.enc` |
| Mensaje descifrado | `mensaje_descifrado.txt` |

---

## 🧠 Notas adicionales

- Usa `base64 mensaje.enc > mensaje.enc.b64` si quieres enviar el mensaje cifrado como texto.  
- Nunca compartas `private.pem`.  
- Si recibes errores de permisos, usa:
  ```bash
  chmod 600 private.pem
  sudo chown $(whoami):$(whoami) private.pem
  ```
- El padding OAEP es más seguro que PKCS#1 v1.5.

---

✍️ **Alumno:**  
✍️ **Fecha:**  
✍️ **Profesor / Asignatura:**  
