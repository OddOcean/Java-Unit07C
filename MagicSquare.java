class MagicSquare{
  private int size;
  private int magic[][];

  public MagicSquare(int s){
		size = s;
		magic = new int[size][size];
  }

  public int resetX(int x){
    if (x >= size){
      x = 0 + (x - size);
    }else if (x < 0){
      x = size + x;
    }
    return x;
  }

  public int resetY(int y){
    if (y >= size){
      y = 0 + (y - size);
    }else if (y < 0){
      y = size + y;
    }
    return y;
  }

  public void computeMagicSquare(){
    for (int y = 0; y < size; y++){
      for (int x = 0; x < size; x++){
        magic[y][x] = 0;
      }
    }
    int x = (size/2);
    int y = 0;
    for (int i = 1; i <= size*size; i++){
      magic[y][x] = i;
      x++;
      y--;
      x = resetX(x);
      y = resetY(y);
      if (magic[y][x] != 0){
        x -= 1;
        y += 2;
      }
      x = resetX(x);
      y = resetY(y);
    }
  }

  public void displayMagicSquare(){
		System.out.println();
		System.out.println(size + "x" + size + " Magic Square");
		System.out.println("==================");
		System.out.println();
    String line = "";
    for (int y = 0; y < size; y++){
      for (int x = 0; x < size; x++){
        line += String.format("%-5d", magic[y][x]);
      }
      System.out.println(line);
      line = "";
    }
  }

  public void checkRows(){
		System.out.println();
		System.out.println("Checking Rows");
		System.out.println("=============");
		System.out.println();
    int sum = 0;
    String line = "";
    for (int y = 0; y < size; y++){
      for (int x = 0; x < size - 1; x++){
        line += magic[y][x] + " + ";
        sum += magic[y][x];
      }
      sum += magic[y][size - 1];
      line += magic[y][size - 1];
      System.out.println(line + " = " + sum);
      sum = 0;
      line = "";
    }
  }

  public void checkColumns(){
		System.out.println();
		System.out.println("Checking Columns");
		System.out.println("================");
		System.out.println();
    int sum = 0;
    String line = "";
    for (int x = 0; x < size; x++){
      for (int y = 0; y < size - 1; y++){
        line += magic[y][x] + " + ";
        sum += magic[y][x];
      }
      sum += magic[size - 1][x];
      line += magic[size - 1][x];
      System.out.println(line + " = " + sum);
      sum = 0;
      line = "";
    }
  }

  public void checkDiagonals(){
		System.out.println();
		System.out.println("Checking Diagonals");
		System.out.println("==================");
		System.out.println();
    int sum = 0;
    String line = "";
    for (int i = 0; i < size - 1; i++){
      line += magic[i][i] + " + ";
      sum += magic[i][i];
    }
    sum += magic[size - 1][size - 1];
    line += magic[size - 1][size - 1];
    System.out.println(line + " = " + sum);
    sum = 0;
    line = "";
    for (int i = 0; i < size - 1; i++){
      line += magic[i][size - 1 - i] + " + ";
      sum += magic[i][size - 1 - i];
    }
    sum += magic[size - 1][0];
    line += magic[size - 1][0];
    System.out.println(line + " = " + sum);
  }
}
