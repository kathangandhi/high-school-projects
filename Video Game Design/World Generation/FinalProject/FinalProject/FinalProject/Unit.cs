using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace FinalProject
{
    class Unit
    {
        private Rectangle rec;
        private Texture2D tex;
        private int level;
        private int attack;
        private int defence;
        private int range;
        private String weapon;
        private Boolean unitFound;

        public Unit(Rectangle r, Texture2D t)
        {
            rec = r;
            tex = t;
            level = 1;
            attack = 3;
            defence = 5;

        }

        public Texture2D getTex()
        {
            return tex;
        }
        public Rectangle getRec()
        {
            return rec;
        }
        public int getAttack()
        {
            return attack;
        }
        public int getDefence()
        {
            return defence;
        }

        public Boolean getFound()
        {
            return unitFound;
        }
        public void setFound(Boolean b)
        {
            unitFound = b;
        }

        public void setLocation(int newX, int newY)
        {
            rec.X = newX;
            rec.Y = newY;
        }

    }
}
