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

namespace More_Borg
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        KeyboardState oldKB;
        MouseState oldMouse;
        SpriteFont font;
        int timer;

        Rectangle turretRec, upTubeRec, downTubeRec, leftTubeRec, rightTubeRec, torpedoRec, shipRec, shipTorpedoRec;
        Texture2D turretTex, tubeTallTex, tubeSideTex, torpedoTex, shipTex, powerBarTex;
        Boolean fire;
        int charge, power, tubeIndex, size, random, shipTimer, shipPos;

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
            power = 100;
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
            shipTorpedoRec = new Rectangle(1000, 1000, 10, 10);

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
            powerBarTex = this.Content.Load<Texture2D>("PixelImage");

            this.IsMouseVisible = true;
            oldMouse = Mouse.GetState();
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
            MouseState mouse = Mouse.GetState();

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
                shipTimer = r.Next(80, 200);

                shipRec = new Rectangle(1000, 1000, 75, 100);
                shipPos = r.Next(150, 250);
                if (random == 0)
                {
                    shipRec.Y = upTubeRec.Y - shipPos;
                    shipRec.X = upTubeRec.X - 30;
                    shipTorpedoRec = new Rectangle(shipRec.X, shipRec.Y + 105, 10, 10);
                }

                if (random == 1)
                {
                    shipRec.X = upTubeRec.X + shipPos;
                    shipRec.Y = upTubeRec.Y;
                    shipTorpedoRec = new Rectangle(shipRec.X - 15, shipRec.Y + 40, 10, 10);
                }

                if (random == 2)
                {
                    shipRec.Y = upTubeRec.Y + shipPos;
                    shipRec.X = upTubeRec.X - 30;
                    shipTorpedoRec = new Rectangle(shipRec.X, shipRec.Y - 15, 10, 10);
                }

                if (random == 3)
                {
                    shipRec.X = upTubeRec.X - shipPos;
                    shipRec.Y = upTubeRec.Y;
                    shipTorpedoRec = new Rectangle(shipRec.X + 80, shipRec.Y + 40, 10, 10);
                }
            }

            shipTimer--;
            if (shipTorpedoRec.X > 350 && shipTorpedoRec.X < 450 && shipTorpedoRec.Y > 175 && shipTorpedoRec.Y < 225)
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

            if (kb.IsKeyDown(Keys.D1) && !oldKB.IsKeyDown(Keys.D1) && charge >= 1)
            {
                power = 100;
                charge--;
            }
            else if (kb.IsKeyDown(Keys.D2) && !oldKB.IsKeyDown(Keys.D2) && charge >= 2)
            {
                power = 200;
                charge -= 2;
            }
            else if (kb.IsKeyDown(Keys.D3) && !oldKB.IsKeyDown(Keys.D3) && charge >= 3)
            {
                power = 300;
                charge -= 3;
            }
            else if (kb.IsKeyDown(Keys.D4) && !oldKB.IsKeyDown(Keys.D4) && charge >= 4)
            {
                power = 400;
                charge -= 4;
            }
            else if (kb.IsKeyDown(Keys.D5) && !oldKB.IsKeyDown(Keys.D5) && charge >= 5)
            {
                power = 500;
                charge -= 5;
            }
            else if (kb.IsKeyDown(Keys.D6) && !oldKB.IsKeyDown(Keys.D6) && charge >= 6)
            {
                power = 600;
                charge -= 6;
            }
            else if (kb.IsKeyDown(Keys.D7) && !oldKB.IsKeyDown(Keys.D7) && charge >= 7)
            {
                power = 700;
                charge -= 7;
            }
            else if (kb.IsKeyDown(Keys.D8) && !oldKB.IsKeyDown(Keys.D8) && charge >= 8)
            {
                power = 800;
                charge -= 8;
            }
            else if (kb.IsKeyDown(Keys.D9) && !oldKB.IsKeyDown(Keys.D9) && charge >= 9)
            {
                power = 900;
                charge -= 9;
            }

            if (!fire)
            {
                if ((kb.IsKeyDown(Keys.Up) && !oldKB.IsKeyDown(Keys.Up)))
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

                if (mouse.Y > turretRec.Y && mouse.Y < turretRec.Y + turretRec.Height)
                {
                    if (mouse.X < turretRec.X)
                        tubeIndex = 3;
                    if (mouse.X > turretRec.X + turretRec.Width)
                        tubeIndex = 1;
                }

                if (mouse.X > turretRec.X && mouse.X < turretRec.X + turretRec.Width)
                {
                    if (mouse.Y < turretRec.Y)
                        tubeIndex = 0;
                    if (mouse.Y > turretRec.Y + turretRec.Height)
                        tubeIndex = 2;
                }
            }

            if ((kb.IsKeyDown(Keys.Space) && !oldKB.IsKeyDown(Keys.Space)) || (mouse.LeftButton == ButtonState.Pressed && !(oldMouse.LeftButton == ButtonState.Pressed)))
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

            if (fire && tubeIndex == 0 && power > 0)
            {
                torpedoRec.Y -= 2;
                power -= 2;
            }
            else if (fire && tubeIndex == 1 && power > 0)
            {
                torpedoRec.X += 2;
                power -= 2;
            }
            else if (fire && tubeIndex == 2 && power > 0)
            {
                torpedoRec.Y += 2;
                power -= 2;
            }
            else if (fire && tubeIndex == 3 && power > 0)
            {
                torpedoRec.X -= 2;
                power -= 2;
            }
            else if (power == 0)
                torpedoRec = new Rectangle(1000, 1000, 10, 10);

            if (random == 0)
                shipTorpedoRec.Y++;
            else if (random == 1)
                shipTorpedoRec.X--;
            else if (random == 2)
                shipTorpedoRec.Y--;
            else if (random == 3)
                shipTorpedoRec.X++;

            if (fire && (torpedoRec.X < 0 || torpedoRec.X > GraphicsDevice.Viewport.Width ||
                torpedoRec.Y < 0 || torpedoRec.Y > GraphicsDevice.Viewport.Height))
                power = 0;

            if (torpedoRec.X < 0 || torpedoRec.X > GraphicsDevice.Viewport.Width ||
                torpedoRec.Y < 0 || torpedoRec.Y > GraphicsDevice.Viewport.Height)
                fire = false;

            oldKB = kb;
            oldMouse = mouse;
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
            if (shipTimer > 0)
                spriteBatch.Draw(shipTex, shipRec, Color.White);
            spriteBatch.Draw(torpedoTex, shipTorpedoRec, Color.White);
            spriteBatch.Draw(turretTex, turretRec, Color.Black);
            spriteBatch.Draw(tubeTallTex, upTubeRec, Color.White);
            spriteBatch.Draw(tubeTallTex, downTubeRec, Color.White);
            spriteBatch.Draw(tubeSideTex, leftTubeRec, Color.White);
            spriteBatch.Draw(tubeSideTex, rightTubeRec, Color.White);

            if (tubeIndex == 0)
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

            spriteBatch.DrawString(font, "LSU Charge: " + charge, new Vector2(550, 400), Color.Black);
            spriteBatch.Draw(powerBarTex, new Rectangle(675, 400, charge, 15), Color.Red);
            spriteBatch.DrawString(font, "Power: " + power, new Vector2(550, 425), Color.Black);
            spriteBatch.Draw(powerBarTex, new Rectangle(650, 425, power / 25, 15), Color.Red);
            spriteBatch.DrawString(font, "Size: " + size, new Vector2(550, 450), Color.Black);
            spriteBatch.Draw(powerBarTex, new Rectangle(625, 450, 3*size, 15), Color.Red);

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}