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

namespace Beam_Me_Up
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

        Vector2 options;
        SoundEffect[] clips;
        Rectangle trekRec;
        Texture2D trekTex;
        String lines;
        int timer;

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
            oldKB = Keyboard.GetState();
            timer = 0;

            lines = "1. Alert \n2. Borg \n3. DS9 \n4. TOS Chirp \n5. TOS Phaser";
            clips = new SoundEffect[5];
            trekRec = new Rectangle(500, 25, 100, 200);
            options = new Vector2(100, 100);

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
            clips[0] = this.Content.Load<SoundEffect>("alert10");
            clips[1] = this.Content.Load<SoundEffect>("borg_cut_clean");
            clips[2] = this.Content.Load<SoundEffect>("ds9_door");
            clips[3] = this.Content.Load<SoundEffect>("tos_chirp_2");
            clips[4] = this.Content.Load<SoundEffect>("tos_phaser_stun");

            trekTex = this.Content.Load<Texture2D>("star trek");
            font = this.Content.Load<SpriteFont>("SpriteFont1");
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

            // TODO: Add your update logic here
            KeyboardState kb = Keyboard.GetState();

            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed
                || kb.IsKeyDown(Keys.Escape))
                this.Exit();

            if(timer > 0)
                timer--;

            if(timer == 0)
            {
                if (kb.IsKeyDown(Keys.NumPad1) && !oldKB.IsKeyDown(Keys.NumPad1))
                {
                    clips[0].Play();
                    timer = clips[0].Duration.Seconds*60;
                }  
                if (kb.IsKeyDown(Keys.NumPad2) && !oldKB.IsKeyDown(Keys.NumPad2))
                {
                    clips[1].Play();
                    timer = clips[1].Duration.Seconds * 60;
                }
                if (kb.IsKeyDown(Keys.NumPad3) && !oldKB.IsKeyDown(Keys.NumPad3))
                {
                    clips[2].Play();
                    timer = clips[2].Duration.Seconds * 60;
                }
                if (kb.IsKeyDown(Keys.NumPad4) && !oldKB.IsKeyDown(Keys.NumPad4))
                {
                    clips[3].Play();
                    timer = clips[3].Duration.Seconds * 60;
                }
                if (kb.IsKeyDown(Keys.NumPad5) && !oldKB.IsKeyDown(Keys.NumPad5))
                {
                    clips[4].Play();
                    timer = clips[4].Duration.Seconds * 60;
                } 
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
            spriteBatch.Draw(trekTex, trekRec, Color.White);
            spriteBatch.DrawString(font, lines, options, Color.White);
            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
