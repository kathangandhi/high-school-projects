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

namespace Roman_Pig
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        int timer, counter;

        Rectangle pig1Rect, pig2Rect;
        Texture2D pig1Texture, pig2Texture;

        SpriteFont font;
        Vector2 pig1Text, pig2Text;
        String[] texts = { "hi", "there", "stinky" };
        String current;

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
            current = texts[0];

            pig1Rect = new Rectangle(25, 25, 150, 125);
            pig2Rect = new Rectangle(475, 25, 150, 125);

            pig1Text = new Vector2(25, 200);
            pig2Text = new Vector2(475, 200);

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
            pig1Texture = this.Content.Load<Texture2D>("pig 1");
            pig2Texture = this.Content.Load<Texture2D>("pig 2");

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

        public String translate(String text) {
            String extract = "";
            int count = 0;

            for (int i = 0; i < text.Length; i++) {
                if (text[i] == 'a' || text[i] == 'e' || text[i] == 'i' || text[i] == 'o' || text[i] == 'u')
                    break;
                else
                    count++;
            }

            return text.Substring(count) + text.Substring(0, count) + "ay"; 
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
            ++timer;
            if (timer % 180 == 0)
                counter++;

            if (counter > 2)
                this.Exit();
            else
                current = texts[counter];
                    

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

            spriteBatch.Draw(pig1Texture, pig1Rect, Color.White);
            spriteBatch.Draw(pig2Texture, pig2Rect, Color.White);

            spriteBatch.DrawString(font, current, pig1Text, Color.White);
            spriteBatch.DrawString(font, translate(current), pig2Text, Color.White);

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
