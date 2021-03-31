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

namespace War
{
    class Card
    {
        public Texture2D face;
        public int value;
        public String suit;

        public Card()
        {
            face = null;
            value = 0;
            suit = "";
        }

        public Card(Texture2D f, int val, String s)
        {
            face = f;
            value = val;
            suit = s;
        }

        public void Draw(SpriteBatch sb, Rectangle cardRec)
        {
            sb.Draw(face, cardRec, Color.White);
        }
    }
}
