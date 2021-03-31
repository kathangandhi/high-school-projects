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

namespace Huff_N_Puff
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        SpriteFont font;
        KeyboardState oldKB;
        int timer;

        Rectangle bobRec, featherRec;
        Rectangle[] bobSources, featherSources;
        Texture2D sheetTex;

        bool left;
        int currentBob;
        int featherState;
        bool gameOver;

        Random featherX;
        int featherTimer;

        int score;

        public Game1()
        {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";

            this.Window.AllowUserResizing = true;
            IsMouseVisible = true;

            graphics.PreferredBackBufferWidth = 1425;
            graphics.PreferredBackBufferHeight = 750;
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
            oldKB = Keyboard.GetState();
            timer = 0;

            bobRec = new Rectangle(GraphicsDevice.Viewport.Width / 2 - 24, GraphicsDevice.Viewport.Height - 68, 48, 68);
            featherRec = new Rectangle(GraphicsDevice.Viewport.Width / 2 - 12, 500, 24, 24);

            bobSources = new Rectangle[10];
            featherSources = new Rectangle[4];

            for (int i = 0; i < 10; i++)
            {
                bobSources[i] = new Rectangle(i % 5 * 25, i / 5 * 35, 24, 34);
            }

            for (int i = 0; i < 4; i++)
            {
                featherSources[i] = new Rectangle(i * 25, 70, 24, 24);
            }

            left = true;
            currentBob = 0;
            featherState = 0;
            gameOver = false;

            featherX = new Random();
            featherTimer = 0;

            score = 0;

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
            font = this.Content.Load<SpriteFont>("SpriteFont1");

            sheetTex = this.Content.Load<Texture2D>("HuffNPuff");
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
            if (kb.IsKeyDown(Keys.Escape) && !oldKB.IsKeyDown(Keys.Escape))
                this.Exit();

            // TODO: Add your update logic here
            timer++;

            if (!gameOver)
            {
                if (timer % 5 == 0)
                {
                    if (kb.IsKeyDown(Keys.Left) && !left)
                    {
                        currentBob = 0;
                        left = true;
                    }
                    else if (kb.IsKeyDown(Keys.Left))
                    {
                        bobRec.X -= 5;
                        currentBob = (currentBob + 1) % 4;
                        left = true;
                    }

                    if (kb.IsKeyDown(Keys.Right) && left)
                    {
                        currentBob = 5;
                        left = false;
                    }
                    else if (kb.IsKeyDown(Keys.Right))
                    {
                        bobRec.X += 5;
                        currentBob = ((currentBob - 5) + 1) % 4 + 5;
                        left = false;
                    }

                    if (kb.IsKeyDown(Keys.Space))
                    {
                        if (left)
                            currentBob = 4;
                        else
                            currentBob = 9;

                        if (bobRec.Intersects(featherRec))
                        {
                            score++;
                            featherTimer = 30;
                        }
                    }

                    if (featherTimer > 0)
                    {
                        featherRec.Y -= 5;
                        featherRec.X += featherX.Next(-15, 15);
                        featherState = (featherState + 1) % 4;
                        featherTimer--;
                    }
                    else
                    {
                        featherRec.Y += 3;
                        featherRec.X += featherX.Next(-3, 3);
                        featherState = (featherState + 1) % 4;
                    }

                    if (featherRec.Y + featherRec.Height >= GraphicsDevice.Viewport.Height)
                        gameOver = true;
                }
            }

            if (kb.IsKeyDown(Keys.R))
            {
                gameOver = false;
                Initialize();
                LoadContent();
            }
                

            oldKB = kb;

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
            spriteBatch.Draw(sheetTex, bobRec, bobSources[currentBob], Color.White);
            spriteBatch.Draw(sheetTex, featherRec, featherSources[featherState], Color.White);
            spriteBatch.DrawString(font, "Score: " + score, new Vector2(1200, 25), Color.White);

            if (gameOver)
                spriteBatch.DrawString(font, "Game Over! Press R to refresh", new Vector2(GraphicsDevice.Viewport.Width / 2 - 150, GraphicsDevice.Viewport.Height/2 - 25), Color.White);

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
