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
    class Ship : Microsoft.Xna.Framework.Game
    {
        Texture2D texture;
        Rectangle rect;
        Rectangle source;
        int screenWidth;
        int timer;

        List<Missile> missiles;

        public Ship(Texture2D t, Rectangle r, Rectangle s, int sW)
        {
            texture = t;
            rect = r;
            source = s;
            screenWidth = sW;
            missiles = new List<Missile>();
            timer = 0;
        }

        public void movement()
        {
            KeyboardState kb = Keyboard.GetState();
            
            if (kb.IsKeyDown(Keys.Left) && rect.X > 5)
            {
                rect.X -= 5;
            }
            if (kb.IsKeyDown(Keys.Right) && rect.X + rect.Width < screenWidth)
            {
                rect.X += 5;
            }
            if (kb.IsKeyDown(Keys.Space) && timer <= 0)
            {
                missiles.Add(new Missile(texture, new Rectangle(rect.X + rect.Width / 5 , rect.Y, 10, 40), new Rectangle(40, 230, 20, 100), true));
                timer = 30;
            }
        }


        public void Draw(SpriteBatch spriteBatch)
        {
            timer--;
            movement();
            for (int i = missiles.Count - 1; i >= 0; i--)
            {
                missiles.ElementAt(i).update();
                missiles.ElementAt(i).Draw(spriteBatch);

                if (missiles.ElementAt(i).rect.Y < 0)
                    missiles.RemoveAt(i);
            }
            spriteBatch.Draw(texture, rect, source, Color.White);
        }
        




    }
}
