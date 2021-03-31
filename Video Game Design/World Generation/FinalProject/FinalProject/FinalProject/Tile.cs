using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace FinalProject
{
    class Tile
    {
        private Rectangle rec;
        private Color col;
        private Texture2D tex;
        private String type;
        private Boolean unitOnTile;

        public Tile(Rectangle r,  Texture2D squareTex)
        {
            rec = r;
            col = new Color(115, 115, 155);
            tex = squareTex;
            type = "Plains";
            unitOnTile = false;
        }

        public Texture2D getTex()
        {
            return tex;
        }

        public Rectangle getRec()
        {
            return rec;
        }

        public Color getColor()
        {
            return col;
        }

        public String getType()
        {
            return type;
        }

        public Boolean getUnitOnTile()
        {
            return unitOnTile;
        }

        public void setColor(Color c)
        {
            col = c;
        }

        public void setUnitOnTile(Boolean b)
        {
            unitOnTile = b;
        }
    }
}
