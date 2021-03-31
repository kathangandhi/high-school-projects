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

namespace Pong
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        SpriteFont font;

        Texture2D spriteTex;
        Rectangle top, bottom, left, right;
        Rectangle ballRect, backgroundRect, paddleLeftRect, paddleRightRect;
        int p1Games, p2Games, p1Score, p2Score;

        Random r;
        double ballSpeedX, ballSpeedY, spin, ballX, ballY, rotation;
        int screenWidth, screenHeight;

        public Game1()
        {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";
            Window.AllowUserResizing = true;
            graphics.PreferredBackBufferWidth = 1450;
            graphics.PreferredBackBufferHeight = 750;

            p1Score = 0;
            p2Score = 0;
            p1Games = 0;
            p2Games = 0;
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
            screenWidth = graphics.GraphicsDevice.Viewport.Width;
            screenHeight = graphics.GraphicsDevice.Viewport.Height;

            top = new Rectangle(0, 0, screenWidth, 5);
            bottom = new Rectangle(0, screenHeight, screenWidth, 20);
            left = new Rectangle(0, 0, 0, screenHeight);
            right = new Rectangle(screenWidth, 0, 0, screenHeight);

            ballRect = new Rectangle(screenWidth / 2 - 10, screenHeight / 2 - 10, 20, 20);
            ballX = (double)ballRect.X;
            ballY = (double)ballRect.Y;
            backgroundRect = new Rectangle(0, 0, screenWidth, screenHeight);
            paddleLeftRect = new Rectangle(18, screenHeight / 2 - 64, 32, 128);
            paddleRightRect = new Rectangle(screenWidth - 50, screenHeight / 2 - 64, 32, 128);

            r = new Random();
            int mag = r.Next(2, 5);
            int sign = r.Next(1, 3);
            ballSpeedX = mag * (2 * sign - 3);
            mag = r.Next(2, 4);
            sign = r.Next(1, 3);
            ballSpeedY = mag * (2 * sign - 3);
            mag = r.Next(1, 4);
            sign = r.Next(1, 3);
            spin = mag * (2 * sign - 3);
            rotation = 0;

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
            font = Content.Load<SpriteFont>("SpriteFont1");

            // TODO: use this.Content to load your game content here
            spriteTex = Content.Load<Texture2D>("Pong Sprite Sheet");
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
            ballX += ballSpeedX;
            ballY += ballSpeedY;

            ballRect.X = (int)ballX;
            ballRect.Y = (int)ballY;
            
            if (ballRect.Intersects(left))
            {
                this.Initialize();
                p2Score++;
            }
            if (ballRect.Intersects(right))
            {
                this.Initialize();
                p1Score++;
            }

            if((p1Score >= 11 || p2Score >= 11) && Math.Abs(p1Score - p2Score) >= 2)
            {
                if(p1Score > p2Score)
                {
                    p1Games++;
                    p1Score = 0;
                    p2Score = 0;
                }

                if (p2Score > p1Score)
                {
                    p2Games++;
                    p1Score = 0;
                    p2Score = 0;
                }
            }

            if (ballRect.Intersects(top))
            {
                ballSpeedY *= -1;
                ballSpeedX += spin / 6.0 * -Math.Abs(ballSpeedX);
                spin *= 0.9;
            }
                
            if (ballRect.Intersects(bottom))
            {
                ballSpeedY *= -1;
                ballSpeedX += spin / 6.0 * Math.Abs(ballSpeedX);
                spin *= 0.9;
            }
                

            if (ballRect.Intersects(paddleLeftRect) || ballRect.Intersects(paddleRightRect))
            {
                ballSpeedX *= -1;

                if (ballRect.Intersects(paddleLeftRect))
                {
                    ballSpeedY += spin / 6.0 * Math.Abs(ballSpeedY);
                    spin *= 0.9;
                }

                if (ballRect.Intersects(paddleRightRect))
                {
                    ballSpeedY += spin / 6.0 * Math.Abs(ballSpeedY);
                    spin *= 0.9;
                }

                if ((ballRect.X < paddleLeftRect.X + paddleLeftRect.Width - 5 && ballRect.X > paddleLeftRect.X + 5) || (ballRect.X + ballRect.Width > paddleRightRect.X + 5 && ballRect.X + ballRect.Width < paddleRightRect.X + paddleRightRect.Width - 5))
                {
                    ballSpeedY *= -1;
                }

                ballX += ballSpeedX * 2;
                ballY += ballSpeedY * 2;
            }

            if (kb.IsKeyDown(Keys.W) && paddleLeftRect.Y > 0)
                paddleLeftRect.Y -= 5;
            if (kb.IsKeyDown(Keys.S) && paddleLeftRect.Y < screenHeight - 128)
                paddleLeftRect.Y += 5;

            if (kb.IsKeyDown(Keys.Up) && paddleRightRect.Y > 0)
                paddleRightRect.Y -= 5;
            if (kb.IsKeyDown(Keys.Down) && paddleRightRect.Y < screenHeight - 128)
                paddleRightRect.Y += 5;

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

            spriteBatch.Draw(spriteTex, backgroundRect, new Rectangle(0, 0, 800, 480), Color.White);
            for (int i = 0; i < 20; i++)
                spriteBatch.Draw(spriteTex, new Rectangle(screenWidth/2 - 8, 10 + i*50, 16, 16), new Rectangle(867, 714, 16, 16), Color.White);
            spriteBatch.Draw(spriteTex, paddleLeftRect, new Rectangle(801, 714, 32, 128), Color.White);
            spriteBatch.Draw(spriteTex, paddleRightRect, new Rectangle(1515, 0, 32, 128), Color.White);

            spriteBatch.DrawString(font, "" + p1Games, new Vector2(10, 20), Color.LightBlue);
            spriteBatch.DrawString(font, "" + p2Games, new Vector2(screenWidth - 25, 20), Color.LightGreen);
            spriteBatch.DrawString(font, "" + p1Score, new Vector2(10, screenHeight - 20), Color.LightBlue);
            spriteBatch.DrawString(font, "" + p2Score, new Vector2(screenWidth - 25, screenHeight - 20), Color.LightGreen);

            rotation += MathHelper.ToRadians(90) * spin;
            spriteBatch.Draw(spriteTex, ballRect, new Rectangle (801, 0, 713, 713), Color.White, (float)rotation, new Vector2(356, 356), SpriteEffects.None, 1f);
            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}