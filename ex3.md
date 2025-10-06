# 🔐 Práctica RSA con OpenSSL

Este documento sirve como **guía práctica paso a paso** para realizar el ejercicio RSA con claves reales usando `openssl`.  
Incluye **espacios editables** para que completes tus valores (claves, mensajes, resultados).

---

## 🧩 Parte (a) — Generación de la clave privada RSA

### 1️⃣ Generar la clave privada
```bash
openssl genpkey -algorithm RSA -out private.pem -pkeyopt rsa_keygen_bits:2048
```

📄 Archivo generado: `private.pem`:
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
 **Valores sin convertir:**

```
Private-Key: (2048 bit, 2 primes)

modulus (n - módulo):
    00:a1:b9:b6:41:50:20:62:d8:f4:3e:d8:87:c4:4f:
    55:aa:b4:eb:e2:bf:a7:a9:17:7e:bb:7a:a3:1a:ee:
    8a:d3:ca:d5:cb:27:96:ed:70:71:e7:0b:b0:26:ab:
    cc:aa:27:17:ea:57:c5:72:4e:cc:7f:1d:73:b2:fb:
    69:32:72:96:40:a9:0d:d8:62:e4:17:11:a6:dc:fd:
    ee:c1:9c:a5:0d:85:42:77:16:75:88:cc:9a:ca:12:
    b9:fd:79:03:53:c5:97:eb:6a:f0:97:11:84:52:97:
    25:c5:4d:be:b6:90:7f:d0:77:a4:27:71:c4:cc:e0:
    a3:8e:18:21:b7:a6:01:f7:34:7f:02:e8:08:f1:fc:
    a4:d2:2b:9f:1a:ce:38:34:8c:40:8f:55:00:79:7d:
    3b:23:d9:45:aa:e0:52:27:df:94:d1:e7:63:04:d1:
    ad:1f:74:a6:a3:91:80:bc:92:4b:8b:7a:7c:1a:22:
    3f:63:ff:64:c0:43:ee:01:8f:49:41:3b:69:87:2f:
    dd:9d:cb:f8:ec:64:e6:82:2b:75:77:9c:0f:c0:8d:
    18:f0:a0:4e:67:33:5e:2d:c6:b6:05:1c:ef:33:8a:
    07:33:37:b1:72:e0:44:bd:3c:a1:0d:70:a2:77:58:
    33:1c:84:78:2e:47:38:4f:d9:0e:b8:e1:5e:01:5f:
    50:85

publicExponent (e - exponente público): 65537 (0x10001)

privateExponent (d - exponente privado):
    2b:c0:43:63:78:eb:42:02:82:54:ec:1c:12:8a:09:
    d9:64:17:7a:60:b1:d9:47:3f:64:35:a1:a1:5c:0e:
    17:8c:c4:78:b0:ad:9e:6f:70:88:fa:3a:fd:c3:35:
    5b:84:b6:ee:11:2f:9b:a4:60:a3:34:d3:03:85:0b:
    28:f8:21:d8:bd:43:3f:1a:45:ad:4d:fb:af:c6:4c:
    8c:79:35:97:aa:48:d8:51:ad:9b:44:0a:ce:06:f1:
    e4:f6:13:65:da:cb:26:07:68:ad:dd:b1:c7:ec:16:
    ee:41:01:8a:7f:1d:ec:c6:29:14:f8:ac:ae:66:49:
    28:dc:33:66:ec:d4:94:4c:e3:c5:bb:b5:c7:d5:fc:
    ec:ed:81:16:b7:90:86:da:f3:a6:58:ea:da:b9:24:
    b8:49:bb:5e:94:33:a2:ed:d5:17:24:16:4d:85:a5:
    b1:97:51:c8:67:98:b1:23:29:74:60:23:1f:e4:ea:
    05:f8:c0:02:d6:8c:4e:0a:a0:d8:7a:ee:42:c0:d4:
    86:74:6d:b0:25:3c:f9:9e:3b:02:62:1d:ca:e7:ab:
    ae:79:77:f5:93:cd:43:fb:37:cf:a3:61:84:ad:ca:
    2b:1e:3c:b2:e5:fd:ef:0d:6d:c4:8e:54:e2:cf:e0:
    54:a3:db:f5:2a:fe:56:dd:0d:10:b6:eb:07:83:55:
    93

prime1 (p - primer primo):
    00:ca:e8:8a:50:a9:05:c6:e7:7c:e1:4c:9f:42:27:
    ca:b0:1a:d1:f1:fb:12:ee:92:cc:c4:98:ab:6c:11:
    ac:89:80:20:cf:ef:bf:5a:09:4b:d7:1a:ff:c0:6f:
    0c:3a:b0:63:78:01:42:09:1d:39:8b:f1:f8:ea:43:
    15:2c:0a:81:d1:dc:94:b7:7e:b8:46:87:23:7e:bd:
    d9:96:39:cc:73:61:32:ee:2e:5b:eb:b8:85:ef:75:
    b3:8e:e6:47:5f:5f:cf:ff:57:99:12:e5:5c:e4:66:
    ca:fa:84:ea:21:3e:ed:14:5d:69:85:48:28:fe:35:
    33:16:41:bf:89:4d:cc:fb:7f

prime2 (q - segundo primo):
    00:cc:0a:9b:1f:56:45:fd:6e:78:64:59:ee:5e:fb:
    11:81:c4:20:f7:d8:08:40:1d:1f:d4:2b:e8:4b:af:
    b3:fe:49:d6:b9:c1:93:db:09:17:7c:46:14:19:8a:
    7e:d0:e7:6d:48:77:64:f3:ef:e8:e9:ab:68:33:90:
    bf:bd:db:0b:e2:9f:fc:15:21:2a:00:dd:46:78:c5:
    68:31:76:c1:e5:f4:52:74:8a:87:94:4d:51:3b:b1:
    a9:fe:ba:94:7b:66:e4:d6:83:62:08:f9:9c:0e:2b:
    b2:da:76:d2:4d:e3:0c:ce:ee:fb:a2:cf:b9:3b:57:
    38:ef:13:77:3a:62:24:c5:fb

exponent1 (d mod (p-1)):
    3f:3f:ff:a5:a7:1a:7a:e7:3c:01:4b:0e:35:e4:0b:
    85:9b:c6:a8:04:98:e1:2f:77:8f:2c:fb:fa:a3:03:
    c2:94:e3:25:8e:59:7a:aa:7d:2e:9f:66:eb:c8:71:
    ea:75:83:7c:2c:00:36:b1:1a:78:2a:44:6a:59:e0:
    e6:aa:9b:cf:1c:50:6b:66:9f:f0:b4:3d:77:4b:9c:
    e0:fc:41:64:11:ff:7b:49:8e:33:cb:80:4c:a5:c7:
    04:1b:7a:52:1b:9e:cd:bc:b3:a5:b5:43:a0:9a:fe:
    58:db:47:d4:77:36:15:ec:0c:71:94:8d:da:b8:20:
    a5:a6:77:1b:48:da:45:e7

exponent2 (d mod (q-1)):
    28:57:d8:80:03:b0:e7:01:16:b0:d0:cf:3e:dc:69:
    83:bc:e1:bf:df:69:12:34:2f:fc:e5:89:92:9d:74:
    fb:4c:62:36:6c:3d:ed:cb:08:67:bb:fb:71:69:5e:
    d5:b3:4c:7a:4d:91:1a:62:4f:2d:14:85:0f:dd:08:
    ec:63:09:20:8f:fd:69:b8:1a:f3:fc:cc:58:48:bf:
    e7:37:d1:f2:c3:b2:21:f4:da:05:ca:9b:cb:2f:bf:
    aa:eb:fd:3b:c1:06:72:1b:9c:20:a6:29:e2:eb:64:
    fb:a9:0e:bf:f3:aa:ae:a7:b5:fd:65:10:fc:d8:ac:
    1b:29:40:23:bd:10:04:4d

coefficient ((inverso de q) mod p):
    18:49:d5:35:3c:8a:f7:08:b7:e9:0f:8d:75:16:42:
    7b:21:f8:bd:e2:fe:8f:e3:18:99:52:b3:86:16:0e:
    0f:f0:7f:0b:11:fe:f0:df:d9:d7:59:e4:0d:84:6c:
    72:d6:37:07:4f:5e:8e:dd:30:93:b0:51:81:11:b8:
    a8:cf:65:3d:e1:b4:fb:97:e1:b3:1d:e6:96:b2:0e:
    4f:c7:54:b8:19:bf:f3:89:a5:bb:8e:53:4a:ca:25:
    38:db:ee:75:a4:be:f4:06:b1:cb:a2:7e:de:09:de:
    27:1a:29:4e:e6:80:38:74:c1:b3:84:94:c9:48:72:
    1c:f4:2a:fc:1f:19:6d:b1
```

✏️ **Anota los valores en decimal (usa `bc` para convertirlos si es necesario):**
```
# Extraer el módulo (n) en decimal
openssl rsa -in private.pem -text -noout | grep -A 10 "modulus"
```

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
