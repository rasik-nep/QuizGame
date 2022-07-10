import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;
import queandans.*;

public class Main {

    //Function for asking questions
    public static float getTheScore(){
        Float currentScore = 0.0f;

        // Get the questions
        Questions questions = new Questions();
        String[] questionArray = questions.getQueArray();

        //Get the answers
        Answers answers = new Answers();
        String[] answerArray = answers.getAnsArray();

        Scanner myObj = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println(questionArray[i]);
            // Get the current time
            Instant startTime = Instant.now();
            String userAnswer = myObj.nextLine();

            // Get the current time
            Instant endTime = Instant.now();

            System.out.println("Your answer " + userAnswer);
            String actualAnswer = answerArray[i];

            Duration timeElapsed = Duration.between(startTime, endTime);
            System.out.println("Time taken: " + timeElapsed.toSeconds() + " seconds");

            if (userAnswer.equalsIgnoreCase(actualAnswer)) {
                currentScore = currentScore + 2 * (60 - timeElapsed.toSeconds()) / 40;
            }
        }

        return currentScore;
    }


    public static void main(String[] args) {

        Float currentScore = 0.0f;
        Float highScore = 0.0f;
        String highScoreName = "";

        // create the selection options for the user
        Scanner myObj = new Scanner(System.in);

        while (true) {

            System.out.println("Hello there! Welcome to the quiz game. To continue please select a option");
            System.out.println("1. Start the quiz");
            System.out.println("2. View the highest points.");
            System.out.println("3. Exit");
            String userOption = myObj.nextLine();

            switch (userOption) {
                case "1":

                    // Get the details of the user
                    System.out.println("\nWhat is your name?");
                    String userName = myObj.nextLine();

                    currentScore =getTheScore();

                    System.out.println("Current score for "+userName +" is : "+currentScore +"\n");

                    // set the value of the highest score
                    if (highScore < currentScore) {
                        highScoreName = userName;
                        highScore = currentScore;
                    }

                    break;

                // print the current high score
                case "2":
                    System.out.println(highScoreName +" has scored the highest points.");
                    System.out.println("High score  :" + highScore);
                    System.out.println("\nYou can do better \n");
                    break;

                // Exit the program
                case "3":
                    System.out.println("\nThank you for plying the game.\n");
                    System.exit(0);
                    break;
            }

        }
    }
}
