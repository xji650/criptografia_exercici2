# 🔐 RSA Practice – Exercises Overview

This repository contains implementations and demonstrations of the RSA encryption algorithm as part of the Seguretat d’aplicacions i comunicacions course at **Escola Politècnica Superior – Campus d’Igualada, UdL**.

---

## 📘 Exercises Summary

| Exercise | Description | Link |
|-----------|--------------|------|
| 🧮 **Exercise 1 & 2** | Manual RSA implementation: Euclidean algorithm, modular inverse, and binary modular exponentiation. Includes a step-by-step toy example. | [Open exercise 1 & 2](ex1and2.md) |
| 🔑 **Exercise 3** | RSA encryption/decryption using **OpenSSL** with real 2048-bit keys. Includes key generation, message encryption, and decryption with private keys. | [Open exercise 3](ex3.md) |

---

## 🧩 Structure

```
📁 rsa-practice/
 ┣ 📄 mainREADME.md       # This overview document
 ┣ 📄 PracticaRSA.java    # Exercise 1 Java Code
 ┣ 📄 ex1and2.md          # Exercises 1 & 2 (algorithmic RSA)
 ┗ 📄 ex3.md              # Exercise 3 (OpenSSL RSA)
```

---

## 📄 Summary of Topics

### Exercise 1
- Compute **GCD** using Euclid’s algorithm.  
- Find **modular inverse** via extended Euclidean algorithm.  
- Perform **modular exponentiation** (binary method).

### Exercise 2
- Demonstrate RSA step by step with small primes (p = 11, q = 17).  

### Exercise 3
- Generate **RSA 2048-bit key pair** with OpenSSL.  
- Extract parameters (p, q, n, e).  
- Share and use **public keys** for encryption.  
- Decrypt received messages with your **private key**.  

---

## 🧾 Notes

- All files and examples are compatible with **OpenSSL**.
- Exercises were tested in a Unix-like environment (macOS/Linux).

---

✍️ *Author:* Alex Lillo, XiaoLong Ji

🎓 *Course:* Seguretat d’aplicacions i comunicacions – EPS Igualada , UdL

📅 *Year:* 2025
