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

namespace Chess_Board
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;

        Rectangle boardRec;
        Rectangle[] pieceRecs;
        Texture2D boardTex;
        Texture2D[] pieceTexs;

        public Game1()
        {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";

            Window.AllowUserResizing = true;
            IsMouseVisible = true;

            graphics.PreferredBackBufferWidth = GraphicsAdapter.DefaultAdapter.CurrentDisplayMode.Width;
            graphics.PreferredBackBufferHeight = GraphicsAdapter.DefaultAdapter.CurrentDisplayMode.Height - 25;
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
            boardRec = new Rectangle(0, 0, GraphicsDevice.Viewport.Width, GraphicsDevice.Viewport.Height - 40);
            pieceRecs = new Rectangle[32];

            //8th rank
            for(int i = 0; i < 8; i++)
            {
                pieceRecs[i] = new Rectangle(87 + i * 237, 20, 100, 100);
            }

            //7th rank
            for (int i = 0; i < 8; i++)
            {
                pieceRecs[8 + i] = new Rectangle(87 + i * 237, 145, 100, 100);
            }

            //2nd rank
            for (int i = 0; i < 8; i++)
            {
                pieceRecs[16 + i] = new Rectangle(87 + i * 237, 765, 100, 100);
            }

            //1st rank
            for (int i = 0; i < 8; i++)
            {
                pieceRecs[24 + i] = new Rectangle(87 + i * 237, 890, 100, 100);
            }

            //pieceRecs[0] = new Rectangle(85, 20, 100, 100);
            //pieceRecs[1] = new Rectangle(320, 20, 100, 100);

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
            pieceTexs = new Texture2D[12];

            // TODO: use this.Content to load your game content here
            boardTex = Content.Load<Texture2D>("Board");

            //black pieces
            pieceTexs[0] = Content.Load<Texture2D>("BRook");
            pieceTexs[1] = Content.Load<Texture2D>("BKnight");
            pieceTexs[2] = Content.Load<Texture2D>("BBishop");
            pieceTexs[3] = Content.Load<Texture2D>("BQueen");
            pieceTexs[4] = Content.Load<Texture2D>("BKing");
            pieceTexs[5] = Content.Load<Texture2D>("BPawn");

            //white pieces
            pieceTexs[6] = Content.Load<Texture2D>("WRook");
            pieceTexs[7] = Content.Load<Texture2D>("WKnight");
            pieceTexs[8] = Content.Load<Texture2D>("WBishop");
            pieceTexs[9] = Content.Load<Texture2D>("WQueen");
            pieceTexs[10] = Content.Load<Texture2D>("WKing");
            pieceTexs[11] = Content.Load<Texture2D>("WPawn");
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
            if (kb.IsKeyDown(Keys.Escape))
                this.Exit();

            // TODO: Add your update logic here

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
            spriteBatch.Draw(boardTex, boardRec, Color.White);

            //8th rank
            for(int i = 0; i < 3; i++)
            {
                spriteBatch.Draw(pieceTexs[i], pieceRecs[i], Color.White);
                spriteBatch.Draw(pieceTexs[i], pieceRecs[7 - i], Color.White);
            }
            spriteBatch.Draw(pieceTexs[3], pieceRecs[3], Color.White);
            spriteBatch.Draw(pieceTexs[4], pieceRecs[4], Color.White);

            //7th rank
            for (int i = 0; i < 4; i++)
            {
                spriteBatch.Draw(pieceTexs[5], pieceRecs[8 + i], Color.White);
                spriteBatch.Draw(pieceTexs[5], pieceRecs[15 - i], Color.White);
            }

            //2nd rank
            for (int i = 0; i < 4; i++)
            {
                spriteBatch.Draw(pieceTexs[11], pieceRecs[16 + i], Color.White);
                spriteBatch.Draw(pieceTexs[11], pieceRecs[23 - i], Color.White);
            }

            //1st rank
            for (int i = 0; i < 3; i++)
            {
                spriteBatch.Draw(pieceTexs[6 + i], pieceRecs[24 + i], Color.White);
                spriteBatch.Draw(pieceTexs[6 + i], pieceRecs[31 - i], Color.White);
            }
            spriteBatch.Draw(pieceTexs[9], pieceRecs[27], Color.White);
            spriteBatch.Draw(pieceTexs[10], pieceRecs[28], Color.White);

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
