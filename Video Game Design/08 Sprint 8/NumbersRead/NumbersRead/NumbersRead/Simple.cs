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
using System.IO;

namespace NumbersRead
{
    class Simple
    {
        int[] nums;

        public Simple(string path)
        {
            nums = new int[2];
            StreamReader myFileIn = new StreamReader(Path.Combine(path, "Test Data.dat"));

            string strLine = myFileIn.ReadLine(); // Prime the input Stream
            int count = 0;
            while (strLine != null) // Check for file data before outputing data
            {
                nums[count] = Convert.ToInt32(strLine);

                strLine = myFileIn.ReadLine();
                count++;
            }
            myFileIn.Close();
        }
        
        public int[] getNums()
        {
            return nums;
        }
    }
}

