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

namespace Popper
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;

        Rectangle window;
        Texture2D unpoppedTex;
        Texture2D poppedTex;

        List<Rectangle> kernels;
        List<Vector2> velocities;
        List<Texture2D> images;

        int[] timers;
        int genTimer, spawnTime;
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
            int screenWidth = graphics.GraphicsDevice.Viewport.Width;
            int screenHeight = graphics.GraphicsDevice.Viewport.Height;
            window = new Rectangle(0, 0, screenWidth, screenHeight);

            kernels = new List<Rectangle>();
            velocities = new List<Vector2>();
            images = new List<Texture2D>();

            kernels.Add(new Rectangle(70, 50, 15, 15));
            velocities.Add(new Vector2(2, 3));

            kernels.Add(new Rectangle(70, 110, 15, 15));
            velocities.Add(new Vector2(2, 3));

            timers = new int[10];
            genTimer = 0;

            r = new Random();
            spawnTime = r.Next(60, 360);

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
            unpoppedTex = Content.Load<Texture2D>("unpopped");
            poppedTex = Content.Load<Texture2D>("popped");

            images.Add(unpoppedTex);
            images.Add(unpoppedTex);
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

            genTimer++;

            if(genTimer == spawnTime && kernels.Count < 10)
            {
                int x = r.Next(1, window.Width-20);
                int y = r.Next(1, window.Height-20);
                kernels.Add(new Rectangle(x, y, 15, 15));

                int xSpeed = r.Next(1, 5);
                int xDir = r.Next(0, 2);
                int ySpeed = r.Next(1, 5);
                int yDir = r.Next(0, 2);
                velocities.Add(new Vector2((xDir * 2 - 1) * xSpeed, 
                    (yDir * 2 - 1) * ySpeed));

                images.Add(unpoppedTex);

                genTimer = 0;
                spawnTime = r.Next(60, 360);
            }

            for (int i = 0; i < kernels.Count; i++)
            {
                int x = kernels[i].X + (int)velocities[i].X;
                int y = kernels[i].Y + (int)velocities[i].Y;
                kernels[i] = new Rectangle(x, y, kernels[i].Width, kernels[i].Height);

                if (kernels[i].Y + kernels[i].Height >= window.Bottom)
                {
                    velocities[i] = new Vector2(velocities[i].X, velocities[i].Y * -1);
                }
                if (kernels[i].Y <= 0)
                {
                    velocities[i] = new Vector2(velocities[i].X, velocities[i].Y * -1);
                }
                if (kernels[i].X + kernels[i].Width >= window.Right)
                {
                    velocities[i] = new Vector2(velocities[i].X * -1, velocities[i].Y);
                }
                if (kernels[i].X <= 0)
                {
                    velocities[i] = new Vector2(velocities[i].X * -1, velocities[i].Y);
                }

                for(int j = 0; j < kernels.Count; j++)
                {
                    if(i != j)
                    {
                        if (kernels[i].Intersects(kernels[j]) && images[i].Equals(unpoppedTex) && images[j].Equals(unpoppedTex))
                        {
                            images[i] = poppedTex;
                            images[j] = poppedTex;

                            if(timers[i] == 0)
                                timers[i] = 45;

                            if(timers[j] == 0)
                                timers[j] = 45;
                        }
                    }
                }
            }

            for (int i = kernels.Count-1; i >= 0; i--)
            {
                if(timers[i] == 1)
                {
                    kernels.RemoveAt(i);
                    velocities.RemoveAt(i);
                    images.RemoveAt(i);

                    for(int j = i; j <= kernels.Count; j++)
                    {
                        timers[j] = timers[j+1];
                    }
                }

                if(timers[i] >= 1)
                {
                    timers[i]--;
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
            GraphicsDevice.Clear(Color.Beige);

            // TODO: Add your drawing code here
            spriteBatch.Begin();

            for (int i = 0; i < kernels.Count; i++)
            {
                spriteBatch.Draw(images[i], kernels[i], Color.White);
            }
            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
