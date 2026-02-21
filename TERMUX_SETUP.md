# 🐙 Molti Mobile - Termux Setup

Anleitung zur Installation von Molti/OpenClaw auf Android via Termux.

## 📱 Voraussetzungen

- Android Smartphone mit **Termux** App (aus F-Droid oder Play Store)
- GitHub Account (für Code)
- Internetverbindung

---

## 🚀 Schnell-Installation

```bash
# Repository clonen
git clone https://github.com/Dpdpdpdp0987/MoltiAndroid.git
cd MoltiAndroid

# Install-Script ausführen
bash install_termux.sh
```

---

## 📋 Manueller Setup (Schritt für Schritt)

### 1. Termux Basis-Pakete

```bash
# Pakete updaten
pkg update && pkg upgrade -y

# Basis-Pakete installieren
pkg install git curl wget python nodejs
```

### 2. OpenClaw installieren

```bash
# OpenClaw clonen
cd ~
git clone https://github.com/openclaw/openclaw.git
cd openclaw

# Dependencies installieren
npm install
```

### 3. Konfiguration

Erstelle eine `openclaw.json` im openclaw-Ordner:

```json
{
  "defaultModel": "free-minimax",
  "telegram": {
    "enabled": true,
    "botToken": "DEIN_BOT_TOKEN"
  }
}
```

### 4. OpenClaw starten

```bash
cd ~/openclaw
npm start
```

---

## 🎯 Modelle (alle FREE!)

| Modell | Befehl | Beschreibung |
|--------|--------|--------------|
| MiniMax | `/model free-minimax` | Empfohlen! |
| Kimi | `/model free-kimi` | Sehr gut! |
| Qwen | `/model free-qwen` | Coder-freundlich |
| DeepSeek | `/model free-deepseek` | Stark bei Reasoning |

---

## 🔗 Verbindung zu Molti (Server)

### Option A: Telegram (einfach)
1. Erstelle einen Bot bei @BotFather
2. Kopiere den Token
3. Füge ihn in openclaw.json ein
4. Starte OpenClaw und spreche mit dem Bot

### Option B: Direkte Server-Verbindung
Trage in openclaw.json ein:
```json
{
  "gatewayUrl": "https://deine-server-ip:3000"
}
```

---

## 🆘 Troubleshooting

**Problem:** npm start bleibt hängen
→ Lösung: `npm run start:detached` oder Screen nutzen

**Problem:** Keine Verbindung zum Server
→ Firewall checken, gleiches WLAN nutzen

**Problem:** Modell antwortet nicht
→ anderes freies Modell probieren mit `/model free-kimi`

---

## 📱 Tägliche Nutzung

```bash
# OpenClaw starten
cd ~/openclaw && npm start

# Modell wechseln
/model free-minimax

# Status
/status
```

---

## 🔄 Auto-Start einrichten

```bash
# In Termux:
termux-setup-storage
echo "cd ~/openclaw && npm start" >> ~/.bashrc
```

---

## 📦 Mit Molti Server verbinden

Wenn du dich mit MEINEM Server verbinden möchtest, frag mich nach dem Link! 🐙
