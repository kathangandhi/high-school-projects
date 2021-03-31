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

namespace Space_Invaders_Part_1
{
    class Alien
    {
        public Texture2D tex;
        public Rectangle rec;
        public Rectangle sourceRec1, sourceRec2, display;
        public static int speed;

        public Alien()
        {
            tex = null;
            rec = new Rectangle(0, 0, 0, 0);
            sourceRec1 = new Rectangle(0, 0, 50, 38);
            sourceRec2 = new Rectangle(51, 0, 50, 38);
            display = sourceRec1;
        }

        public Alien(Texture2D t, Rectangle r)
        {
            tex = t;
            rec = r;
            sourceRec1 = new Rectangle(0, 0, 50, 38);
            sourceRec2 = new Rectangle(51, 0, 50, 38);
            display = sourceRec1;
        }

        public void Update()
        {
            rec.X += speed;
            if (display == sourceRec1)
                display = sourceRec2;
            else
                display = sourceRec1;
        }

        public void MoveDown()
        {
            rec.Y += 40;
        }

        public void Draw(SpriteBatch s)
        {
            s.Draw(tex, rec, display, Color.White);
        }

        public static void setSpeed(int s)
        {
            speed = s;
        }
    }
}
