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

namespace Space_Invaders_2
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        SoundEffect song;

        Alien[,] group;
        Texture2D[,] groupTex;
        int timer, speed;
        bool turn;

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
            group = new Alien[4, 2];
            groupTex = new Texture2D[4, 2];
            timer = 0;
            speed = -80;
            turn = false;

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

            song = Content.Load<SoundEffect>("SI Homeworld");
            song.Play();

            // TODO: use this.Content to load your game content here
            groupTex[0, 0] = Content.Load<Texture2D>("Space Invaders 1st");
            groupTex[0, 1] = Content.Load<Texture2D>("Space Invaders 2nd");
            groupTex[1, 0] = Content.Load<Texture2D>("Space Invaders 3rd");
            groupTex[1, 1] = Content.Load<Texture2D>("Space Invaders 4th");
            groupTex[2, 0] = Content.Load<Texture2D>("Space Invaders 5th");
            groupTex[2, 1] = Content.Load<Texture2D>("Space Invaders 6th");
            groupTex[3, 0] = Content.Load<Texture2D>("Space Invaders 7th");
            groupTex[3, 1] = Content.Load<Texture2D>("Space Invaders 8th");

            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    group[i, j] = new Alien(new Rectangle(360 + i * 80, j * 60, 80, 60), groupTex[i, j]);
                }
            }
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
            timer++;

            // Allows the game to exit
            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed)
                this.Exit();

            // TODO: Add your update logic here
            if (timer % 60 == 0)
            {
                if (group[3, 1].loc.Y > 480)
                {
                    this.Initialize();
                }
                else if (turn)
                {
                    for (int i = 0; i < 4; i++)
                    {
                        for (int j = 0; j < 2; j++)
                        {
                            group[i, j].Update(false, speed);
                        }
                    }

                    turn = false;
                }
                else if (group[0, 0].loc.X <= 40 || group[3, 1].loc.Right >= 760)
                {
                    for (int i = 0; i < 4; i++)
                    {
                        for (int j = 0; j < 2; j++)
                        {
                            group[i, j].Update(true, 60);
                        }
                    }

                    speed = -1 * speed;
                    turn = true;
                }
                else
                {
                    for (int i = 0; i < 4; i++)
                    {
                        for (int j = 0; j < 2; j++)
                        {
                            group[i, j].Update(false, speed);
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
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    group[i, j].Draw(spriteBatch);
                }
            }
            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
