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

namespace Castle_Mania
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        int timer;

        String message, heraldCaption;
        SpriteFont Font1;
        Vector2 pos1, pos2;

        Rectangle sceneRect, ballRect, boyRect, clownRect, zombieRect, girlRect, heraldRect, knightRect;
        Texture2D sceneTexture, ballTexture, boyTexture, clownTexture, zombieTexture, girlTexture, heraldTexture, knightTexture;
        Color textureBackground;

        Boolean herald;

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
            // TODO: Add your initialization logic

            message = "Let's play";
            pos1 = new Vector2(300, 450);
            pos2 = new Vector2(550, 225);

            textureBackground = Color.White;
            sceneRect = new Rectangle(0, 0, GraphicsDevice.Viewport.Width, GraphicsDevice.Viewport.Height);
            ballRect = new Rectangle(440, 220, 10, 15);

            boyRect = new Rectangle(0, 200, 100, 75);
            girlRect = new Rectangle(-225, 275, 75, 90);
            clownRect = new Rectangle(-350, 350, 100, 150);
            zombieRect = new Rectangle(850, 200, 100, 140);
            heraldRect = new Rectangle(650, 75, 80, 125);
            knightRect = new Rectangle(650, 300, 100, 150);

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
            Font1 = Content.Load<SpriteFont>("SpriteFont1");

            sceneTexture = this.Content.Load<Texture2D>("scene");
            ballTexture = this.Content.Load<Texture2D>("ball");

            boyTexture = this.Content.Load<Texture2D>("boy");
            girlTexture = this.Content.Load<Texture2D>("girl");
            clownTexture = this.Content.Load <Texture2D>("clown");
            zombieTexture = this.Content.Load<Texture2D>("zombie");
            heraldTexture = this.Content.Load<Texture2D>("herald");
            knightTexture = this.Content.Load<Texture2D>("knight");
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
            timer++;

            if (timer < 420)
            {
                herald = false;

                message = "Let's play, Katana";
                boyRect.X++;
                girlRect.X++;
            }
            else if (timer < 820)
            {
                herald = false;

                message = "Catch that";
                boyTexture = this.Content.Load<Texture2D>("boy throw");
                knightRect.X--;

                if (timer > 480)
                {
                    boyTexture = this.Content.Load<Texture2D>("boy");
                    ballRect.X -= 2;
                    ballRect.Y++;
                }

                if (timer < 600)
                {
                    herald = true;
                    heraldCaption = "The kids play in the garden\nA ghost wanders";
                }
            }
            else if (timer < 950)
            {
                herald = false;

                message = "You suck at this";
            }
            else if (timer < 1150)
            {
                herald = false;

                message = "Look, it's the Joker";
                clownRect.X += 2;
            }
            else if (timer < 1500)
            {
                herald = true;
                heraldCaption = "The joker is flying off";

                message = "Why is he smiling and flying away?";
                clownRect.Y -= 2;
            }
            else if (timer < 1750)
            {
                herald = false;
                message = "Why are we getting an eclipse suddenly?";

                textureBackground = new Color(--textureBackground.R, --textureBackground.G, --textureBackground.B);
                knightRect.X++;
            }
            else if (timer < 2250)
            {
                textureBackground = Color.White;

                herald = true;
                heraldCaption = "A zombie has arrived";

                message = "Oh no! It's a zombie";
                zombieRect.X--;
                girlRect.X--;
                boyRect.X--;
            }
            else if (timer < 2350)
            {
                herald = false;
                message = "The ghost approaches the zombie";

                knightTexture = this.Content.Load<Texture2D>("knight fighting");
                knightRect.X--;
                knightRect.Y--;
            }
            else if (timer < 2700)
            {
                herald = true;
                heraldCaption = "The zombie has been killed";

                message = "The ghost's famoud feat is remembered fondly";
            }
            else
            {
                this.Exit();
            }

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
            
            spriteBatch.Draw(sceneTexture, sceneRect, textureBackground);
            spriteBatch.DrawString(Font1, message, pos1, Color.Black);

            spriteBatch.Draw(boyTexture, boyRect, textureBackground);
            spriteBatch.Draw(girlTexture, girlRect, textureBackground);

            if (timer >= 420 && timer < 900)
                spriteBatch.Draw(ballTexture, ballRect, textureBackground);

            if(timer > 700)
                spriteBatch.Draw(clownTexture, clownRect, textureBackground);

            if(timer > 1500 && timer < 2360)
                spriteBatch.Draw(zombieTexture, zombieRect, textureBackground);

            if (herald)
            {
                spriteBatch.Draw(heraldTexture, heraldRect, textureBackground);
                spriteBatch.DrawString(Font1, heraldCaption, pos2, Color.Purple);
            }
                

            if ((timer > 420 && timer < 820) || (timer > 1500 && timer < 1750) || (timer > 2100))
                spriteBatch.Draw(knightTexture, knightRect, textureBackground);

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
