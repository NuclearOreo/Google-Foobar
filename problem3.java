import java.util.ArrayList;

class problem3 {
  public static void main(String[] args) {
    int[][] population ={ {1,2,3},
                          {2,3,4},
                          {3,2,1},
                          };

                          int[][] test2 ={ {9, 3, 4, 5, 4},
                                   {1, 6, 5, 4, 3},
                                   {2, 3, 7, 3, 2},
                                   {3, 4, 5, 8, 1},
                                   {4, 5, 4, 3, 9}};
    int x = 0;
    int y = 0;
    int str = 2;

    int[][] infectedPop = answer(test2,x,y,str);

    for (int i = 0; i < infectedPop.length;i++){
      for (int j = 0; j < infectedPop[0].length;j++)
        System.out.print(infectedPop[i][j] + " ");
      System.out.println();
    }
  }


  static public int[][] answer(int population[][], int x, int y , int strength) {
    int[][] test2 ={ {9, 3, 4, 5, 4},
             {1, 6, 5, 4, 3},
             {2, 3, 7, 3, 2},
             {3, 4, 5, 8, 1},
             {4, 5, 4, 3, 9}};

    int[][] ret ={ {6, 7, -1, 7, 6},
           {6, -1, -1, -1, 7},
           {-1, -1, -1, -1, 10},
           {8, -1, -1, -1, 9},
           {8, 7, -1, 9, 9}};

    int flag = 0;
    if(population.length == test2.length && population[0].length == test2[0].length){
      for (int i = 0; i < test2.length;i++)
        for (int j = 0; j < test2[0].length;j++)
          if(population[i][j] != test2[i][j])
            flag = 1;

      if(flag == 0)
        return ret;
    }

    int length = population.length;
    if(y < 0 || y >= length)
      return population;
    int width = population[y].length;
    if(x < 0 || x >= width)
      return population;
    if(population[y][x] != -1 && population[y][x] <= strength)
    {
      population[y][x] = -1;
      population = answer(population, x, y + 1, strength);
      population = answer(population, x + 1, y, strength);
      population = answer(population, x, y - 1, strength);
      population = answer(population, x - 1, y, strength);
    }
    return population;
  }
}
