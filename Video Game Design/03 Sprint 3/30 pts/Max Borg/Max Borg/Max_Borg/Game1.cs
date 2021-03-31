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

namespace Max_Borg
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        SoundEffect torpedo, shipTorpedo, phaser;
        GamePadState oldPad;
        SpriteFont font;
        Color phaserColor;
        int timer, shipTimer;


        Rectangle turretRec, upTubeRec, downTubeRec, leftTubeRec, rightTubeRec, torpedoRec, shipRec, shipTorpedoRec, phaserRec;
        Texture2D turretTex, tubeTallTex, tubeSideTex, torpedoTex, shipTex, powerBarTex, explosiveTex;
        Boolean fire, phaserFire;
        int charge, power, tubeIndex, size, random, shipPos, duration, phaserType, phaserWidth;

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
            oldPad = GamePad.GetState(PlayerIndex.One);

            tubeIndex = 0;
            fire = false;
            charge = 0;
            power = 1;
            size = 0;
            phaserType = 0;

            timer = 0;
            random = -1;
            shipTimer = 0;
            shipPos = 0;
            duration = 0;

            turretRec = new Rectangle(350, 225, 100, 50);
            upTubeRec = new Rectangle(390, 190, 20, 40);
            downTubeRec = new Rectangle(390, 270, 20, 40);
            leftTubeRec = new Rectangle(315, 245, 40, 20);
            rightTubeRec = new Rectangle(445, 245, 40, 20);

            torpedoRec = new Rectangle(1000, 1000, 10, 10);
            shipRec = new Rectangle(1000, 1000, 75, 100);
            shipTorpedoRec = new Rectangle(1000, 1000, 10, 10);
            phaserRec = new Rectangle(1000, 1000, 10, 10);

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
            torpedo = this.Content.Load<SoundEffect>("tng_torpedo_clean");
            shipTorpedo = this.Content.Load<SoundEffect>("tos_photon_torpedo");
            phaser = this.Content.Load<SoundEffect>("tng_phaser3_clean");

            turretTex = this.Content.Load<Texture2D>("white");
            tubeTallTex = this.Content.Load<Texture2D>("tube vertical");
            tubeSideTex = this.Content.Load<Texture2D>("tube horizontal");
            torpedoTex = this.Content.Load<Texture2D>("ball");
            shipTex = this.Content.Load<Texture2D>("rocket");
            powerBarTex = this.Content.Load<Texture2D>("PixelImage");
            explosiveTex = this.Content.Load<Texture2D>("Explosion");
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
            GamePadState pad = GamePad.GetState(PlayerIndex.One);

            // Allows the game to exit
            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed)
                this.Exit();

            // TODO: Add your update logic here
            timer++;
            if (timer % 60 == 0 && charge < 98)
                charge += 3;

            Random r = new Random();
            if (random == -1)
            {
                random = r.Next(0, 4);
                shipTimer = r.Next(100, 240);

                shipRec = new Rectangle(1000, 1000, 75, 100);
                shipPos = r.Next(80, 150);

                if (random == 0)
                {
                    shipRec.Y = upTubeRec.Y - shipPos - upTubeRec.Height;
                    shipRec.X = upTubeRec.X - 30;
                    shipTorpedoRec = new Rectangle(shipRec.X, shipRec.Y + 105, 10, 10);
                }

                if (random == 1)
                {
                    shipRec.X = rightTubeRec.X + shipPos + rightTubeRec.Width;
                    shipRec.Y = upTubeRec.Y;
                    shipTorpedoRec = new Rectangle(shipRec.X - 15, shipRec.Y + 40, 10, 10);
                }

                if (random == 2)
                {
                    shipRec.Y = downTubeRec.Y + shipPos;
                    shipRec.X = upTubeRec.X - 30;
                    shipTorpedoRec = new Rectangle(shipRec.X, shipRec.Y - 15, 10, 10);
                }

                if (random == 3)
                {
                    shipRec.X = leftTubeRec.X - shipPos - leftTubeRec.Width;
                    shipRec.Y = upTubeRec.Y;
                    shipTorpedoRec = new Rectangle(shipRec.X + 80, shipRec.Y + 40, 10, 10);
                }

                shipTorpedo.Play();
            }

            shipTimer--;
            if (shipTorpedoRec.X > 350 && shipTorpedoRec.X < 450 && shipTorpedoRec.Y > 225 && shipTorpedoRec.Y < 275)
            {
                random = -1;
            }

            if (!fire)
            {
                if (pad.IsButtonDown(Buttons.LeftThumbstickUp) && !oldPad.IsButtonDown(Buttons.LeftThumbstickUp) && charge > 1 && size < 9)
                {
                    charge--;
                    size++;
                }
                else if (pad.IsButtonDown(Buttons.LeftThumbstickDown) && !oldPad.IsButtonDown(Buttons.LeftThumbstickDown) && size > 1)
                {
                    size--;
                }
                else if (pad.IsButtonDown(Buttons.LeftThumbstickRight) && !oldPad.IsButtonDown(Buttons.LeftThumbstickRight) && charge > 1 & power < 9)
                {
                    charge--;
                    power++;
                }
                else if (pad.IsButtonDown(Buttons.LeftThumbstickLeft) && !oldPad.IsButtonDown(Buttons.LeftThumbstickLeft) && !oldPad.IsButtonDown(Buttons.LeftThumbstickLeft) && power > 1)
                {
                    power--;
                }
                else if (pad.IsButtonDown(Buttons.LeftTrigger) && !oldPad.IsButtonDown(Buttons.LeftTrigger))
                {
                    fire = true;
                    torpedo.Play();

                    if (tubeIndex == 0)
                    {
                        torpedoRec = new Rectangle(395 - size, 180 - size, 10 + size, 10 + size);
                        duration = (int)(power / 9.0 * upTubeRec.Y);
                    }

                    if (tubeIndex == 1)
                    {
                        torpedoRec = new Rectangle(485 - size, 250 - size, 10 + size, 10 + size);
                        duration = (int)(power / 9.0 * (800 - rightTubeRec.Width - rightTubeRec.X));
                    }

                    if (tubeIndex == 2)
                    {
                        torpedoRec = new Rectangle(395 - size, 310 - size, 10 + size, 10 + size);
                        duration = (int)(power / 9.0 * (480 - downTubeRec.Height - downTubeRec.Y));
                    }

                    if (tubeIndex == 3)
                    {
                        torpedoRec = new Rectangle(305 - size, 250 - size, 10 + size, 10 + size);
                        duration = (int)(power / 9.0 * leftTubeRec.X);
                    }
                }
            }

            if (!phaserFire)
            {
                if (pad.IsButtonDown(Buttons.A) && !oldPad.IsButtonDown(Buttons.A) && charge > 9)
                {
                    charge -= 9;
                    phaserType = 1;
                    phaserColor = Color.Green;
                    phaserWidth = 10;
                }

                else if (pad.IsButtonDown(Buttons.B) && !oldPad.IsButtonDown(Buttons.B) && charge > 9)
                {
                    charge -= 9;
                    phaserType = 2;
                    phaserColor = Color.Red;
                    phaserWidth = 20;
                }

                else if (pad.IsButtonDown(Buttons.X) && !oldPad.IsButtonDown(Buttons.X) && charge > 9)
                {
                    charge -= 9;
                    phaserType = 3;
                    phaserColor = Color.Blue;
                    phaserWidth = 30;

                }

                else if (pad.IsButtonDown(Buttons.Y) && !oldPad.IsButtonDown(Buttons.Y) && charge > 9)
                {
                    charge -= 9;
                    phaserType = 4;
                    phaserColor = Color.Yellow;
                    phaserWidth = 40;
                }

                else if (pad.IsButtonDown(Buttons.RightTrigger) && !oldPad.IsButtonDown(Buttons.RightTrigger) && phaserType > 0)
                {
                    phaserFire = true;
                    phaser.Play();

                    if (tubeIndex == 0)
                    {
                        phaserRec = new Rectangle(400 - (phaserWidth / 2), 0, phaserWidth, 180);
                    }

                    if (tubeIndex == 1)
                    {
                        phaserRec = new Rectangle(485, 250 - (phaserWidth / 2), 300, phaserWidth);
                    }

                    if (tubeIndex == 2)
                    {
                        phaserRec = new Rectangle(400 - (phaserWidth / 2), 300, phaserWidth, 180);
                    }

                    if (tubeIndex == 3)
                    {
                        phaserRec = new Rectangle(0, 250 - (phaserWidth / 2), 300, phaserWidth);
                    }
                }
            }

            if (pad.IsButtonDown(Buttons.DPadUp) && !oldPad.IsButtonDown(Buttons.DPadUp) && !fire && !phaserFire)
            {
                tubeIndex = 0;
                torpedoRec = new Rectangle(395 - size, 155 - size, 10 + size, 10 + size);
                phaserRec = new Rectangle(400 - (phaserWidth / 2), 0, phaserWidth, 180);
            }

            if (pad.IsButtonDown(Buttons.DPadRight) && !oldPad.IsButtonDown(Buttons.DPadRight) && !fire && !phaserFire)
            {
                tubeIndex = 1;
                torpedoRec = new Rectangle(485 - size, 225 - size, 10 + size, 10 + size);
                phaserRec = new Rectangle(485, 250 - (phaserWidth / 2), 300, phaserWidth);
            }

            if (pad.IsButtonDown(Buttons.DPadDown) && !oldPad.IsButtonDown(Buttons.DPadDown) && !fire && !phaserFire)
            {
                tubeIndex = 2;
                torpedoRec = new Rectangle(395 - size, 285 - size, 10 + size, 10 + size);
                phaserRec = new Rectangle(400 - (phaserWidth / 2), 300, phaserWidth, 180);
            }

            if (pad.IsButtonDown(Buttons.DPadLeft) && !oldPad.IsButtonDown(Buttons.DPadLeft) && !fire && !phaserFire)
            {
                tubeIndex = 3;
                torpedoRec = new Rectangle(305 - size, 225 - size, 10 + size, 10 + size);
                phaserRec = new Rectangle(0, 250 - (phaserWidth / 2), 300, phaserWidth);
            }

            if (fire && tubeIndex == 0 && duration > 0)
            {
                torpedoRec.Y -= 2;
                duration -= 2;
            }
            else if (fire && tubeIndex == 1 && duration > 0)
            {
                torpedoRec.X += 2;
                duration -= 2;
            }
            else if (fire && tubeIndex == 2 && duration > 0)
            {
                torpedoRec.Y += 2;
                duration -= 2;
            }
            else if (fire && tubeIndex == 3 && duration > 0)
            {
                torpedoRec.X -= 2;
                duration -= 2;
            }

            if (phaserFire && tubeIndex == 0)
            {
                phaserRec.Y -= 2;
            }
            else if (phaserFire && tubeIndex == 1)
            {
                phaserRec.X += 2;
            }
            else if (phaserFire && tubeIndex == 2)
            {
                phaserRec.Y += 2;
            }
            else if (phaserFire && tubeIndex == 3)
            {
                phaserRec.X -= 2;
            }

            if (random == 0)
                shipTorpedoRec.Y++;
            else if (random == 1)
                shipTorpedoRec.X--;
            else if (random == 2)
                shipTorpedoRec.Y--;
            else if (random == 3)
                shipTorpedoRec.X++;

            if ((torpedoRec.X < 0 || torpedoRec.X > GraphicsDevice.Viewport.Width ||
                torpedoRec.Y < 0 || torpedoRec.Y > GraphicsDevice.Viewport.Height))
            {
                duration = 0;
                fire = false;
                torpedoRec = new Rectangle(1000, 1000, 10, 10);
            }

            if ((phaserRec.X < -300 || phaserRec.X > 800 ||
                phaserRec.Y < -180 || phaserRec.Y > 480))
            {
                phaserFire = false;
                phaserRec = new Rectangle(1000, 1000, 10, 10);
            }

            if (fire && duration <= 0)
            {
                torpedoRec = new Rectangle(1000, 1000, 10, 10);
                fire = false;

                size = 0;
                power = 0;
            }

            oldPad = pad;
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
            {
                if (tubeIndex == 0 || tubeIndex == 2)
                    power = (int)(duration * 9.0 / 310);
                if (tubeIndex == 1 || tubeIndex == 3)
                    power = (int)(duration * 9.0 / 310);

                if (duration < 20)
                    spriteBatch.Draw(explosiveTex, torpedoRec, Color.White);
                else
                    spriteBatch.Draw(torpedoTex, torpedoRec, Color.White);
            }

            if (phaserFire)
                spriteBatch.Draw(powerBarTex, phaserRec, phaserColor);

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

            if (tubeIndex == 0 && (fire || phaserFire))
            {
                spriteBatch.Draw(tubeTallTex, upTubeRec, Color.Red);
            }
            if (tubeIndex == 1 && (fire || phaserFire))
            {
                spriteBatch.Draw(tubeSideTex, rightTubeRec, Color.Red);
            }
            if (tubeIndex == 2 && (fire || phaserFire))
            {
                spriteBatch.Draw(tubeTallTex, downTubeRec, Color.Red);
            }
            if (tubeIndex == 3 && (fire || phaserFire))
            {
                spriteBatch.Draw(tubeSideTex, leftTubeRec, Color.Red);
            }

            spriteBatch.DrawString(font, "" + charge, new Vector2(395, 240), Color.Red);

            spriteBatch.DrawString(font, "LSU Charge: " + charge, new Vector2(550, 400), Color.Black);
            spriteBatch.Draw(powerBarTex, new Rectangle(675, 400, charge, 15), Color.Red);
            spriteBatch.DrawString(font, "Power: " + power, new Vector2(550, 425), Color.Black);
            spriteBatch.Draw(powerBarTex, new Rectangle(650, 425, power * 10, 15), Color.Red);
            spriteBatch.DrawString(font, "Size: " + size, new Vector2(550, 450), Color.Black);
            spriteBatch.Draw(powerBarTex, new Rectangle(625, 450, 3 * size, 15), Color.Red);

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
