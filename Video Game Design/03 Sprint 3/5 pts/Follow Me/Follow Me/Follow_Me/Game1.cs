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

namespace Follow_Me
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        MouseState oldMouse;
        int mouseX, mouseY, xDist, yDist;
        double yUpdate;

        Boolean clicked;
        Rectangle jimboRec;
        Texture2D jimboTex, jimboWalkTex, jimboStandTex;

        public Game1()
        {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";
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
            this.IsMouseVisible = true;
            oldMouse = Mouse.GetState();
            clicked = false;

            mouseX = 0;
            mouseY = 0;
            xDist = 0;
            yDist = 0;
            yUpdate = 0;

            jimboRec = new Rectangle(200, 300, 50, 80);

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

            // TODO: use this.Content to load your game content here
            jimboStandTex = this.Content.Load<Texture2D>("Standing Man");
            jimboWalkTex = this.Content.Load<Texture2D>("Walking Man");
            jimboTex = jimboStandTex;
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
            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed)
                this.Exit();

            // TODO: Add your update logic here
            if (mouse.LeftButton == ButtonState.Pressed
               && oldMouse.LeftButton == ButtonState.Pressed)
            {
                jimboTex = jimboWalkTex;

                xDist = mouse.X - jimboRec.X;
                yDist = mouse.Y - jimboRec.Y;
                double slope = (double) yDist / xDist;

                if (xDist < 0)
                {
                    jimboRec.X--;
                    jimboRec.Y -= (int)slope;
                }
                else if (xDist > 0)
                {
                    jimboRec.X++;
                    jimboRec.Y += (int)slope;
                }

            }
            else if (mouse.LeftButton == ButtonState.Pressed && oldMouse.LeftButton == ButtonState.Released || clicked)
            {
                clicked = true;

                jimboTex = jimboWalkTex;

                xDist = mouse.X - jimboRec.X;
                yDist = mouse.Y - jimboRec.Y;
                double slope = (double) yDist / xDist;

                if (xDist < 0)
                {
                    jimboRec.X--;
                    jimboRec.Y -= (int)slope;
                }
                else if (xDist > 0)
                {
                    jimboRec.X++;
                    jimboRec.Y += (int)slope;
                }

                if (xDist == 0 && yDist == 0)
                    clicked = false;
            }
            else
            {
                jimboTex = jimboStandTex;
            }

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
            spriteBatch.Draw(jimboTex, jimboRec, Color.White);
            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
