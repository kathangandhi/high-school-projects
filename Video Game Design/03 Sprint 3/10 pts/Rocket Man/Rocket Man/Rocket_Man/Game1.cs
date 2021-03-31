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

namespace Rocket_Man
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        GamePadState oldConsole;
        SpriteFont font;

        Rectangle shipRec;
        Texture2D shipTex;
        int maxVelocity, velocity, heading;

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
            oldConsole = GamePad.GetState(PlayerIndex.One);

            shipRec = new Rectangle(350, 175, 100, 100);

            maxVelocity = 20;
            velocity = 1;
            heading = 0;

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
            shipTex = this.Content.Load<Texture2D>("spaceship");
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

            // TODO: Add your update logic here
            GamePadState console = GamePad.GetState(PlayerIndex.One);

            if (console.IsButtonDown(Buttons.LeftThumbstickUp) && !oldConsole.IsButtonDown(Buttons.LeftThumbstickUp) && velocity < maxVelocity)
                velocity++;
            if (console.IsButtonDown(Buttons.LeftThumbstickDown) && !oldConsole.IsButtonDown(Buttons.LeftThumbstickDown) && velocity > 0)
                velocity--;
            
            heading = (int)Math.Round(MathHelper.ToDegrees((float)Math.Atan(console.ThumbSticks.Right.Y / console.ThumbSticks.Right.X)));

            if (console.ThumbSticks.Right.X > 0)
                heading = 90 - (int)Math.Round(MathHelper.ToDegrees((float)Math.Atan(console.ThumbSticks.Right.Y / console.ThumbSticks.Right.X)));
            if (console.ThumbSticks.Right.X < 0 && console.ThumbSticks.Right.Y < 0)
                heading = 270 - (int)Math.Round(MathHelper.ToDegrees((float)Math.Atan(console.ThumbSticks.Right.Y / console.ThumbSticks.Right.X)));
            if (console.ThumbSticks.Right.X < 0 && console.ThumbSticks.Right.Y > 0)
                heading = 270 - (int)Math.Round(MathHelper.ToDegrees((float)Math.Atan(console.ThumbSticks.Right.Y / console.ThumbSticks.Right.X)));

            if (console.ThumbSticks.Right.Y == 0 && console.ThumbSticks.Right.X == 0)
                heading = 0;

            if (console.ThumbSticks.Right.Y > 0 && console.ThumbSticks.Right.X == 0)
                heading = 0;
            if (console.ThumbSticks.Right.Y < 0 && console.ThumbSticks.Right.X == 0)
                heading = 180;
            if (console.ThumbSticks.Right.Y == 0 && console.ThumbSticks.Right.X < 0)
                heading = 270;
            if (console.ThumbSticks.Right.Y == 0 && console.ThumbSticks.Right.X > 0)
                heading = 90;

            if (console.IsButtonDown(Buttons.RightThumbstickRight))
                shipRec.X += velocity;
            if (console.IsButtonDown(Buttons.RightThumbstickLeft))
                shipRec.X -= velocity;
            if (console.IsButtonDown(Buttons.RightThumbstickUp))
                shipRec.Y -= velocity;
            if (console.IsButtonDown(Buttons.RightThumbstickDown))
                shipRec.Y += velocity;

            if (shipRec.X > GraphicsDevice.Viewport.Width)
                shipRec.X = 0;
            if (shipRec.X < 0)
                shipRec.X = GraphicsDevice.Viewport.Width - 1;
            if (shipRec.Y > GraphicsDevice.Viewport.Height)
                shipRec.Y = 0;
            if (shipRec.Y < 0)
                shipRec.Y = GraphicsDevice.Viewport.Height - 1;

            oldConsole = console;

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
            spriteBatch.Draw(shipTex, shipRec, Color.White);
            spriteBatch.DrawString(font, "Velocity: " + velocity, new Vector2(0, 450), Color.Black);
            spriteBatch.DrawString(font, "Heading: " + heading, new Vector2(625, 450), Color.Black);
            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
