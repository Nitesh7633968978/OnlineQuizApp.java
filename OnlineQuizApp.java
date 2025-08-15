import java.util.*;

class Question {
    String questionText;
    List<String> options;
    int correctOption; // index (0-based)

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int answer) {
        return answer == correctOption;
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create a list of questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What are Java loops?",
                Arrays.asList("Control structures for iteration", "A type of data type", "A Java library", "None"),
                0));
        questions.add(new Question("What is enhanced for-loop?",
                Arrays.asList("Loop with conditions", "For-each loop", "Nested loop", "None"),
                1));
        questions.add(new Question("How do you handle multiple user inputs?",
                Arrays.asList("Using Scanner", "Using loops", "Both A and B", "None"),
                2));
        questions.add(new Question("How is switch-case different from if-else?",
                Arrays.asList("Faster for many conditions", "Only works with fixed values", "Both A and B", "None"),
                2));
        questions.add(new Question("What are collections in Java?",
                Arrays.asList("Data structures framework", "Java loops", "JVM processes", "None"),
                0));

        int score = 0;

        // Step 2: Loop through questions
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);

            // Display options
            for (int j = 0; j < q.options.size(); j++) {
                System.out.println((j + 1) + ". " + q.options.get(j));
            }

            // Take user input
            System.out.print("Enter your choice (1-" + q.options.size() + "): ");
            int answer = sc.nextInt() - 1;

            // Check correctness
            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + (q.correctOption + 1) + ". " + q.options.get(q.correctOption));
            }
        }

        // Step 3: Show final result
        System.out.println("\n🎯 Your Score: " + score + "/" + questions.size());
        if (score == questions.size()) {
            System.out.println("🏆 Excellent! All correct.");
        } else if (score >= questions.size() / 2) {
            System.out.println("👍 Good job! You passed.");
        } else {
            System.out.println("📚 Keep practicing to improve!");
        }

        sc.close();
    }
}
