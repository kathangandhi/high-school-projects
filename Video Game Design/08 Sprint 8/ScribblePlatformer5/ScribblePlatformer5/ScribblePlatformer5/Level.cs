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

namespace ScribblePlatformer5
{
    class Level : IDisposable
    {
        private Tile[,] tiles;
        private Dictionary<string, Texture2D> tileSheets;
        public Dictionary<int, Rectangle> TileSourceRecs;

        Player player;
        public Player Player
        {
            get { return player; }
        }

        private List<Enemy> enemies = new List<Enemy>();
        private List<Enemy> deadEnemies = new List<Enemy>();

        private List<Collectable> collectables = new List<Collectable>();
        private List<Collectable> collectedCollectables = new List<Collectable>();

        public Vector2 start;

        ContentManager content;
        public ContentManager Content
        {
            get { return content; }
        }

        private const int TileWidth = 64;
        private const int TileHeight = 64;
        private const int TilesPerRow = 5;
        private const int NumRowsPerSheet = 5;

        private Random random = new Random(1337);

        public int Width
        {
            get { return tiles.GetLength(0); }
        }

        public int Height
        {
            get { return tiles.GetLength(1); }
        }

        public Level(IServiceProvider _serviceProvider, string path)
        {
            content = new ContentManager(_serviceProvider, "Content");

            tileSheets = new Dictionary<string, Texture2D>();
            tileSheets.Add("Blocks", Content.Load<Texture2D>("Tiles/Blocks"));
            tileSheets.Add("Platforms", Content.Load<Texture2D>("Tiles/Platforms"));

            TileSourceRecs = new Dictionary<int, Rectangle>();
            for(int i = 0; i < TilesPerRow * NumRowsPerSheet; i++)
            {
                Rectangle rectTile = new Rectangle((i % TilesPerRow) * TileWidth, 
                    (i / TilesPerRow) * TileHeight, TileWidth, TileHeight);
                TileSourceRecs.Add(i, rectTile);
            }

            LoadTiles(path);
        }

        private void LoadTiles(string path)
        {
            int numOfTilesAcross = 0;
            List<string> lines = new List<string>();

            try
            {
                using (StreamReader reader = new StreamReader(path))
                {
                    string line = reader.ReadLine();
                    numOfTilesAcross = line.Length;

                    while (line != null)
                    {
                        lines.Add(line);
                        int nextLineWidth = line.Length;

                        if (nextLineWidth != numOfTilesAcross)
                            throw new Exception(String.Format(
                                "The length of line {0} is different from all preceding lines.", 
                                lines.Count));

                        line = reader.ReadLine();
                    }
                }
            }
            catch(Exception e)
            {
                Console.WriteLine("The file could not be read:");
                Console.WriteLine(e.Message);
            }

            tiles = new Tile[numOfTilesAcross, lines.Count];

            for(int y = 0; y < Height; ++y)
            {
                for (int x = 0; x < Width; ++x)
                {
                    string currentRow = lines[y];
                    char tileType = currentRow[x];
                    tiles[x, y] = LoadTile(tileType, x, y);
                }
            }
        }

        private Tile LoadTile(char _tileType, int _x, int _y)
        {
            switch (_tileType)
            {
                //blank tile
                case '.':
                    return new Tile(String.Empty, 0, TileCollision.Passable);

                //Platform blocks
                case 'B':
                    return LoadVarietyTile("Platforms", 0, 5, TileCollision.Platform);
                case 'G':
                    return LoadVarietyTile("Platforms", 5, 5, TileCollision.Platform);
                case 'O':
                    return LoadVarietyTile("Platforms", 10, 5, TileCollision.Platform);
                case 'R':
                    return LoadVarietyTile("Platforms", 15, 5, TileCollision.Platform);
                case 'Y':
                    return LoadVarietyTile("Platforms", 20, 5, TileCollision.Platform);

                //Impassable blocks
                case 'b':
                    return LoadVarietyTile("Blocks", 0, 5, TileCollision.Impassable);
                case 'g':
                    return LoadVarietyTile("Blocks", 5, 5, TileCollision.Impassable);
                case 'o':
                    return LoadVarietyTile("Blocks", 10, 5, TileCollision.Impassable);
                case 'r':
                    return LoadVarietyTile("Blocks", 15, 5, TileCollision.Impassable);
                case 'y':
                    return LoadVarietyTile("Blocks", 20, 5, TileCollision.Impassable);

                //player start point
                case '+':
                    return LoadStartTile(_x, _y);

                //enemy start point
                case 'e':
                    return LoadEnemyTile(_x, _y, "e");

                //collectable start point
                case 's':
                    return LoadCollectableTile(_x, _y, "s");
                case 'S':
                    return LoadCollectableTile(_x, _y, "S");

                //unknown tile type character
                default:
                    throw new NotSupportedException(String.Format(
                        "Unsupported tile type character {0} at position {1}, {2}.", 
                        _tileType, _x, _y));
            }
        }

        private Tile LoadVarietyTile(string _tileSheetName, int _colorRow, int _variationCount, TileCollision _collision)
        {
            int index = random.Next(_variationCount);

            int tileSheetIndex = _colorRow + index;
            return new Tile(_tileSheetName, tileSheetIndex, _collision);
        }

        private Tile LoadStartTile(int _x, int _y)
        {
            if (Player != null)
                throw new NotSupportedException("A level may only have one starting point");

            start = new Vector2((_x * 64) + 48, (_y * 64) + 16);
            player = new Player(this, start);

            return new Tile(String.Empty, 0, TileCollision.Passable);
        }

        private Tile LoadEnemyTile(int _x, int _y, string _enemy)
        {
            Vector2 position = new Vector2((_x * 64) + 48, (_y * 64) + 20);
            enemies.Add(new Enemy(this, position, _enemy));
            return new Tile(String.Empty, 0, TileCollision.Passable);
        }

        private Tile LoadCollectableTile(int _x, int _y, string _collectable)
        {
            Vector2 position = new Vector2((_x * 64) + 48, (_y * 64) + 20);
            collectables.Add(new Collectable(this, position, _collectable));
            return new Tile(String.Empty, 0, TileCollision.Passable);
        }

        public void Update(GameTime _gameTime)
        {
            Player.Update(_gameTime);
            if (Player.IsCompletelyDead)
                Player.Reset(start);
            UpdateEnemies(_gameTime);
            UpdateCollectables(_gameTime);
        }

        private void UpdateEnemies(GameTime _gameTime)
        {
            foreach (Enemy enemy in enemies)
            {
                enemy.Update(_gameTime);
                if (player.IsAlive && enemy.IsAlive)
                {
                    if (enemy.BoundingRectangle.Intersects(Player.BoundingRectangle))
                    {
                        if (enemy.BoundingRectangle.Y > Player.BoundingRectangle.Y)
                            OnEnemyKilled(enemy);
                        else
                            OnPlayerKilled();
                    }
                }
                else
                {
                    if (enemy.IsCompletelyDead)
                    {
                        deadEnemies.Add(enemy);
                    }
                }
            }

            if(deadEnemies.Count > 0)
            {
                foreach (Enemy deadEnemy in deadEnemies)
                {
                    enemies.Remove(deadEnemy);
                }
                deadEnemies.Clear();
            }
        }

        private void UpdateCollectables(GameTime _gameTime)
        {
            foreach (Collectable collectable in collectables)
            {
                collectable.Update(_gameTime);
                if(player.IsAlive && collectable.IsAlive)
                {
                    if (collectable.BoundingRectangle.Intersects(player.BoundingRectangle))
                        OnCollectableCollected(collectable);
                }
            }
            if(collectedCollectables.Count > 0)
            {
                foreach (Collectable collectable in collectedCollectables)
                {
                    collectables.Remove(collectable);
                }
                collectedCollectables.Clear();
            }
        }

        private void OnPlayerKilled()
        {
            Player.OnKilled();
        }

        private void OnEnemyKilled(Enemy _enemy)
        {
            _enemy.OnKilled();
        }

        private void OnCollectableCollected(Collectable _collectable)
        {
            _collectable.OnKilled();
            collectedCollectables.Add(_collectable);
        }

        public void Draw(GameTime _gameTime, SpriteBatch _spriteBatch)
        {
            DrawTiles(_spriteBatch);
            player.Draw(_gameTime, _spriteBatch);
            foreach (Enemy enemy in enemies)
                enemy.Draw(_gameTime, _spriteBatch);
            foreach (Collectable collectable in collectables)
                collectable.Draw(_gameTime, _spriteBatch);
        }

        private void DrawTiles(SpriteBatch spriteBatch)
        {
            for(int y = 0; y < Height; y++)
            {
                for(int x = 0; x < Width; x++)
                {
                    if (tileSheets.ContainsKey(tiles[x, y].TileSheetName))
                    {
                        Vector2 position = new Vector2(x, y) * Tile.Size;
                        spriteBatch.Draw(tileSheets[tiles[x, y].TileSheetName], position, TileSourceRecs[tiles[x, y].TileSheetIndex], Color.White);
                    }
                }
            }
        }

        public TileCollision GetCollision(int _x, int _y)
        {
            if (_x < 0 || _x >= Width)
                return TileCollision.Impassable;
            if (_y < 0 || _y >= Height)
                return TileCollision.Passable;

            return tiles[_x, _y].Collision;
        }

        public Rectangle GetBounds(int _x, int _y)
        {
            if (_x < 0 || _y < 0 || _x >= Width || _y >= Height)
                return new Rectangle(_x * Tile.Width, _y * Tile.Height, Tile.Width, Tile.Height);
            if (tiles[_x, _y].Collision == TileCollision.Platform)
                return new Rectangle(_x * Tile.Width, (_y * Tile.Height) + 20, Tile.Width, Tile.Height - 20);

            return new Rectangle(_x * Tile.Width, (_y * Tile.Height) + 5, Tile.Width, Tile.Height - 5);
        }

        public void Dispose()
        {
            Content.Unload();
        }
    }
}
