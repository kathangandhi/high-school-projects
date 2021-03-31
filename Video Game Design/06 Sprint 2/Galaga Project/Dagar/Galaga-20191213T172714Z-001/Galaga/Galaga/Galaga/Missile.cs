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

namespace Galaga
{
    class Missile
    {
        public Texture2D texture;
        public Rectangle rect;
        public Rectangle source;

        //true measn missle travels up aka play ship shoot a missle
        //false means missile trael downwards toward player
        bool shootUp;

        public Missile(Texture2D t, Rectangle r, Rectangle s, bool shoot)
        {
            texture = t;
            rect = r;
            source = s;
            shootUp = shoot;
        }


        public void update()
        {
            if (shootUp)
            {
                rect.Y--;
            }
        }

        public void Draw(SpriteBatch spriteBatch)
        {
            spriteBatch.Draw(texture, rect, source, Color.White);
        }
    }
}
