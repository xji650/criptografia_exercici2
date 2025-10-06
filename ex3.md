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

---

### 2️⃣ Extraer los valores de la clave (p, q, n, e)
```bash
openssl rsa -in private.pem -text -noout
```
 **Valores sin convertir:**

```
Private-Key: (2048 bit, 2 primes)

modulus (n - módulo):
   00:ab:d0:f6:d5:7b:55:3a:6a:8c:aa:5e:72:88:ad:
    9a:e2:e3:d1:06:96:d3:6e:45:30:8b:5e:9f:c5:73:
    7a:6e:5e:70:3f:08:de:58:0d:ae:16:f8:24:c9:ea:
    26:3c:4c:e7:10:6c:10:91:c3:82:13:a3:62:38:56:
    fd:55:3e:42:48:ae:1d:2d:2f:da:38:56:bc:29:d9:
    96:02:0d:af:12:66:fd:7d:5f:30:e4:95:53:36:c4:
    4e:d0:f3:f1:e0:25:ed:72:23:b0:7c:2a:1e:fc:09:
    1c:71:d7:1d:36:5c:9b:03:0f:a8:87:69:f3:00:b4:
    10:b1:91:cc:f4:1e:dc:3c:0c:e6:5e:ff:7a:cb:58:
    6c:2a:92:a5:41:af:fb:80:45:db:38:b6:34:1e:cc:
    5e:c0:f4:42:78:2c:c5:1c:74:1b:84:38:2e:26:bf:
    8c:16:28:99:4d:aa:b0:9a:1a:bd:ef:d3:73:b5:5d:
    02:9e:fb:68:0a:ca:53:ad:c2:f8:bf:44:f2:3e:a0:
    42:d9:ad:17:0f:bc:2f:34:e4:60:f9:64:eb:d2:ab:
    ea:cf:05:8b:0b:9e:31:d0:71:83:b4:31:0b:30:ab:
    0d:9b:57:7a:ac:c2:cd:6f:9f:92:20:ae:36:d9:56:
    bd:54:00:bf:68:71:23:99:73:ca:a5:47:8c:e8:bc:
    1e:03

publicExponent (e - exponente público): 65537 (0x10001)

privateExponent (d - exponente privado):
    24:33:32:ce:67:dd:dd:20:f5:e2:2f:64:12:48:01:
    8a:2c:55:ad:fd:b9:2e:52:85:97:d7:a7:f2:02:12:
    99:8e:6c:37:db:b6:7c:f6:e4:e7:12:01:2e:49:97:
    24:bd:4f:31:b6:93:07:23:1a:14:e9:27:98:97:3b:
    68:ea:65:2c:cb:02:7a:b2:ca:57:74:6e:d0:a2:77:
    68:97:59:7b:97:17:71:82:cc:da:5c:5b:db:fe:20:
    5d:06:08:c0:21:3d:95:fe:cf:00:5a:1f:8d:1a:9e:
    53:9d:ef:19:b5:09:33:eb:e8:a6:1f:3c:83:b9:6c:
    8a:fd:1d:21:92:1e:f4:c7:a9:c2:9d:cd:b7:7f:8d:
    51:49:5c:43:e0:02:17:c3:ab:fb:41:67:85:22:7c:
    a7:b5:7d:87:c1:35:96:ee:a2:87:7c:76:b3:f7:c2:
    a9:63:e6:fb:97:56:e1:cf:8e:09:60:72:1a:59:ee:
    fe:c8:2a:2f:1c:19:52:48:99:cb:65:7d:12:90:b4:
    76:1b:ee:97:7c:b3:48:a1:c4:a2:30:a2:19:9c:30:
    ea:af:9c:92:e6:87:43:3a:73:dd:d2:f2:04:d7:5e:
    d9:f0:34:80:c5:2a:0f:b5:9e:d1:6d:64:cb:db:89:
    c2:4d:d3:34:23:c2:4d:ee:70:88:52:1e:32:c6:41:
    01

prime1 (p - primer primo):
    00:f1:53:50:5d:5a:86:51:ba:b9:3c:5e:af:f9:06:
    84:84:36:44:31:21:f2:e0:69:3c:d0:c2:73:e0:99:
    ae:ac:c3:77:0f:17:f8:5d:bf:34:9a:88:8d:5f:38:
    68:a8:74:16:57:30:a5:99:f3:32:17:3c:e1:fe:93:
    3b:4a:29:12:46:56:3d:83:82:81:e4:14:c5:90:9a:
    a7:bb:7a:c6:e7:d3:4a:07:c3:f2:27:e8:4b:78:7a:
    ee:f3:87:f5:de:bc:6a:0c:38:6c:5d:a9:14:09:49:
    d7:34:a8:60:d5:72:be:c8:43:f3:7d:44:49:2d:cf:
    42:05:63:e4:99:c1:e6:60:bb

prime2 (q - segundo primo):
    00:b6:43:9b:d3:c6:99:a7:07:4e:ec:a5:5e:3a:fd:
    5b:39:f5:71:11:fe:bd:93:82:fc:76:cd:c5:fe:76:
    d3:ca:e4:f6:8c:ce:6f:8c:a6:54:b1:5b:3e:ca:d5:
    8f:f9:23:12:54:ae:05:d8:57:b4:62:77:c3:fc:70:
    39:25:2b:1f:d3:82:16:15:89:4b:26:29:53:90:8f:
    c2:c7:3c:f6:55:ae:22:81:ea:23:91:5e:00:11:d9:
    2f:ab:4f:67:ac:29:53:a0:10:78:57:bb:1f:95:c8:
    0c:ea:8a:2b:be:ab:b4:54:9e:e4:38:50:d1:d0:ad:
    b4:06:18:1a:be:da:38:27:59

exponent1 (d mod (p-1)):
    7b:82:ce:90:d8:f2:02:06:75:23:c6:ba:7d:d3:ae:
    23:14:bb:16:02:70:12:17:0a:7f:35:e6:a4:bf:43:
    3d:3c:d5:44:ae:59:f9:71:10:f5:3e:8a:4c:7f:cc:
    60:da:f9:4c:2a:a3:b7:05:57:4f:b9:63:59:2d:f5:
    9c:61:24:ef:46:d8:38:e4:a4:a2:1d:57:78:49:0f:
    2b:cf:0c:da:3d:b3:98:01:db:80:3d:4d:d3:1d:e8:
    0a:50:3d:b0:7f:f2:2e:ca:f9:fb:7d:bb:b9:7d:47:
    5d:b6:07:c9:76:ee:da:04:9d:2c:31:b4:da:73:47:
    31:07:0d:4a:fc:88:72:5d

exponent2 (d mod (q-1)):
    7a:99:41:91:13:0e:b9:c6:75:b5:42:8a:fe:dc:fa:
    e7:22:8c:bb:11:02:0d:de:56:d9:c7:12:3e:57:49:
    a1:39:a0:0a:18:b5:fa:02:cc:07:3c:9c:21:2d:c4:
    19:4e:18:ff:72:cb:25:b9:e0:f1:37:24:52:82:5e:
    3d:fd:22:fc:4f:8d:71:51:17:86:84:d7:db:ee:87:
    93:23:13:83:90:8d:4f:9b:e1:ee:df:2e:e6:d2:93:
    79:05:01:74:51:9c:19:97:da:8b:10:a8:6f:44:d0:
    43:57:4b:93:86:c5:d7:01:c5:fb:87:89:8a:77:bd:
    17:38:51:8d:3d:15:f6:89

coefficient ((inverso de q) mod p):
    68:89:a4:9e:35:a0:ac:f8:a3:bd:82:43:44:a8:54:
    df:19:a9:29:5a:92:46:19:ed:2b:93:25:67:22:9c:
    88:c9:f3:e2:41:c0:ad:f6:da:ba:e1:84:51:4b:1d:
    20:d6:3f:d7:9e:ab:d5:20:cd:c9:8f:cc:cd:8b:d1:
    ef:e9:69:1d:a0:2a:8f:1f:f6:2a:61:2a:1c:60:02:
    b5:12:87:24:4e:87:1b:8e:7a:56:f3:8e:b8:6c:86:
    05:48:77:a2:8e:65:c3:7a:aa:49:42:68:22:23:59:
    16:44:2c:72:a0:37:51:c1:91:d2:29:b4:14:61:a6:
    c1:8d:60:c3:b3:98:88:60
```

✏️ **Anota los valores en decimal (usa `bc` para convertirlos si es necesario):**

```
# Limpiar los hexadecimales del formato PEM (remover ":" y saltos de línea)
n_hex_clean = (
    "00abd0f6d57b553a6a8caa5e7288ad9ae2e3d10696d36e45308b5e9fc5737a6e5e70"
    "3f08de580dae16f824c9ea263c4ce7106c1091c38213a3623856fd553e4248ae1d2d"
    "2fda3856bc29d996020daf1266fd7d5f30e4955336c44ed0f3f1e025ed7223b07c2a"
    "1efc091c71d71d365c9b030fa88769f300b410b191ccf41edc3c0ce65eff7acb586c"
    "2a92a541affb8045db38b6341ecc5ec0f442782cc51c741b84382e26bf8c1628994d"
    "aab09a1abdefd373b55d029efb680aca53adc2f8bf44f23ea042d9ad170fbc2f34e4"
    "60f964ebd2abeacf058b0b9e31d07183b4310b30ab0d9b577aacc2cd6f9f9220ae36"
    "d956bd5400bf6871239973caa5478ce8bc1e03"
)

p_hex_clean = (
    "00f153505d5a8651bab93c5eaff906848436443121f2e0693cd0c273e099aeacc377"
    "0f17f85dbf349a888d5f3868a874165730a599f332173ce1fe933b4a291246563d83"
    "8281e414c5909aa7bb7ac6e7d34a07c3f227e84b787aeef387f5debc6a0c386c5da9"
    "140949d734a860d572bec843f37d44492dcf420563e499c1e660bb"
)

q_hex_clean = (
    "00b6439bd3c699a7074eeca55e3afd5b39f57111febd9382fc76cdc5fe76d3cae4f6"
    "8cce6f8ca654b15b3ecad58ff9231254ae05d857b46277c3fc7039252b1fd3821615"
    "894b262953908fc2c73cf655ae2281ea23915e0011d92fab4f67ac2953a0107857bb"
    "1f95c80cea8a2bbeabb4549ee43850d1d0adb406181abeda382759"
)

# Convertir a enteros
n = int(n_hex_clean, 16)
p = int(p_hex_clean, 16)
q = int(q_hex_clean, 16)
e = 65537

# Imprimir valores
print(f"n = {n}")
print(f"e = {e}")
print(f"p = {p}")
print(f"q = {q}")

# Verificación
print("\nVerificación:")
print(f"p * q = {p * q}")
print(f"n     = {n}")
print(f"¿Coinciden? {p * q == n}")
```

| Parámetro | Valor (Decimal) |
|------------|----------------|
| p (prime1) | 169464490537278974604274420158408910533245594281017437351459749536254495019885412888358714875849348434920948282242097062662836134497375254312439122924462194021015698431615018182501987655391295130691622891894522436830715874839374337096080194709653145707820073651190645177238634596464886851751686894042065821883| 
| q (prime2) | 127990201165309329342973298463855491945868195671855521325942460687445595073783600230032678378562949971938830047249741614960891869301811878188984653988052251736032026273855939515314057000715221904261266982829209014766586997863652455286405215198046577851913396062902054431551713963598435460129824344155048388441| 
| n (modulus = p × q) | 21689794234242995230841210564941249719203478745019459569967407610999872104409860026410246841637860099755411503279555225959387912456225261016555859836521150806686170775708402154867657957614727391589940127216139350149756383224101224631721478049135571625957422975176843309080400045361949254297955820624046144632034309970378005003907304322392968631026785064461322175975846761512653309865262719145807219629802574103401146181023376532343922426751679167039768254477686855688228451942479023551080734892783406732013667882169029608625627814746895129656002102972443711693699968519956452310994035717749005735224349897405302054403| 
| e (exponente público) | 65537| 

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

```
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq9D21XtVOmqMql5yiK2a
4uPRBpbTbkUwi16fxXN6bl5wPwjeWA2uFvgkyeomPEznEGwQkcOCE6NiOFb9VT5C
SK4dLS/aOFa8KdmWAg2vEmb9fV8w5JVTNsRO0PPx4CXtciOwfCoe/AkccdcdNlyb
Aw+oh2nzALQQsZHM9B7cPAzmXv96y1hsKpKlQa/7gEXbOLY0HsxewPRCeCzFHHQb
hDguJr+MFiiZTaqwmhq979NztV0CnvtoCspTrcL4v0TyPqBC2a0XD7wvNORg+WTr
0qvqzwWLC54x0HGDtDELMKsNm1d6rMLNb5+SIK422Va9VAC/aHEjmXPKpUeM6Lwe
AwIDAQAB
-----END PUBLIC KEY-----
```

🔁 Recibe la clave pública de tu compañero: `public_compañero.pem`

```
(pón aquí tu texto original)
```

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
