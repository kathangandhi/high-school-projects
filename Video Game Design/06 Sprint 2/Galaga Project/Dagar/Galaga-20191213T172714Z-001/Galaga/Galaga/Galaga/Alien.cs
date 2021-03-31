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
    class Alien
    {
        private Texture2D text;
        private int score;
        public Rectangle rect;
        private bool destroyed;
        private Rectangle source;
        public Vector2 finalPos;
        public float angle;
        public double x;
        public double y;
        public int circleTime;

        public List<Missile> missiles;

        public Alien()
        {
            text = null;
            score = 0;
            rect = new Rectangle(0,0,0,0);
            destroyed = false;

            missiles = new List<Missile>();
        }

        public Alien(Texture2D t, int s, Rectangle r)
        {
            text = t;
            score = 0;
            rect = r;
            destroyed = false;
        }

        public Alien(Texture2D t, int s, Rectangle r, Rectangle so)
        {
            text = t;
            score = 0;
            rect = r;
            destroyed = false;
            source = so;
        }

        public int getScore()
        {
            return score;
        }

        public bool checkDestroyed()
        {
            return destroyed;
        }

        public Texture2D getText()
        {
            return text;
        }

        public void changeText(Texture2D t)
        {
            text = t;
        }

        public Rectangle getDest()
        {
            return rect;
        }

        public Rectangle getSource()
        {
            return source;
        }
    }
}
