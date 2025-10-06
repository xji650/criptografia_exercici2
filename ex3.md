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
✏️ **private.pem:**  
```
-----BEGIN PRIVATE KEY-----
MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQChubZBUCBi2PQ+
2IfET1WqtOviv6epF367eqMa7orTytXLJ5btcHHnC7Amq8yqJxfqV8VyTsx/HXOy
+2kycpZAqQ3YYuQXEabc/e7BnKUNhUJ3FnWIzJrKErn9eQNTxZfravCXEYRSlyXF
Tb62kH/Qd6QnccTM4KOOGCG3pgH3NH8C6Ajx/KTSK58azjg0jECPVQB5fTsj2UWq
4FIn35TR52ME0a0fdKajkYC8kkuLenwaIj9j/2TAQ+4Bj0lBO2mHL92dy/jsZOaC
K3V3nA/AjRjwoE5nM14txrYFHO8zigczN7Fy4ES9PKENcKJ3WDMchHguRzhP2Q64
4V4BX1CFAgMBAAECggEAK8BDY3jrQgKCVOwcEooJ2WQXemCx2Uc/ZDWhoVwOF4zE
eLCtnm9wiPo6/cM1W4S27hEvm6RgozTTA4ULKPgh2L1DPxpFrU37r8ZMjHk1l6pI
2FGtm0QKzgbx5PYTZdrLJgdord2xx+wW7kEBin8d7MYpFPisrmZJKNwzZuzUlEzj
xbu1x9X87O2BFreQhtrzpljq2rkkuEm7XpQzou3VFyQWTYWlsZdRyGeYsSMpdGAj
H+TqBfjAAtaMTgqg2HruQsDUhnRtsCU8+Z47AmIdyuerrnl39ZPNQ/s3z6NhhK3K
Kx48suX97w1txI5U4s/gVKPb9Sr+Vt0NELbrB4NVkwKBgQDK6IpQqQXG53zhTJ9C
J8qwGtHx+xLukszEmKtsEayJgCDP779aCUvXGv/Abww6sGN4AUIJHTmL8fjqQxUs
CoHR3JS3frhGhyN+vdmWOcxzYTLuLlvruIXvdbOO5kdfX8//V5kS5VzkZsr6hOoh
Pu0UXWmFSCj+NTMWQb+JTcz7fwKBgQDMCpsfVkX9bnhkWe5e+xGBxCD32AhAHR/U
K+hLr7P+Sda5wZPbCRd8RhQZin7Q521Id2Tz7+jpq2gzkL+92wvin/wVISoA3UZ4
xWgxdsHl9FJ0ioeUTVE7san+upR7ZuTWg2II+ZwOK7LadtJN4wzO7vuiz7k7Vzjv
E3c6YiTF+wKBgD8//6WnGnrnPAFLDjXkC4WbxqgEmOEvd48s+/qjA8KU4yWOWXqq
fS6fZuvIcep1g3wsADaxGngqRGpZ4Oaqm88cUGtmn/C0PXdLnOD8QWQR/3tJjjPL
gEylxwQbelIbns28s6W1Q6Ca/ljbR9R3NhXsDHGUjdq4IKWmdxtI2kXnAoGAKFfY
gAOw5wEWsNDPPtxpg7zhv99pEjQv/OWJkp10+0xiNmw97csIZ7v7cWle1bNMek2R
GmJPLRSFD90I7GMJII/9abga8/zMWEi/5zfR8sOyIfTaBcqbyy+/quv9O8EGchuc
IKYp4utk+6kOv/Oqrqe1/WUQ/NisGylAI70QBE0CgYAYSdU1PIr3CLfpD411FkJ7
Ifi94v6P4xiZUrOGFg4P8H8LEf7w39nXWeQNhGxy1jcHT16O3TCTsFGBEbioz2U9
4bT7l+GzHeaWsg5Px1S4Gb/ziaW7jlNKyiU42+51pL70BrHLon7eCd4nGilO5oA4
dMGzhJTJSHIc9Cr8HxltsQ==
-----END PRIVATE KEY-----
```

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
