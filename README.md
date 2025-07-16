# 📱 Device Fingerprint Demo App

This is a demonstration Android application that generates a **device fingerprint** by gathering various hardware, software, and system-level properties. The app then creates a **SHA-256 hash** of these values to produce a unique, privacy-aware identifier.

---

## 🔧 Features

- Collects device properties:
  - Android ID
  - Build fingerprint, brand, model, hardware info
  - Screen resolution and density
  - Locale and timezone
  - Supported ABIs
  - App version (code + name)
  - System uptime and boot time
- Generates a single string combining all the above
- Hashes the string using SHA-256
- Displays all the details and the resulting hash on screen

---

## ⚠️ Disclaimer

This project is for **educational and demonstration purposes only**.  
Using sensitive identifiers (such as `ANDROID_ID`, `Build.FINGERPRINT`, etc.) in production apps should be done **only for security or fraud prevention**, as per [Google Play policy](https://developer.android.com/privacy-and-security/data-usage).

> 🚫 Do **not** use this fingerprinting technique for advertising or tracking users.

## 🛠 Tech Stack

- **Kotlin**
- **Android SDK (API 31+)**
- `MessageDigest` for cryptographic hashing
- Simple XML-based layout (`TextView`)

---

## 📸 Screenshot

> ✅ This screenshot is a **mockup** and contains **made-up data**  
> No real device identifiers are included

<img width="1024" height="1536" alt="ChatGPT Image Jul 16, 2025, 11_43_35 AM" src="https://github.com/user-attachments/assets/26f1e93c-42bd-43a6-a126-04d895b0a0e6" />


