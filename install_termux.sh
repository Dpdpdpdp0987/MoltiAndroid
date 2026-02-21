#!/bin/bash
# Molti Mobile - Termux Install Script
# Für Daniela 🐙

echo "============================================"
echo "  🐙 MOLTI MOBILE - TERMUX SETUP"
echo "============================================"
echo ""

# Colors
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${GREEN}[1/5]${NC} Pakete updaten..."
pkg update && pkg upgrade -y

echo -e "${GREEN}[2/5]${NC} Basis-Pakete installieren..."
pkg install git curl wget python nodejs

echo -e "${GREEN}[3/5]${NC} OpenClaw clonen..."
cd ~
git clone https://github.com/openclaw/openclaw.git
cd openclaw

echo -e "${GREEN}[4/5]${NC} Dependencies installieren..."
npm install

echo -e "${GREEN}[5/5]${NC} OpenClaw konfigurieren..."
echo ""

# Create basic config
cat > openclaw.json << 'EOF'
{
  "defaultModel": "free-minimax",
  "telegram": {
    "enabled": true
  }
}
EOF

echo ""
echo "============================================"
echo -e "${GREEN}✅ FERTIG!${NC}"
echo "============================================"
echo ""
echo "Nächste Schritte:"
echo "1. Starte OpenClaw: cd ~/openclaw && npm start"
echo "2. Wähle dein Modell (free-minimax empfohlen)"
echo "3. Verbinde mit Telegram"
echo ""
echo "Viel Spaß mit Molti Mobile! 🐙📱"
