# 🐙 Molti Android App

Ein persönlicher KI-Assistent für Android - ähnlich wie Siri/Alexa, aber persönlicher.

## ✨ Features

- 💬 **Chat** - Natürliche Konversation mit dem KI-Assistenten
- 📅 **Kalender** - Google Kalender Integration
- ✅ **Aufgaben** - To-Do Listen Management
- 📝 **Notizen** - Notizen und Erinnerungen
- 🧠 **Langzeitgedächtnis** - Personalisierung über Zeit
- 🌙 **Dark Mode** - Automatischer Dark Mode

## 🏗️ Architektur

- **Kotlin** mit Jetpack Compose
- **MVVM** Architecture
- **Hilt** für Dependency Injection
- **Room** für lokale Datenbank
- **Retrofit** für API Calls
- **Material Design 3**

## 📱 Screens

1. **Home** - Übersicht & Quick Actions
2. **Chat** - Hauptkonversation mit Molti
3. **Calendar** - Kalenderansicht
4. **Tasks** - Aufgabenverwaltung
5. **Settings** - Einstellungen

## 🚀 Setup

### Voraussetzungen
- Android Studio (Arctic Fox oder neuer)
- JDK 17
- Android SDK 34

### Installation

```bash
# Repository klonen
git clone https://github.com/Dpdpdpdp0987/MoltiAndroid.git
cd MoltiAndroid

# Projekt in Android Studio öffnen
# Build > Rebuild Project
# Run > Run 'app'
```

### API Keys konfigurieren

Erstelle `local.properties`:
```properties
# Google Calendar API
googleCalendar.apiKey=YOUR_API_KEY

# OpenAI / KI Backend
openai.apiKey=YOUR_API_KEY
```

## 📂 Projektstruktur

```
app/
├── src/main/
│   ├── java/com/molti/app/
│   │   ├── di/                 # Hilt Modules
│   │   ├── data/
│   │   │   ├── local/          # Room Database
│   │   │   ├── remote/         # API Services
│   │   │   └── repository/     # Repositories
│   │   ├── domain/
│   │   │   ├── model/          # Domain Models
│   │   │   └── usecase/       # Use Cases
│   │   ├── ui/
│   │   │   ├── theme/          # Compose Theme
│   │   │   ├── components/     # UI Components
│   │   │   └── screens/        # App Screens
│   │   └── MoltiApp.kt         # Application Class
│   └── res/
│       ├── values/             # Strings, Colors
│       └── drawable/           # Icons
```

## 🎨 Design

- **Primärfarbe:** Purple (#6750A4)
- **Sekundärfarbe:** Teal (#03DAC6)
- **Octopus Theme:** Freundlich und einladend

## 📄 Lizenz

MIT License

---

*Entwickelt für Daniela mit ❤️ von Molti 🐙*
