import java.util.*;
public class Game{
	public static void main(String args[])
	{
		generateRandom();
	}
	public static void generateRandom(){
		Random rand=new Random();
		int randomNum=rand.nextInt(101);
		guess(randomNum);
	}
	public static void guess(int randomNum){
		Scanner in =new Scanner(System.in);
		System.out.println("");
		System.out.println("Number Guessing Game");
		System.out.println("Guess a number between 0-100 : ");
		int guess=in.nextInt();
		System.out.println("");

		while(guess<0 || guess>100){
			System.out.println("Guess a number between 0-100 : ");
			guess=in.nextInt();
			System.out.println("");
		}
		int tries=0;
		while (guess!=randomNum){
			tries++;
			System.out.println("Wrong Guess!");
			System.out.println("Guess Again : ");
			guess=in.nextInt();
			System.out.println("");

			while(guess<0 || guess>100){
				System.out.println("Guess a number between 0-100 : ");
				guess=in.nextInt();
				System.out.println("");
			}
		if(guess>randomNum){
			System.out.println("Nope! The Guessing Number is Lower");
		}
		else if(guess<randomNum){
			System.out.println("Nope! The Guessing Number is Higher");
		}
		}

		System.out.println("Correct Answer. You Won!");
		System.out.println("Wrong Tries:" + tries);
		System.out.println("");

		System.out.println("Press 1 to play again.");
		System.out.println("Press 0 to exit.");
		int choice=in.nextInt();

		if(choice==1){
			generateRandom();
		}
		else
		{
			return;
		}
	}
}
