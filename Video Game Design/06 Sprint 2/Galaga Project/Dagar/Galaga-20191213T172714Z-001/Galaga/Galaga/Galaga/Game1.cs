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

namespace Galaga
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch; 

        Texture2D t;

        Ship ship;
        //g = new Ship(Content.Load<Texture2D>("betterSpriteSheet"), new Rectangle(GraphicsDevice.Viewport.Width / 2, GraphicsDevice.Viewport.Height / 2, 100, 100), new Rectangle(245,0,150,200));

        SpriteFont font;
        Rectangle[] gameScreenRecs;
        Texture2D gameScreenTex;

        int timer;

        int sceneNumber;


        public Game1()
        {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";

            // makess it full screen
            graphics.PreferredBackBufferWidth = GraphicsAdapter.DefaultAdapter.CurrentDisplayMode.Width;
            graphics.PreferredBackBufferHeight = GraphicsAdapter.DefaultAdapter.CurrentDisplayMode.Height;

            // makes mouse visible
            this.IsMouseVisible = true;

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


            //makes spaceship
            ship = new Ship(Content.Load<Texture2D>("betterSpriteSheet"), new Rectangle(GraphicsDevice.Viewport.Width / 2, GraphicsDevice.Viewport.Height - 55, 50, 50), new Rectangle(245, 0, 150, 200), GraphicsDevice.Viewport.Width);

            timer = 0;
            gameScreenRecs = new Rectangle[4];


            gameScreenRecs[0] = new Rectangle(0, 0, GraphicsDevice.Viewport.Width, (int)(GraphicsDevice.Viewport.Height / 2.4));
            gameScreenRecs[1] = new Rectangle(0, 7 * GraphicsDevice.Viewport.Height / 12, GraphicsDevice.Viewport.Width, (int)(GraphicsDevice.Viewport.Height / 2.4));
            gameScreenRecs[2] = new Rectangle(0, (int)(GraphicsDevice.Viewport.Height / 2.4), (int)(GraphicsDevice.Viewport.Width * 0.27), (int)(GraphicsDevice.Viewport.Height / 6));
            gameScreenRecs[3] = new Rectangle((int)(GraphicsDevice.Viewport.Width * 0.72), (int)(GraphicsDevice.Viewport.Height / 2.4), (int)(GraphicsDevice.Viewport.Width * 0.27), (int)(GraphicsDevice.Viewport.Height / 6));

            sceneNumber = 0;
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

            font = Content.Load<SpriteFont>("SpriteFont1");
            gameScreenTex = Content.Load<Texture2D>("loading screen");

            // TODO: use this.Content to load your game content here
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
            if(sceneNumber == 0)
            {
                if (timer % 60 > 45)
                    spriteBatch.DrawString(font, "PRESS SPACE KEY", new Vector2((int)(GraphicsDevice.Viewport.Width * 0.35), (int)(GraphicsDevice.Viewport.Height / 2.25)), Color.White);
                if (Keyboard.GetState().IsKeyDown(Keys.Space))
                    sceneNumber = 1;
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

            // TODO: Add your drawing code here
            

            spriteBatch.Begin();

            //draws ship and allows for ship movement

            if (sceneNumber == 0)
            {
                timer++;
                spriteBatch.Draw(gameScreenTex, gameScreenRecs[0], new Rectangle(0, 0, 1280, 300), Color.White);
                spriteBatch.Draw(gameScreenTex, gameScreenRecs[1], new Rectangle(0, 420, 1280, 300), Color.White);
                spriteBatch.Draw(gameScreenTex, gameScreenRecs[2], new Rectangle(0, 300, 350, 120), Color.White);
                spriteBatch.Draw(gameScreenTex, gameScreenRecs[3], new Rectangle(930, 300, 350, 120), Color.White);   
            }
            else if (sceneNumber == 1)
            {
                ship.Draw(spriteBatch);
            }

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
