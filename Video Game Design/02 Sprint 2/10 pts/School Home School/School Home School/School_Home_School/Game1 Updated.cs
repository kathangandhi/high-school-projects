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

namespace School_Home_School
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;

        int timer, colorCounter, imageCounter;
        String[] texts = {"Classroom Slide", "Home Slide", "School Slide"};
        Color[] color = {Color.Red, Color.Blue, Color.Yellow};
        
        Rectangle classroomBack, homeBack, schoolBack;
        Rectangle[] rects = {new Rectangle(50,50,150,100), new Rectangle(200,350,150,100), new Rectangle(350,50,150,100)};
        
        Texture2D classroomBackTexture, homeBackTexture, schoolBackTexture;
        Texture2D classroomTexture, homeTexture, schoolTexture;

        SpriteFont font;
        Vector2 classroom, home, school;
        

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
            timer = 0;
            colorcounter = 0;
            imageCounter = 0;

            classroom = new Vector2(100, 150);
            home = new Vector2(250, 450);
            school = new Vector2(400, 150);

            classroomBack = new Rectangle(25,25,200,150);
            homeBack = new Rectangle(175,325,200,150);
            schoolBack = new Rectangle(325,25,200,150);

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
            font = this.Content.Load<SpriteFont>("SpriteFont1");

            classroomTexture = this.Content.Load<Texture2D>("classroom");
            homeTexture = this.Content.Load<Texture2D>("home");
            schoolTexture = this.Content.Load<Texture2D>("school");

            classroomBackTexture = this.Content.Load<Texture2D>();
            homeBackTexture = this.Content.Load<Texture2D>();
            schoolBackTexture = this.Content.Load<Texture2D>();

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

            if(timer % 240 == 0)
              imageCounter++;
            if(timer % 420 == 0)
              colorCounter++;

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

            spriteBatch.DrawString(font, texts[(0 + counter) % 3], classroom, color[(0 + counter) % 3);
            spriteBatch.DrawString(font, texts[(1 + counter) % 3], home, color[(1 + counter) % 3);
            spriteBatch.DrawString(font, texts[(2 + counter) % 3], school, color[(2 + counter) % 3]);

            spriteBatch.Draw(classroomTexture, rects[(0 + counter) % 3], Color.White);
            spriteBatch.Draw(homeTexture, rects[(1 + counter) % 3], Color.White);
            spriteBatch.Draw(schoolTexture, rects[(0 + counter) % 3], Color.White);

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}