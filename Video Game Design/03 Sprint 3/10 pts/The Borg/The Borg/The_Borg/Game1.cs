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

namespace The_Borg
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        KeyboardState oldKB;
        SpriteFont font;
        int timer;

        Rectangle turretRec, upTubeRec, downTubeRec, leftTubeRec, rightTubeRec, torpedoRec, shipRec;
        Texture2D turretTex, tubeTallTex, tubeSideTex, torpedoTex, shipTex;
        Boolean fire;
        int charge, tubeIndex, size, random, shipTimer, shipPos;

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
            tubeIndex = 0;
            fire = false;
            charge = 0;
            timer = 0;
            size = 0;
            random = 0;
            shipTimer = 0;
            shipPos = 0;

            turretRec = new Rectangle(350, 175, 100, 50);
            upTubeRec = new Rectangle(390, 140, 20, 40);
            downTubeRec = new Rectangle(390, 220, 20, 40);
            leftTubeRec = new Rectangle(315, 195, 40, 20);
            rightTubeRec = new Rectangle(445, 195, 40, 20);

            torpedoRec = new Rectangle(1000, 1000, 10, 10);
            shipRec = new Rectangle(1000, 1000, 75, 100);

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
            turretTex = this.Content.Load<Texture2D>("white");
            tubeTallTex = this.Content.Load<Texture2D>("tube vertical");
            tubeSideTex = this.Content.Load<Texture2D>("tube horizontal");
            torpedoTex = this.Content.Load<Texture2D>("ball");
            shipTex = this.Content.Load<Texture2D>("rocket");
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
            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed
                || kb.IsKeyDown(Keys.Escape))
                this.Exit();

            // TODO: Add your update logic here
            timer++;
            if (timer % 60 == 0 && charge < 98)
                charge += 3;

            Random r = new Random();
            if (random == 0)
            {
                random = r.Next(0, 4);
                shipTimer = r.Next(61, 660);

                shipRec = new Rectangle(1000, 1000, 75, 100);
                shipPos = r.Next(150, 250);
                if (random == 0)
                {
                    shipRec.Y = upTubeRec.Y - shipPos;
                    shipRec.X = upTubeRec.X;
                }

                if (random == 1)
                {
                    shipRec.X = upTubeRec.X + shipPos;
                    shipRec.Y = upTubeRec.Y;
                }

                if (random == 2)
                {
                    shipRec.Y = upTubeRec.Y + shipPos;
                    shipRec.X = upTubeRec.X;
                }

                if (random == 3)
                {
                    shipRec.X = upTubeRec.X - shipPos;
                    shipRec.Y = upTubeRec.Y;
                }
            }

            shipTimer--;
            if(shipTimer == 0)
            {
                random = 0;       
            }

            if (kb.IsKeyDown(Keys.NumPad1) && !oldKB.IsKeyDown(Keys.NumPad1) && charge >= 1)
            {
                size = 1;
                charge--;
            }
            else if (kb.IsKeyDown(Keys.NumPad2) && !oldKB.IsKeyDown(Keys.NumPad2) && charge >= 2)
            {
                size = 2;
                charge -= 2;
            }
            else if (kb.IsKeyDown(Keys.NumPad3) && !oldKB.IsKeyDown(Keys.NumPad3) && charge >= 3)
            {
                size = 3;
                charge -= 3;
            }
            else if (kb.IsKeyDown(Keys.NumPad4) && !oldKB.IsKeyDown(Keys.NumPad4) && charge >= 4)
            {
                size = 4;
                charge -= 4;
            }
            else if (kb.IsKeyDown(Keys.NumPad5) && !oldKB.IsKeyDown(Keys.NumPad5) && charge >= 5)
            {
                size = 5;
                charge -= 5;
            }
            else if (kb.IsKeyDown(Keys.NumPad6) && !oldKB.IsKeyDown(Keys.NumPad6) && charge >= 6)
            {
                size = 6;
                charge -= 6;
            }
            else if (kb.IsKeyDown(Keys.NumPad7) && !oldKB.IsKeyDown(Keys.NumPad7) && charge >= 7)
            {
                size = 7;
                charge -= 7;
            }
            else if (kb.IsKeyDown(Keys.NumPad8) && !oldKB.IsKeyDown(Keys.NumPad8) && charge >= 8)
            {
                size = 8;
                charge -= 8;
            }
            else if (kb.IsKeyDown(Keys.NumPad9) && !oldKB.IsKeyDown(Keys.NumPad9) && charge >= 9)
            {
                size = 9;
                charge -= 9;
            }

            if (!fire)
            {
                if (kb.IsKeyDown(Keys.Up) && !oldKB.IsKeyDown(Keys.Up))
                {
                    tubeIndex = 0;
                    torpedoRec = new Rectangle(395 - size, 130 - size, 10 + size, 10 + size);
                }

                if (kb.IsKeyDown(Keys.Right) && !oldKB.IsKeyDown(Keys.Right))
                {
                    tubeIndex = 1;
                    torpedoRec = new Rectangle(485 - size, 200 - size, 10 + size, 10 + size);
                }

                if (kb.IsKeyDown(Keys.Down) && !oldKB.IsKeyDown(Keys.Down))
                {
                    tubeIndex = 2;
                    torpedoRec = new Rectangle(395 - size, 260 - size, 10 + size, 10 + size);
                }

                if (kb.IsKeyDown(Keys.Left) && !oldKB.IsKeyDown(Keys.Left))
                {
                    tubeIndex = 3;
                    torpedoRec = new Rectangle(305 - size, 200 - size, 10 + size, 10 + size);
                }
            }

            if (kb.IsKeyDown(Keys.Space) && !oldKB.IsKeyDown(Keys.Space))
            {
                fire = true;

                if (tubeIndex == 0)
                {
                    torpedoRec = new Rectangle(395 - size, 130 - size, 10 + size, 10 + size);
                }

                if (tubeIndex == 1)
                {
                    torpedoRec = new Rectangle(485 - size, 200 - size, 10 + size, 10 + size);
                }

                if (tubeIndex == 2)
                {
                    torpedoRec = new Rectangle(395 - size, 260 - size, 10 + size, 10 + size);
                }

                if (tubeIndex == 3)
                {
                    torpedoRec = new Rectangle(305 - size, 200 - size, 10 + size, 10 + size);
                }

                size = 0;
            }
                

            if (fire && tubeIndex == 0)
                torpedoRec.Y--;
            else if (fire && tubeIndex == 1)
                torpedoRec.X++;
            else if (fire && tubeIndex == 2)
                torpedoRec.Y++;
            else if (fire && tubeIndex == 3)
                torpedoRec.X--;

            if (torpedoRec.X < 0 || torpedoRec.X > GraphicsDevice.Viewport.Width ||
                torpedoRec.Y < 0 || torpedoRec.Y > GraphicsDevice.Viewport.Height)
                fire = false;

            oldKB = kb;
            base.Update(gameTime);
        }

        /// <summary>
        /// This is called when the game should draw itself.
        /// </summary>
        /// <param name="gameTime">Provides a snapshot of timing values.</param>
        protected override void Draw(GameTime gameTime)
        {
            GraphicsDevice.Clear(Color.White);

            // TODO: Add your drawing code here
            spriteBatch.Begin();
            if (fire)
                spriteBatch.Draw(torpedoTex, torpedoRec, Color.White);
            if(shipTimer <= 60)
                spriteBatch.Draw(shipTex, shipRec, Color.White);
            spriteBatch.Draw(turretTex, turretRec, Color.Black);
            spriteBatch.Draw(tubeTallTex, upTubeRec, Color.White);
            spriteBatch.Draw(tubeTallTex, downTubeRec, Color.White);
            spriteBatch.Draw(tubeSideTex, leftTubeRec, Color.White);
            spriteBatch.Draw(tubeSideTex, rightTubeRec, Color.White);

            if(tubeIndex == 0)
            {
                spriteBatch.Draw(tubeTallTex, upTubeRec, Color.Green);
            }
            if (tubeIndex == 1)
            {
                spriteBatch.Draw(tubeSideTex, rightTubeRec, Color.Green);
            }
            if (tubeIndex == 2)
            {
                spriteBatch.Draw(tubeTallTex, downTubeRec, Color.Green);
            }
            if (tubeIndex == 3)
            {
                spriteBatch.Draw(tubeSideTex, leftTubeRec, Color.Green);
            }

            if (tubeIndex == 0 && fire)
            {
                spriteBatch.Draw(tubeTallTex, upTubeRec, Color.Red);
            }
            if (tubeIndex == 1 && fire)
            {
                spriteBatch.Draw(tubeSideTex, rightTubeRec, Color.Red);
            }
            if (tubeIndex == 2 && fire)
            {
                spriteBatch.Draw(tubeTallTex, downTubeRec, Color.Red);
            }
            if (tubeIndex == 3 && fire)
            {
                spriteBatch.Draw(tubeSideTex, leftTubeRec, Color.Red);
            }

            spriteBatch.DrawString(font, "" + charge, new Vector2(390, 190), Color.Red);

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
