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

namespace Space_Invaders_Part_1
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        int timer;

        Alien[] aliens;

        public Game1()
        {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";

            Window.AllowUserResizing = true;
            IsMouseVisible = true;

            graphics.PreferredBackBufferWidth = 1000;
            graphics.PreferredBackBufferHeight = 800;
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
            timer = 0;

            aliens = new Alien[10];

            for(int i = 0; i < 10; i++)
            {
                aliens[i] = new Alien(Content.Load<Texture2D>("Space Invaders SS #1"), new Rectangle(400 + 50 * i, 25, 50, 38));
                Alien.setSpeed(-50);
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

            timer++;

            // TODO: Add your update logic here
            if(timer % 20 == 0)
            {
                for(int i = 0; i < 10; i++)
                {
                    aliens[i].Update();
                }

                if (aliens[0].rec.X < 50)
                {
                    if(aliens[0].rec.Y < 700)
                    {
                        Alien.setSpeed(50);

                        for (int i = 0; i < 10; i++)
                        {
                            aliens[i].MoveDown();
                            aliens[i].Update();
                        }
                    }
                    else
                    {
                        Alien.setSpeed(50);

                        for (int i = 0; i < 10; i++)
                        {
                            aliens[i].Update();
                        }
                    }
                }

                if (aliens[9].rec.X > 900 )
                {
                    if (aliens[0].rec.Y < 700)
                    {
                        Alien.setSpeed(-50);

                        for (int i = 0; i < 10; i++)
                        {
                            aliens[i].MoveDown();
                            aliens[i].Update();
                        }
                    }
                    else
                    {
                        Alien.setSpeed(-50);

                        for (int i = 0; i < 10; i++)
                        {
                            aliens[i].Update();
                        }
                    }
                }
            }   

            base.Update(gameTime);
        }

        /// <summary>
        /// This is called when the game should draw itself.
        /// </summary>
        /// <param name="gameTime">Provides a snapshot of timing values.</param>
        protected override void Draw(GameTime gameTime)
        {
            GraphicsDevice.Clear(Color.Black);

            spriteBatch.Begin();

            // TODO: Add your drawing code here
            for (int i = 0; i < 10; i++)
            {
                aliens[i].Draw(spriteBatch);
            }

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
