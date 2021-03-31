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

namespace DeathBlossom
{
    class Missile
    {
        public Vector2 missileCenter;
        public Texture2D missileTex;
        public double X, Y, heading, xSpeed, ySpeed;

        public Missile(Vector2 mr, Texture2D mt, double h)
        {
            missileCenter = mr;
            missileTex = mt;
            X = missileCenter.X;
            Y = missileCenter.Y;

            heading = h;
            xSpeed = Math.Sin(heading) * 4;
            ySpeed = Math.Cos(heading) * 4; 
        }

        public void Update(GameTime gameTime)
        {
            X += xSpeed;
            Y -= ySpeed;

            missileCenter.X = (int)X;
            missileCenter.Y = (int)Y;
        }

        public void Draw(SpriteBatch spriteBatch, GameTime gameTime)
        {
            spriteBatch.Draw(missileTex, missileCenter, null, Color.White, 
                (float)heading, 
                new Vector2(missileTex.Width / 2, missileTex.Height / 2), 
                0.2f, SpriteEffects.None, 0f);  
        }
    }
}
