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

namespace FinalProject
{
    class Empire
    {
        Rectangle rec;
        Texture2D tex;
        string name;
        public bool conquered
        {
            get { return conquered; }
            set { conquered = value; }
        }

        public Empire(Rectangle r, Texture2D t, string n)
        {
            rec = r;
            tex = t;
            name = n;
        }

        public void Draw(SpriteBatch sb)
        {
            sb.Draw(tex, rec, Color.White);
        }
    }
}
