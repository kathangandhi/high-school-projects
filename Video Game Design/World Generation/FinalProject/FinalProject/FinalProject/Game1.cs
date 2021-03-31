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

namespace FinalProject
{
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        KeyboardState oldKB;
        MouseState mouse;
        MouseState oldMouse;
        SpriteBatch spriteBatch;
        SpriteFont font1;
        int state;
        Random r;

        //map generation variables
        List<Empire> empireList;
        List<Texture2D> texList;
        List<Rectangle> recList;

        //war scene variables
        Texture2D squareOutline;
        Tile[,] Tiles;
        Rectangle mouseRec;
        Texture2D whiteTex;
        Texture2D background;
        List<Unit> carter;
        Texture2D unitTex;
        int oldX = 0;
        int oldY = 0;
        HashSet<Vector2> positions;
        Rectangle tileInfoRec;
        String info;

        public Game1()
        {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";

            //changes screen size
            graphics.PreferredBackBufferHeight = 800;
            graphics.PreferredBackBufferWidth = 1200;
            graphics.ApplyChanges();
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
            IsMouseVisible = true;

            //sets up game variables
            state = 0;
            r = new Random();

            //creates world map lists
            empireList = new List<Empire>();
            texList = new List<Texture2D>();
            recList = new List<Rectangle>();

            //refer Tile class to familiarize yourself
            //creates 2D array of tiles for the battleground
            Tiles = new Tile[120, 80];

            //represents the hitbox of the mouse
            mouseRec = new Rectangle(0, 0, 1, 1);

            //stores the position of all units
            positions = new HashSet<Vector2>();

            //creates a list of interactive characters
            carter = new List<Unit>();

            //represents mini-map in the top right
            tileInfoRec = new Rectangle(GraphicsDevice.Viewport.Width - 300, 0, 300, 300);

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

            //all content is loaded
            squareOutline = Content.Load<Texture2D>("BlackOutline");
            whiteTex = Content.Load<Texture2D>("whiterectangle");
            background = Content.Load<Texture2D>("Bakerland");
            unitTex = Content.Load<Texture2D>("PixelSoldier");
            font1 = Content.Load<SpriteFont>("SpriteFont1");

            //empire creation and loaded into world map

            //loads all empire textures
            texList.Add(Content.Load<Texture2D>("empire 1"));
            texList.Add(Content.Load<Texture2D>("empire 2"));
            texList.Add(Content.Load<Texture2D>("empire 3"));
            texList.Add(Content.Load<Texture2D>("empire 4"));

            //creates rectangles
            recList.Add(new Rectangle(GraphicsDevice.Viewport.Width / 2 - 25, GraphicsDevice.Viewport.Height / 2 - 25, 50, 50));
            recList.Add(new Rectangle(r.Next(0, 1150), r.Next(0, 750), 50, 50));
            recList.Add(new Rectangle(r.Next(0, 1150), r.Next(0, 750), 50, 50));
            recList.Add(new Rectangle(r.Next(0, 1150), r.Next(0, 750), 50, 50));

            //compiles empire list
            empireList.Add(new Empire(recList[0], texList[0], "Dregorian"));
            empireList.Add(new Empire(recList[1], texList[1], "Nebasis"));
            empireList.Add(new Empire(recList[2], texList[2], "Lidor"));
            empireList.Add(new Empire(recList[3], texList[3], "Funsy"));

            //handles battle units and positions

            //stores information of all units
            carter.Add(new Unit(new Rectangle(0, 0, 100, 100), unitTex));
            carter.Add(new Unit(new Rectangle(400, 500, 100, 100), unitTex));
            carter.Add(new Unit(new Rectangle(200, 300, 100, 100), unitTex));
            carter.Add(new Unit(new Rectangle(600, 200, 100, 100), unitTex));
            carter.Add(new Unit(new Rectangle(300, 0, 100, 100), unitTex));
            
            //facilitates quick look up of the position of units
            positions.Add(new Vector2(carter[0].getRec().X, carter[0].getRec().Y));
            positions.Add(new Vector2(carter[1].getRec().X, carter[1].getRec().Y));
            positions.Add(new Vector2(carter[2].getRec().X, carter[2].getRec().Y));
            positions.Add(new Vector2(carter[3].getRec().X, carter[3].getRec().Y));
            positions.Add(new Vector2(carter[4].getRec().X, carter[4].getRec().Y));

            //sets up a tile map is 120 x 100
            for (int i = 0; i < 120; i++)
            {
                for (int j = 0; j < 80; j++)
                    Tiles[i, j] = new Tile(new Rectangle(i * 100, j * 100, 100, 100), squareOutline);
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

            //transition from one scene to the next is done by space
            KeyboardState kb = Keyboard.GetState();
            if(kb.IsKeyDown(Keys.Space) && !oldKB.IsKeyDown(Keys.Space))
            {
                state = (state + 1) % 2;
            }

            //first scene - world
            if(state == 0)
            {

            }
            //second scene - battle
            else if(state == 1)
            {
                mouse = Mouse.GetState();
                mouseRec.X = mouse.X;
                mouseRec.Y = mouse.Y;

                //highlights selected areas in gray and keeps the other white
                for (int i = 0; i < 120; i++)
                {
                    for (int j = 0; j < 80; j++)
                    {
                        if (Tiles[i, j].getRec().Intersects(mouseRec))
                        {
                            Tiles[i, j].setColor(Color.Gray * .5f);
                        }
                        else
                        {
                            Tiles[i, j].setColor(Color.White * .5f);
                        }
                    }
                }

                //places units on the correct location within the Tile[,] and updates Tile info
                for (int i = 0; i < 120; i++)
                {
                    for (int j = 0; j < 80; j++)
                    {
                        Vector2 currPos = new Vector2(Tiles[i, j].getRec().X, Tiles[i, j].getRec().Y);

                        if (positions.Contains(currPos))
                        {
                            Tiles[i, j].setUnitOnTile(true);
                        }
                        else
                        {
                            Tiles[i, j].setUnitOnTile(false);
                        }

                    }
                }

                //facilitates click, drag, and drop of units from old to new location
                for (int i = 0; i < 120; i++)
                {
                    for (int j = 0; j < 80; j++)
                    {
                        for (int u = 0; u < carter.Count(); u++)
                        {
                            if (Tiles[i, j].getColor() == Color.Gray * .5f && carter[u].getRec().Intersects(mouseRec) && mouse.LeftButton == ButtonState.Pressed && oldMouse.LeftButton == ButtonState.Released && !carter[u].getFound())
                            {
                                oldX = carter[u].getRec().X;
                                oldY = carter[u].getRec().Y;
                                carter[u].setFound(true);
                            }
                            else if (carter[u].getFound() && mouse.LeftButton == ButtonState.Pressed && oldMouse.LeftButton == ButtonState.Pressed)
                            {
                                carter[u].setLocation(mouse.X, mouse.Y);
                            }
                            else if (carter[u].getFound() && mouse.LeftButton == ButtonState.Released && oldMouse.LeftButton == ButtonState.Pressed)
                            {
                                for (int o = 0; o < 120; o++)
                                {
                                    for (int k = 0; k < 80; k++)
                                    {
                                        if (Tiles[o, k].getColor() == Color.Gray * .5f && Tiles[o, k].getUnitOnTile() == false)
                                        {
                                            carter[u].setLocation(Tiles[o, k].getRec().X, Tiles[o, k].getRec().Y);
                                            positions.Remove(new Vector2(oldX, oldY));
                                            positions.Add(new Vector2(Tiles[o, k].getRec().X, Tiles[o, k].getRec().Y));
                                            carter[u].setFound(false);
                                        }
                                        else if (Tiles[o, k].getColor() == Color.Gray * .5f && Tiles[o, k].getUnitOnTile() == true)
                                        {
                                            carter[u].setLocation(oldX, oldY);
                                            carter[u].setFound(false);
                                        }
                                    }
                                }
                            }

                        }
                    }
                }

                oldMouse = mouse;
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
            //first scene - world
            if(state == 0)
            {
                GraphicsDevice.Clear(Color.LightGreen);

                spriteBatch.Begin();

                //draws all empires
                for(int i = 0; i < empireList.Count; i++)
                {
                    empireList[i].Draw(spriteBatch);
                }
                spriteBatch.DrawString(font1, "Press Space to continue", new Vector2(500, 750), Color.White);

                spriteBatch.End();
            }
            //second scene - battle
            else if(state == 1)
            {
                GraphicsDevice.Clear(Color.White);
                
                spriteBatch.Begin();

                //draws background map
                spriteBatch.Draw(background, new Rectangle(0, 0, 1200, 800), Color.White);

                //draws all the boxes for the tiles
                for (int i = 0; i < 120; i++)
                {
                    for (int j = 0; j < 80; j++)
                    {
                        spriteBatch.Draw(Tiles[i, j].getTex(), Tiles[i, j].getRec(), Tiles[i, j].getColor());
                    }
                }

                //draws all units
                for (int i = 0; i < carter.Count(); i++)
                {
                    spriteBatch.Draw(carter[i].getTex(), carter[i].getRec(), Color.White);
                }

                //writes stats on top of units
                for (int u = 0; u < carter.Count(); u++)
                {
                    spriteBatch.DrawString(font1, "   " + carter[u].getAttack().ToString() + "               " + carter[u].getDefence().ToString(), new Vector2(carter[u].getRec().X, carter[u].getRec().Y), Color.Black);
                }

                //draws mini-map in top right
                spriteBatch.Draw(squareOutline, tileInfoRec, Color.White);

                //if right clicked, it describes the terrain type on the map
                //I don't think this works right now
                if (mouse.RightButton == ButtonState.Pressed)
                {
                    for (int i = 0; i < 120; i++)
                    {
                        for (int j = 0; j < 80; j++)
                        {
                            if (mouseRec.Intersects(Tiles[i, j].getRec()))
                            {
                                info = Tiles[i, j].getType();
                            }

                        }
                    }

                }

                if (info != null)
                {
                    spriteBatch.DrawString(font1, info, new Vector2(1000, 30), Color.Black);
                }

                spriteBatch.End();

                base.Draw(gameTime);
            }
        }
    }
}