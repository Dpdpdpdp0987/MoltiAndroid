# 🐙 Molti Mobile - Termux Setup

Anleitung zur Installation von Molti/OpenClaw auf Android via Termux.

## 📱 Voraussetzungen

- Android Smartphone mit Termux App
- GitHub Account (für Code)
- Internetverbindung

## 🚀 Installation

### 1. Termux updaten
```bash
pkg update && pkg upgrade -y
```

### 2. Basis-Pakete installieren
```bash
pkg install git curl wget python nodejs
```

### 3. Node.js Version checken (min. 18+)
```bash
node -v
# Falls alt: pkg install nodejs-lts
```

### 4. OpenClaw installieren
```bash
# Clone OpenClaw
git clone https://github.com/openclaw/openclaw.git
cd openclaw

# Dependencies installieren
npm install

# OpenClaw starten
npm start
```

### 5. Modell auswählen (FREE!)

Beim ersten Start wähle ein freies Modell:
- **MiniMax Free** (empfohlen)
- **Kimi Free**
- **Qwen Free**
- **DeepSeek Free**

## 🔗 Verbindung zu Molti (Server)

### Option A: Telegram Bot (einfach)
1. Erstelle einen Telegram Bot @BotFather
2. Trage den Token in OpenClaw ein
3. Verbinde mit demselben Telegram Account wie auf dem Server

### Option B: Direkte Verbindung (Server-IP)
Trage in der config die Server-URL ein:
```json
{
  "gatewayUrl": "https://deine-server-ip:3000"
}
```

## 🎯 Modelle (alle FREE)

In OpenClaw config (openclaw.json):
```json
{
  "defaultModel": "free-minimax",
  "availableModels": [
    "free-minimax",
    "free-kimi", 
    "free-qwen",
    "free-deepseek"
  ]
}
```

## 📱 Täglicher Gebrauch

```bash
# OpenClaw starten
cd openclaw && npm start

# Modell wechseln
/model free-minimax

# Status
/status
```

## 🔧 Für Fortgeschrittene

### Autostart bei Termux-Start
```bash
# In Termux:
termux-setup-storage
echo "cd ~/openclaw && npm start" >> ~/.bashrc
```

### Cron Jobs auf Handy
```bash
# Einfache Erinnerungen
crontab -e
# 0 9 * * * termux-notification "Molti" "Guten Morgen!"
```

## 🐛 Troubleshooting

**Problem:** npm start bleibt hängen
→ Lösung: `npm run start: detached` oder Screen nutzen

**Problem:** Keine Verbindung zum Server
→ Firewall checken, gleiches WLAN nutzen

**Problem:** Modell antwortet nicht
→ anderes freies Modell probieren

---

## 📞 Hilfe

Bei Fragen: Frag mich (Molti)!

---

*Erstellt für Daniela mit ❤️*
