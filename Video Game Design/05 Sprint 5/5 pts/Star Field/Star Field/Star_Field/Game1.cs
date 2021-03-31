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
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;

        Star[] stars;
        Texture2D starTex;

        Random r;

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
            stars = new Star[5];
            r = new Random();

            for(int i = 0; i < 5; i++)
            {
                int x = r.Next(0, 800);
                int y = r.Next(0, 800);

                int sign1 = r.Next(1, 3) * 2 - 3;
                int xv = sign1 * r.Next(1, 5);
                int sign2 = r.Next(1, 3) * 2 - 3;
                int yv = sign2 * r.Next(1, 5);

                Console.WriteLine(sign1 + " " + sign2);

                stars[i] = new Star(starTex, new Rectangle(x, y, 20, 20), Color.White, xv, yv);
            }

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
            starTex = Content.Load<Texture2D>("Star");

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
            KeyboardState kb = Keyboard.GetState();

            // Allows the game to exit
            if (kb.IsKeyDown(Keys.Escape))
                this.Exit();

            // TODO: Add your update logic here

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
            
            for(int i = 0; i < 5; i++)
            {
                spriteBatch.Draw(starTex, stars[i].starRec, Color.White);
                stars[i].Update();

                if(stars[i].starRec.X > 800 || stars[i].starRec.Y > 480 || stars[i].starRec.X < 0 || stars[i].starRec.Y < 0)
                {
                    int x = r.Next(0, 800);
                    int y = r.Next(0, 800);

                    int sign1 = r.Next(1, 3) * 2 - 3;
                    int xv = sign1 * r.Next(1, 5);
                    int sign2 = r.Next(1, 3) * 2 - 3;
                    int yv = sign2 * r.Next(1, 5);

                    stars[i] = new Star(starTex, new Rectangle(x, y, 20, 20), Color.White, xv, yv);
                }
            }

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
