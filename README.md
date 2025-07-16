📱 Device Fingerprint Demo App
This is a demonstration Android application that generates a unique device fingerprint by collecting a variety of system and hardware attributes. The goal is to showcase how device identifiers and environmental data can be hashed to produce a consistent but anonymized fingerprint.

🔍Features
Collects device-specific properties such as:

Android ID

Build information

Screen resolution and density

Supported ABIs

Locale and timezone

App version

System uptime and boot time

Combines all data into a single string

Applies SHA-256 hashing to produce a privacy-preserving fingerprint

Displays all information neatly in the UI for debugging or analysis

⚠️ Disclaimer
This app is for educational and demonstration purposes only.
Using certain device identifiers (like Android ID) in production apps may violate Google Play policies unless used for valid security or fraud prevention reasons.
No data is transmitted or stored externally.


🛠️ Tech Stack
Kotlin

Android SDK

Jetpack (AppCompat)

SHA-256 via java.security.MessageDigest


📸 Screenshots
<img width="1024" height="1536" alt="ChatGPT Image Jul 16, 2025, 11_43_35 AM" src="https://github.com/user-attachments/assets/26f1e93c-42bd-43a6-a126-04d895b0a0e6" />
