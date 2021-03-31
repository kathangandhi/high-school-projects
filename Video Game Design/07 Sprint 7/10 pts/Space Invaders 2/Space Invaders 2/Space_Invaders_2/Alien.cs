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

namespace Space_Invaders_2
{
    class Alien
    {
        public Rectangle loc;
        public Texture2D image;

        public Alien(Rectangle l, Texture2D i)
        {
            loc = l;
            image = i;
        }

        public void Update(bool down, int d)
        {
            if(down)
            {
                MoveDown(d);
            }
            else
            {
                MoveSide(d);
            }
        }

        private void MoveDown(int d)
        {
            loc.Y += d;
        }

        private void MoveSide(int d)
        {
            loc.X += d;
        }

        public void Draw(SpriteBatch s)
        {
            s.Draw(image, loc, Color.White);
        }
    }
}
