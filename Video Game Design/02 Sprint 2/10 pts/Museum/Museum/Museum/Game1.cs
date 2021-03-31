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

namespace Museum
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;

        Rectangle museumWallRect, paintingRect, marioRect, mario2Rect;
        Texture2D museumWallTexture, paintingTexture, marioTexture, mario2Texture;

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
            museumWallRect = new Rectangle(0, 0, 1000, 500);
            paintingRect = new Rectangle(-75, 230, 150, 160);

            marioRect = new Rectangle(-200, 300, 200, 300);
            mario2Rect = new Rectangle(0, 300, 200, 300);

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
            museumWallTexture = this.Content.Load<Texture2D>("museum wall");
            paintingTexture = this.Content.Load<Texture2D>("painting");

            marioTexture = this.Content.Load<Texture2D>("mario");
            mario2Texture = this.Content.Load<Texture2D>("mario2"); 
        }

        /// <summary>
        /// UnloadContent will be called once per game and is the place to unload
        /// all content.
        /// </summary>
        protected override void UnloadContent()
        {
            mario2Texture = this.Content.Load<Texture2D>("mario hands down");
            marioTexture = this.Content.Load<Texture2D>("mario hands down");
        }

        /// <summary>
        /// Allows the game to run logic such as updating the world,
        /// checking for collisions, gathering input, and playing audio.
        /// </summary>
        /// <param name="gameTime">Provides a snapshot of timing values.</param>
        protected override void Update(GameTime gameTime)
        {
            // Allows the game to exit
            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed)
                this.Exit();

            // TODO: Add your update logic here
            if (marioRect.X < 300)
            {
                marioRect.X++;
                mario2Rect.X++;
                paintingRect.X++;
            }

            base.Update(gameTime);

            if (marioRect.X == 300)
            {
                paintingRect.Y--;
            }

            if (paintingRect.Y == 150)
            {
                UnloadContent();
                marioRect.X++;
                mario2Rect.X++;
            }
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

            spriteBatch.Draw(museumWallTexture, museumWallRect, Color.White);
            spriteBatch.Draw(paintingTexture, paintingRect, Color.White);

            spriteBatch.Draw(marioTexture, marioRect, Color.White);
            spriteBatch.Draw(mario2Texture, mario2Rect, Color.White);
            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
