using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Audio;
using Microsoft.Xna.Framework.Content;
using Microsoft.Xna.Framework.GamerServices;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;
using Microsoft.Xna.Framework.Media;

namespace Journey_To_Babel
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        enum GameState
        {
            start,
            save,
            done
        }

        enum Language
        {
            English,
            Spanish,
            German
        }

        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        SpriteFont font;
        KeyboardState oldKB;

        GameState gameState;
        Language lang;
        string[] statePhrases;
        Dictionary<string, string> English, Spanish, German;
        Dictionary<string, string> currentLanguage;

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

            gameState = GameState.start;
            lang = Language.English;

            statePhrases = new string[3];
            English = new Dictionary<string, string>();
            Spanish = new Dictionary<string, string>();
            German = new Dictionary<string, string>();

            ReadFile(@"Content/Output Messages.txt");

            currentLanguage = English;

            base.Initialize();
        }

        private void ReadFile(string path)
        {
            try
            {
                using(StreamReader file = new StreamReader(path))
                {
                    while (!file.EndOfStream)
                    {
                        for(int i = 0; i < 3; i++)
                        {
                            statePhrases[i] = file.ReadLine();
                            English.Add(statePhrases[i], file.ReadLine());
                            Spanish.Add(statePhrases[i], file.ReadLine());
                            German.Add(statePhrases[i], file.ReadLine());

                            file.ReadLine();
                        }
                    }
                }
            }
            catch(Exception e)
            {
                Console.WriteLine("Your file could not be loaded");
                Console.WriteLine(e.Message);
            }
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
            font = Content.Load<SpriteFont>("SpriteFont1");
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
            if (kb.IsKeyDown(Keys.NumPad1) && !oldKB.IsKeyDown(Keys.NumPad1))
            {
                lang = Language.English;
                currentLanguage = English;
            }

            if (kb.IsKeyDown(Keys.NumPad2) && !oldKB.IsKeyDown(Keys.NumPad2))
            {
                lang = Language.Spanish;
                currentLanguage = Spanish;
            }

            if (kb.IsKeyDown(Keys.NumPad3) && !oldKB.IsKeyDown(Keys.NumPad3))
            {
                lang = Language.German;
                currentLanguage = German;
            }

            if (kb.IsKeyDown(Keys.Space) && !oldKB.IsKeyDown(Keys.Space))
            {
                if((int) gameState == 2)
                {
                    gameState = GameState.start;
                }
                else
                {
                    gameState = (gameState + 1);
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
            GraphicsDevice.Clear(Color.Black);

            // TODO: Add your drawing code here
            spriteBatch.Begin();
            spriteBatch.DrawString(font, "" + gameState.ToString(), new Vector2(375, 200), Color.White);
            spriteBatch.DrawString(font, "" + currentLanguage[gameState.ToString()], new Vector2(275, 240), Color.White);

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
