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

namespace Star_Field
{

    class Star
    {
        public Texture2D starTex;
        public Rectangle starRec;
        public Color col;
        public int xVel, yVel;

        public Star()
        {
            starTex = null;
            starRec = new Rectangle(0, 0, 0, 0);
            col = Color.White;
            xVel = 0;
            yVel = 0;
        }

        public Star(Texture2D tex, Rectangle r, Color c, int xv, int yv)
        {
            starTex = tex;
            starRec = r;
            col = c;
            xVel = xv;
            yVel = yv;
        }

        public void Update()
        {
            starRec.X += xVel;
            starRec.Y += yVel;
        }
    }
}
