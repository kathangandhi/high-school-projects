using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Audio;
using Microsoft.Xna.Framework.Content;
using Microsoft.Xna.Framework.GamerServices;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;
using Microsoft.Xna.Framework.Media;

namespace Dungeon_Crawl
{
    class Tile
    {
        Rectangle rec;
        Texture2D tex;

        public Tile(Rectangle r, Texture2D t)
        {
            rec = r;
            tex = t;
        }

        public void Draw(SpriteBatch sb)
        {
            sb.Draw(tex, rec, Color.White);
        }
    }
}
