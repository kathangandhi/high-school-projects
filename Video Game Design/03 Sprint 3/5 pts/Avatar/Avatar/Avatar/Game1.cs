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

namespace Avatar
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        GamePadState oldPad;
        int index;
        Boolean press;

        Rectangle[] avatarRecs;
        Texture2D[] avatarTexs;
        Texture2D back;

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
            index = 0;
            press = false;

            avatarRecs = new Rectangle[5];
            avatarRecs[0] = new Rectangle(25, 200, 75, 75);
            avatarRecs[1] = new Rectangle(125, 200, 75, 75);
            avatarRecs[2] = new Rectangle(225, 200, 75, 75);
            avatarRecs[3] = new Rectangle(325, 200, 75, 75);
            avatarRecs[4] = new Rectangle(425, 200, 75, 75);

            avatarTexs = new Texture2D[5];

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
            avatarTexs[0] = this.Content.Load<Texture2D>("baby");
            avatarTexs[1] = this.Content.Load<Texture2D>("cop");
            avatarTexs[2] = this.Content.Load<Texture2D>("girl");
            avatarTexs[3] = this.Content.Load<Texture2D>("nurse");
            avatarTexs[4] = this.Content.Load<Texture2D>("woman");

            back = this.Content.Load<Texture2D>("white");
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
            // TODO: Add your update logic here
            GamePadState pad = GamePad.GetState(PlayerIndex.One);

            if (pad.DPad.Left == ButtonState.Pressed && !(oldPad.DPad.Left == ButtonState.Pressed))
            {
                if (index >= 0)
                    index--;
                if (index == -1)
                    index = 4;                   
            }

            if (pad.DPad.Right == ButtonState.Pressed && !(oldPad.DPad.Right == ButtonState.Pressed))
            {
                if (index < avatarRecs.Length)
                    index = (index + 1) % 5;
            }

            if (pad.Buttons.Start == ButtonState.Pressed && !(oldPad.Buttons.Start == ButtonState.Pressed))
            {
                press = true;
            }

            if (pad.Buttons.Back == ButtonState.Pressed && !(oldPad.Buttons.Back == ButtonState.Pressed))
            {
                press = false;
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
            GraphicsDevice.Clear(Color.CornflowerBlue);

            // TODO: Add your drawing code here
            spriteBatch.Begin();
            
            if (press)
            {
                spriteBatch.Draw(avatarTexs[index], new Rectangle(100, 100, 300, 300), Color.White);
            }
            else
            {
                spriteBatch.Draw(back, new Rectangle(avatarRecs[index].X - 10, 190, 90, 90), Color.Red);
                spriteBatch.Draw(avatarTexs[0], avatarRecs[0], Color.White);
                spriteBatch.Draw(avatarTexs[1], avatarRecs[1], Color.White);
                spriteBatch.Draw(avatarTexs[2], avatarRecs[2], Color.White);
                spriteBatch.Draw(avatarTexs[3], avatarRecs[3], Color.White);
                spriteBatch.Draw(avatarTexs[4], avatarRecs[4], Color.White);
            }
            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
