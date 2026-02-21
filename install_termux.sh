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
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Check if we're in Termux
if [ ! -f "/data/data/com.termux/files/usr/bin/pkg" ]; then
    echo -e "${YELLOW}⚠️  Dies scheint kein Termux zu sein!${NC}"
    echo "Dieses Script ist nur für Termux auf Android."
    exit 1
fi

echo -e "${GREEN}[1/6]${NC} Pakete updaten..."
pkg update && pkg upgrade -y

echo -e "${GREEN}[2/6]${NC} Basis-Pakete installieren..."
pkg install git curl wget python nodejs

echo -e "${GREEN}[3/6]${NC} OpenClaw clonen..."
cd ~
git clone https://github.com/openclaw/openclaw.git
cd openclaw

echo -e "${GREEN}[4/6]${NC} Dependencies installieren..."
npm install

echo -e "${GREEN}[5/6]${NC} Modelle installieren..."
# Free Models werden bei Bedarf automatisch geladen

echo -e "${GREEN}[6/6]${NC} OpenClaw konfigurieren..."
echo ""

# Create config with connection to Molti server
cat > openclaw.json << 'EOF'
{
  "defaultModel": "free-minimax",
  "gatewayUrl": "https://DEIN-SERVER-URL:3000",
  "telegram": {
    "enabled": true
  },
  "mcp": {
    "enabled": false
  }
}
EOF

echo ""
echo "============================================"
echo -e "${GREEN}✅ FERTIG!${NC}"
echo "============================================"
echo ""
echo -e "${BLUE}📱 Nächste Schritte:${NC}"
echo ""
echo "1. Server URL eintragen:"
echo "   Bearbeite openclaw.json und trage DEINE Server-URL ein"
echo ""
echo "2. OpenClaw starten:"
echo "   cd ~/openclaw && npm start"
echo ""
echo "3. Modell wählen:"
echo "   free-minimax, free-kimi, free-qwen, free-deepseek"
echo ""
echo "4. Mit Telegram verbinden:"
echo "   Bot Token von @BotFather eintragen"
echo ""
echo -e "${YELLOW}💡 Tipp: ${NC}Du kannst auch ohne Server direkt auf dem Handy laufen!"
echo ""
echo "🐙Viel Spaß mit Molti Mobile! 📱"
