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

namespace War
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        SpriteFont font;

        Texture2D[] cardTexs;
        List<Card> cardVars;
        bool Shuffled;

        public Game1()
        {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";

            IsMouseVisible = true;
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
            cardTexs = new Texture2D[52];
            cardVars = new List<Card>();
            Shuffled = false;

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

            // TODO: use this.Content to load your game content here
            for(int suit = 0; suit < 4; suit++)
            {
                String suitName = "";
                for (int i = 1; i <= 13; i++)
                {
                    if (suit == 0)
                        suitName = "clubs";
                    if (suit == 1)
                        suitName = "diamond";
                    if (suit == 2)
                        suitName = "hearts";
                    if (suit == 3)
                        suitName = "spades";
                    cardTexs[i-1] = Content.Load<Texture2D>(suitName.Substring(0,1) + i.ToString("D2"));

                    cardVars.Add(new Card(cardTexs[i - 1], i, suitName));
                }
            }
            
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
            if(!Shuffled)
                cardVars = Shuffle_Cards<Card>(new Card(), cardVars);

            base.Update(gameTime);
        }

        public List<T> Shuffle_Cards<T>(T Value, List<T> CList)
        {
            // Local Vars
            int I, R;
            bool Flag;
            Random Rand = new Random();
            // Local List of T type
            var CardList = new List<T>();
            // Build Local List as big as passed in list and fill it with default value
            for (I = 0; I < CList.Count; I++)
                CardList.Add(Value);
            // Shuffle the list of cards
            for (I = 0; I < CList.Count; I++)
            {
                Flag = false;
                // Loop until an empty spot is found
                do
                {
                    R = Rand.Next(0, CList.Count);
                    if (CardList[R].Equals(Value))
                    {
                        Flag = true;
                        CardList[R] = CList[I];
                    }
                } while (!Flag);
            }
            // Set global var Shuffled to true
            Shuffled = true;
            // Return the shuffled list
            return CardList;
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
            cardVars[0].Draw(spriteBatch, new Rectangle(100, 100, 100, 150));
            spriteBatch.DrawString(font, "Suit: " + cardVars[0].suit, new Vector2(250, 125), Color.White);
            spriteBatch.DrawString(font, "Value: " + cardVars[0].value, new Vector2(250, 150), Color.White);
            cardVars[1].Draw(spriteBatch, new Rectangle(450, 100, 100, 150));
            spriteBatch.DrawString(font, "Suit: " + cardVars[1].suit, new Vector2(600, 125), Color.White);
            spriteBatch.DrawString(font, "Value: " + cardVars[1].value, new Vector2(600, 150), Color.White);
            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
