import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int size = enterData(input, "Enter the odd# size of the Magic Square  ===>>  ");
    MagicSquare magic = new MagicSquare(size);

    magic.computeMagicSquare();
    magic.displayMagicSquare();
    magic.checkRows();          
    magic.checkColumns();		 
    magic.checkDiagonals();	 	 
  }

  public static int enterData(Scanner console, String prompt){
    System.out.print(prompt);
    int num = 0;
    boolean looping = true;
    while(looping){
      while(!console.hasNextInt()){
        console.next();
        System.out.println("Not an integer; try again");
        System.out.print(prompt);
      }
      num = console.nextInt();
      if(num % 2 == 0){
        System.out.println("Not an odd integer; try again");
        System.out.print(prompt);
      }else{
        looping = false;
      }
    }
    return num;
  }
  
}
