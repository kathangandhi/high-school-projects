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

namespace You_ve_Been_Targeted
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        SpriteFont font;
        MouseState oldMouse;

        Vector2 tank, bullet;
        Rectangle tankRec, bulletRec;
        Texture2D tankTex, bulletTex;

        double bulletX, bulletY;
        float tankRot, bulletRot;
        double dx, dy;

        public Game1()
        {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";

            IsMouseVisible = true;
        }

        /// <summary>
        /// Allows the game to perform any initialization it needs to before starting to run.
        /// This is where it can query for any required services and load any non-graphic
        /// related content.  Calling base.Initialize will enumerate through any components
        /// and initialize them as well.
        /// </summary>
        protected override void Initialize()
        {
            // TODO: Add your initialization logic here
            oldMouse = Mouse.GetState();

            tankRec = new Rectangle(GraphicsDevice.Viewport.Width / 2, GraphicsDevice.Viewport.Height / 2, 100, 100);
            bulletRec = new Rectangle(GraphicsDevice.Viewport.Width / 2, GraphicsDevice.Viewport.Height / 2, 25, 25);
            bulletX = bulletRec.X;
            bulletY = bulletRec.Y;

            tankRot = 0;
            bulletRot = 0;

            dx = 0;
            dy = 0;

            base.Initialize();
        }

        /// <summary>
        /// LoadContent will be called once per game and is the place to load
        /// all of your content.
        /// </summary>
        protected override void LoadContent()
        {
            // Create a new SpriteBatch, which can be used to draw textures.
            spriteBatch = new SpriteBatch(GraphicsDevice);
            font = this.Content.Load<SpriteFont>("SpriteFont1");

            // TODO: use this.Content to load your game content here
            tankTex = this.Content.Load<Texture2D>("Tank");
            bulletTex = this.Content.Load<Texture2D>("White Square");

            tank = new Vector2(tankTex.Width / 2, tankTex.Height / 2);
            bullet = new Vector2(bulletTex.Width / 2, bulletTex.Height / 2);
        }

        /// <summary>
        /// UnloadContent will be called once per game and is the place to unload
        /// all content.
        /// </summary>
        protected override void UnloadContent()
        {
            // TODO: Unload any non ContentManager content here
        }

        /// <summary>
        /// Allows the game to run logic such as updating the world,
        /// checking for collisions, gathering input, and playing audio.
        /// </summary>
        /// <param name="gameTime">Provides a snapshot of timing values.</param>
        protected override void Update(GameTime gameTime)
        {
            MouseState mouse = Mouse.GetState();
            
            // Allows the game to exit
            if (mouse.RightButton == ButtonState.Pressed && !(mouse.RightButton == ButtonState.Pressed))
                this.Exit();

            double xChange = (double) (mouse.X - GraphicsDevice.Viewport.Width / 2);
            double yChange = (double) (mouse.Y - GraphicsDevice.Viewport.Height / 2);

            tankRot = (float) Math.Atan2(yChange, xChange);

            if(mouse.LeftButton == ButtonState.Pressed && !(oldMouse.LeftButton == ButtonState.Pressed))
            {
                bulletRec = new Rectangle(GraphicsDevice.Viewport.Width / 2, GraphicsDevice.Viewport.Height / 2, 25, 25);
                bulletRot = tankRot % 90;
                bulletX = bulletRec.X;
                bulletY = bulletRec.Y;

                double hypot = Math.Sqrt(Math.Pow(xChange, 2) + Math.Pow(yChange, 2));

                double desiredSpeed = 4.0;
                double numUpdates = hypot / desiredSpeed;

                dx = xChange / numUpdates;
                dy = yChange / numUpdates;
            }

            bulletX += dx;
            bulletY += dy;

            bulletRec.X = (int)bulletX;
            bulletRec.Y = (int)bulletY;

            // TODO: Add your update logic here

            oldMouse = mouse;

            base.Update(gameTime);
        }

        /// <summary>
        /// This is called when the game should draw itself.
        /// </summary>
        /// <param name="gameTime">Provides a snapshot of timing values.</param>
        protected override void Draw(GameTime gameTime)
        {
            GraphicsDevice.Clear(Color.CornflowerBlue);

            // TODO: Add your drawing code here
            spriteBatch.Begin();
            spriteBatch.Draw(bulletTex, bulletRec, null, Color.Black, bulletRot, bullet, SpriteEffects.None, 0);
            spriteBatch.Draw(tankTex, tankRec, null, Color.White, tankRot, tank, SpriteEffects.None, 0);
            spriteBatch.DrawString(font, "" + dx, new Vector2(700, 25), Color.White);
            spriteBatch.DrawString(font, "" + dy, new Vector2(700, 75), Color.White);
            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
