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

namespace Mini_Map
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        KeyboardState oldKB;

        Rectangle backRec, mapRec, spriteRec, treeRec, houseRec, courtRec, sceneRec, lakeRec;
        Rectangle sprMapRec, treeMapRec, houseMapRec, courtMapRec, sceneMapRec, lakeMapRec;
        Texture2D backTex, spriteTex, treeTex, houseTex, courtTex, sceneTex, lakeTex;

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

            backRec = new Rectangle(-800, 0, 2400, 480);
            mapRec = new Rectangle(645, 20, 110, 85);

            spriteRec = new Rectangle(325, 175, 100, 75);
            treeRec = new Rectangle(50, 50, 100, 150);
            houseRec = new Rectangle(600, 300, 250, 175);
            courtRec = new Rectangle(1000, 100, 400, 250);
            sceneRec = new Rectangle(-500, 200, 300, 200);
            lakeRec = new Rectangle(250, 150, 300, 225);

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
            backTex = this.Content.Load<Texture2D>("white");

            spriteTex = this.Content.Load<Texture2D>("sprite");
            treeTex = this.Content.Load<Texture2D>("tree");
            houseTex = this.Content.Load<Texture2D>("house");
            courtTex = this.Content.Load<Texture2D>("court");
            sceneTex = this.Content.Load<Texture2D>("scenery");
            lakeTex = this.Content.Load<Texture2D>("Picture1");
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
            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed)
                this.Exit();

            if (kb.IsKeyDown(Keys.Down))
                spriteRec.Y += 3;
            if (kb.IsKeyDown(Keys.Up))
                spriteRec.Y -= 3;
            if (kb.IsKeyDown(Keys.Right))
                spriteRec.X += 3;
            if (kb.IsKeyDown(Keys.Left))
                spriteRec.X -= 3;

            if(spriteRec.X > 800)
            {
                spriteRec.X = 0;

                backRec.X -= 800;

                treeRec.X -= 800;
                houseRec.X -= 800;
                courtRec.X -= 800;
                sceneRec.X -= 800;
                lakeRec.X -= 800;
            }

            if (spriteRec.X < 0)
            {
                spriteRec.X = 800;

                backRec.X += 800;

                treeRec.X += 800;
                houseRec.X += 800;
                courtRec.X += 800;
                sceneRec.X += 800;
                lakeRec.X += 800;
            }

            if (spriteRec.Y < 0)
            {
                spriteRec.Y = 480;
            }

            if (spriteRec.Y > 480)
            {
                spriteRec.Y = 0;
            }

            // TODO: Add your update logic here
            sprMapRec = new Rectangle((int)(spriteRec.X / 800.0 * 100) + 650, (int)(spriteRec.Y / 480.0 * 75) + 25, (int)(spriteRec.Width / 800.0 * 95), (int)(spriteRec.Height / 480.0 * 70));
            treeMapRec = new Rectangle((int)(treeRec.X / 800.0 * 100) + 650, (int)(treeRec.Y / 480.0 * 75) + 25, (int)(treeRec.Width / 800.0 * 95), (int)(treeRec.Height / 480.0 * 70));
            houseMapRec = new Rectangle((int)(houseRec.X / 800.0 * 100) + 650, (int)(houseRec.Y / 480.0 * 75) + 25, (int)(houseRec.Width / 800.0 * 95), (int)(houseRec.Height / 480.0 * 70));
            courtMapRec = new Rectangle((int)(courtRec.X / 800.0 * 100) + 650, (int)(courtRec.Y / 480.0 * 75) + 25, (int)(courtRec.Width / 800.0 * 95), (int)(courtRec.Height / 480.0 * 70));
            sceneMapRec = new Rectangle((int)(sceneRec.X / 800.0 * 100) + 650, (int)(sceneRec.Y / 480.0 * 75) + 25, (int)(sceneRec.Width / 800.0 * 95), (int)(sceneRec.Height / 480.0 * 70));
            lakeMapRec = new Rectangle((int)(lakeRec.X / 800.0 * 100) + 650, (int)(lakeRec.Y / 480.0 * 75) + 25, (int)(lakeRec.Width / 800.0 * 95), (int)(lakeRec.Height / 480.0 * 70));

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

            spriteBatch.Draw(backTex, backRec, Color.Green);
            spriteBatch.Draw(backTex, mapRec, Color.Black);

            spriteBatch.Draw(treeTex, treeRec, Color.White);
            spriteBatch.Draw(houseTex, houseRec, Color.White);
            spriteBatch.Draw(courtTex, courtRec, Color.White);
            spriteBatch.Draw(sceneTex, sceneRec, Color.White);
            spriteBatch.Draw(lakeTex, lakeRec, Color.White);

            spriteBatch.Draw(spriteTex, spriteRec, Color.White);

            if (treeMapRec.X > 645 && treeMapRec.X < 755 && treeMapRec.Y > 20 && treeMapRec.Y < 105)
                spriteBatch.Draw(backTex, treeMapRec, Color.Green);
            if (houseMapRec.X > 645 && houseMapRec.X < 755 && houseMapRec.Y > 20 && houseMapRec.Y < 105)
                spriteBatch.Draw(backTex, houseMapRec, Color.White);
            if (courtMapRec.X > 645 && courtMapRec.X < 755 && courtMapRec.Y > 20 && courtMapRec.Y < 105)
                spriteBatch.Draw(backTex, courtMapRec, Color.White);
            if (sceneMapRec.X > 645 && sceneMapRec.X < 755 && sceneMapRec.Y > 20 && sceneMapRec.Y < 105)
                spriteBatch.Draw(backTex, sceneMapRec, Color.Green);
            if (lakeMapRec.X > 645 && lakeMapRec.X < 755 && lakeMapRec.Y > 20 && lakeMapRec.Y < 105)
                spriteBatch.Draw(backTex, lakeMapRec, Color.Blue);

            spriteBatch.Draw(backTex, sprMapRec, Color.Red);

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
