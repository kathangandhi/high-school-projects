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

namespace Sidekick
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        Color bigCol, smallCol;

        Rectangle objRec, bigRec, smallRec;
        Texture2D objTex, bigTex, smallTex;

        int bigDir, smallDir;

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
            smallCol = Color.White;
            bigCol = Color.White;

            objRec = new Rectangle(350, 190, 100, 100);
            bigRec = new Rectangle(50, 50, 150, 100);
            smallRec = new Rectangle(150, 350, 50, 50);

            bigDir = 1;
            smallDir = 1;

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
            objTex = this.Content.Load<Texture2D>("StationaryObj");
            bigTex = this.Content.Load<Texture2D>("BigMovingObj");
            smallTex = this.Content.Load<Texture2D>("SmallMovingObj");
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
            // Allows the game to exit
            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed)
                this.Exit();

            // TODO: Add your update logic here
            smallRec.X += 3 * smallDir;
            bigRec.X += bigDir;

            if (smallRec.X > 800)
                smallDir = -1;
            if (smallRec.X < 0)
                smallDir = 1;

            if (bigRec.X > 800)
                bigDir = -1;
            if (bigRec.X < 0)
                bigDir = 1;

            if (bigRec.X + 150 >= 350 && bigRec.X <= 450)
                bigCol = Color.Red;
            else
                bigCol = Color.White;

            if (smallRec.X + 50 >= 350 && smallRec.X <= 450)
                smallCol = Color.Red;
            else
                smallCol = Color.White;

            

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
            spriteBatch.Draw(objTex, objRec, Color.White);
            spriteBatch.Draw(bigTex, bigRec, bigCol);
            spriteBatch.Draw(smallTex, smallRec, smallCol);
            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
