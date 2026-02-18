// You should **not** update any call signatures in this file
// only modify the body of each function
class Conversation implements ConversationRequirements {
  // Attributes 
  private java.util.ArrayList<String> transcript;
  private java.util.Random rand;
  private java.util.Scanner scanner;

  /**
   * Constructor 
   */
  Conversation() {
    transcript = new java.util.ArrayList<>();
    rand = new java.util.Random();
    scanner = new java.util.Scanner(System.in);
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {

    System.out.print("How many rounds? ");
    int rounds = scanner.nextInt();
    scanner.nextLine();

    String greeting = "Hi! What's on your mind?";
    System.out.println();
    System.out.println(greeting);
    transcript.add(greeting);

    for (int i = 0; i < rounds; i++){
      String userInput = scanner.nextLine();
      transcript.add(userInput);

      String response = respond(userInput);
      System.out.println(response);
      transcript.add(response);
    }

    String goodbye =  "ByeBye!";
    System.out.println(goodbye);
    transcript.add(goodbye);
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    
    System.out.println();
    System.out.println("TRANSCRIPT:");

    for (String line : transcript) {
      System.out.println(line);
    }
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {

    String mirrored = inputString;

    mirrored = mirrored.replace("I", "you");
    mirrored = mirrored.replace("me", "you");
    mirrored = mirrored.replace("am", "are");
    mirrored = mirrored.replace("you", "I");
    mirrored = mirrored.replace("my","your");
    mirrored = mirrored.replace("your", "my");

    if(!mirrored.equals(inputString)) {
      return mirrored + "?";
    }

    String[] cannedResponses = {
      "Interesting.",
      "Mmm-hm.",
      "Tell me more.",
      "What do you think?"
    };

    return cannedResponses[rand.nextInt(cannedResponses.length)];
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
  }
}