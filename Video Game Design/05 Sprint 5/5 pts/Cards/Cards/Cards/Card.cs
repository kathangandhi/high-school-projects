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

namespace Cards
{
    class Card
    {
        public Rectangle cardRec;
        public Texture2D face;

        public Card()
        {

        }

        public Card(Texture2D f, Rectangle r)
        {
            face = f;
            cardRec = r;
        }

        public void Draw(SpriteBatch sb)
        {
            sb.Draw(face, cardRec, Color.White);
        }
    }
}
