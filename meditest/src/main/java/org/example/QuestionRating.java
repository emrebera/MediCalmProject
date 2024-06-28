package org.example;

import java.util.*;

public class QuestionRating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a list of questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("How often do you feel nervous, anxious, or on edge in a typical week? (1 = Never, 5 = Always)", "anxiety"));
        questions.add(new Question("How difficult do you find it to control your worrying? (1 = Not difficult at all, 5 = Extremely difficult)" , "anxiety" ));
        questions.add(new Question("How often do you experience physical symptoms such as sweating, trembling, or a racing heart when you are anxious? (1 = Never, 5 = Always)" , "anxiety" ));
        questions.add(new Question("How often do you avoid certain situations or activities because they make you feel anxious? (1 = Never, 5 = Always)" , "anxiety" ));
        questions.add(new Question("How much does anxiety interfere with your daily activities, work, or social interactions? (1 = Not at all, 5 = Severely)" , "anxiety" ));
        questions.add(new Question("How often do you have trouble falling asleep? (1 = Never, 5 = Always)", "insomnia"));
        questions.add(new Question("How often do you wake up frequently during the night? (1 = Never, 5 = Always)", "insomnia"));
        questions.add(new Question("How often do you wake up too early and cannot go back to sleep? (1 = Never, 5 = Always)", "insomnia"));
        questions.add(new Question("How often do you feel tired or unrefreshed after sleeping? (1 = Never, 5 = Always)", "insomnia"));
        questions.add(new Question("How much does insomnia interfere with your daily activities, work, or social interactions? (1 = Not at all, 5 = Severely)", "insomnia"));
        questions.add(new Question("How often do you feel down, depressed, or hopeless? (1 = Never, 5 = Always)", "depression"));
        questions.add(new Question("How often do you have little interest or pleasure in doing things? (1 = Never, 5 = Always)", "depression"));
        questions.add(new Question("How often do you feel tired or have little energy? (1 = Never, 5 = Always)", "depression"));
        questions.add(new Question("How often do you feel bad about yourself or that you are a failure? (1 = Never, 5 = Always)", "depression"));
        questions.add(new Question("How much does depression interfere with your daily activities, work, or social interactions? (1 = Not at all, 5 = Severely)", "depression"));
        questions.add(new Question("How often do you feel overwhelmed by your responsibilities? (1 = Never, 5 = Always)", "stress"));
        questions.add(new Question("How often do you find it hard to relax and unwind? (1 = Never, 5 = Always)", "stress"));
        questions.add(new Question("How often do you experience physical symptoms like headaches or stomach issues when stressed? (1 = Never, 5 = Always)", "stress"));
        questions.add(new Question("How often do you feel irritable or angry due to stress? (1 = Never, 5 = Always)", "stress"));
        questions.add(new Question("How much does stress interfere with your daily activities, work, or social interactions? (1 = Not at all, 5 = Severely)", "stress"));
        questions.add(new Question("How often do you experience sudden, intense fear or discomfort that peaks within minutes? (1 = Never, 5 = Always)", "panic disorder"));
        questions.add(new Question("How often do you worry about having more panic attacks? (1 = Never, 5 = Always)", "panic disorder"));
        questions.add(new Question("How often do you avoid places or situations because you fear they might cause a panic attack? (1 = Never, 5 = Always)", "panic disorder"));
        questions.add(new Question("How often do you experience physical symptoms like chest pain, heart palpitations, or dizziness during these episodes? (1 = Never, 5 = Always)", "panic disorder"));
        questions.add(new Question("How much do panic attacks interfere with your daily activities, work, or social interactions? (1 = Not at all, 5 = Severely)", "panic disorder"));

        // Map to store summed ratings by type
        Map<String, Integer> typeRatings = new HashMap<>();
        // Map to store count of ratings by type
        Map<String, Integer> typeCounts = new HashMap<>();

        // Ask each question and collect ratings
        for (Question question : questions) {
            System.out.println(question.getText());
            int rating = 0;
            boolean validInput = false;

            // Loop until a valid rating is entered
            while (!validInput) {
                System.out.print("Enter your rating (1-5): ");
                if (scanner.hasNextInt()) {
                    rating = scanner.nextInt();
                    if (rating >= 1 && rating <= 5) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid rating. Please enter a number between 1 and 5.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    scanner.next(); // Consume the invalid input
                }
            }

            // Sum ratings by type
            typeRatings.put(question.getType(), typeRatings.getOrDefault(question.getType(), 0) + rating);
            typeCounts.put(question.getType(), typeCounts.getOrDefault(question.getType(), 0) + 1);
        }

        // Display summed ratings by type
        System.out.println("\nSummed ratings by type:");
        for (String type : typeRatings.keySet()) {
            int totalRating = typeRatings.get(type);
            int count = typeCounts.get(type);
            double averageRating = totalRating / (double) count;
            System.out.println(type + " test result --");
            System.out.println(type + ": Total = " + totalRating + ", Count = " + count + ", Average = " + averageRating);
            displaySuggestionsAndExplanation(type, totalRating);
        }

        scanner.close();
    }

    public static void displaySuggestionsAndExplanation(String type, int totalRating) {
        String severity = "";
        String suggestion = "";
        String explanation = "";

        String depressionExplanation = "Depression involves persistent feelings of sadness, hopelessness, and a loss of interest in activities once enjoyed. " +
                "Moderate depression can significantly impact daily functioning, causing difficulties in maintaining relationships, " +
                "performing at work or school, and managing day-to-day tasks. Symptoms may include changes in appetite, sleep disturbances, " +
                "fatigue, and difficulty concentrating. Treatment typically involves therapy and lifestyle changes to improve mood and overall well-being.";
        String insomniaExplanation = "Insomnia is characterized by difficulty falling asleep, staying asleep, or waking up too early. " +
                "Moderate insomnia can affect daytime functioning, leading to fatigue, irritability, and difficulty concentrating. " +
                "It can be caused by various factors, including stress, anxiety, poor sleep habits, and underlying medical conditions. " +
                "Addressing moderate insomnia often involves improving sleep hygiene and possibly seeking therapy to address any contributing psychological factors.";
        String anxietyExplanation = "Anxiety disorders involve excessive worry or fear that can interfere with daily activities. " +
                "Severe anxiety often manifests through constant worry, physical symptoms like a racing heart, sweating, trembling, " +
                "and muscle tension. It can lead to avoidance of anxiety-provoking situations, significantly impacting social, work," +
                " and personal life. Individuals may struggle to control their anxiety and find it overwhelming, requiring professional intervention to manage effectively.";
        String panicExplanation = "Panic disorder involves recurrent panic attacks characterized by sudden, intense fear and physical" +
                " symptoms such as chest pain, heart palpitations, shortness of breath, dizziness, and nausea. Moderate panic disorder" +
                " can significantly impact daily life, leading to avoidance of situations where panic attacks have occurred or might occur. " +
                "This avoidance can restrict activities and reduce quality of life. Effective management often involves therapy to address the triggers and learn coping mechanisms.";
        String stressExplanation = "Severe stress can lead to significant physical and emotional health problems. It often manifests" +
                " through feelings of being overwhelmed, chronic irritability, and physical symptoms like headaches, stomach problems, " +
                "and muscle tension. Severe stress can impair one's ability to function effectively in daily life, affecting work performance, " +
                "relationships, and overall health. It requires comprehensive management strategies, including relaxation techniques, lifestyle adjustments, and sometimes professional help.";


        switch (type) {
            case "anxiety":
                explanation = anxietyExplanation;
                break;
            case "insomnia":
                explanation = insomniaExplanation;
                break;
            case "depression":
                explanation = depressionExplanation;
                break;
            case "stress":
                explanation = stressExplanation;
                break;
            case "panic disorder":
                explanation = panicExplanation;
                break;
        }



        if (totalRating >= 0 && totalRating <= 4) {
            severity = "None";
            switch (type) {
                case "anxiety":
                    suggestion = "";
                    break;
                case "insomnia":
                    suggestion = "";
                    break;
                case "depression":
                    suggestion = "";
                    break;
                case "stress":
                    suggestion = "";
                    break;
                case "panic disorder":
                    suggestion = "";
                    break;
            }

        }
        else if (totalRating >= 5 && totalRating <= 10) {
            severity = "Mild";
            switch (type) {
                case "anxiety":
                    suggestion = "Consider practicing mindfulness and relaxation techniques.";
                    break;
                case "insomnia":
                    suggestion = "Suggest maintaining a regular sleep schedule and reducing screen time before bed.";
                    break;
                case "depression":
                    suggestion = "Encourage engaging in enjoyable activities and practicing gratitude.";
                    break;
                case "stress":
                    suggestion = "Recommend stress management techniques such as yoga or meditation.";
                    break;
                case "panic disorder":
                    suggestion = "Suggest learning and practicing relaxation techniques and breathing exercises.";
                    break;
            }
        } else if (totalRating >= 11 && totalRating <= 15) {
            severity = "Moderate";
            switch (type) {
                case "anxiety":
                    suggestion = "Suggest regular exercise and speaking with a counselor.";
                    break;
                case "insomnia":
                    suggestion = "Recommend cognitive behavioral therapy for insomnia (CBT-I) and consulting a doctor.";
                    break;
                case "depression":
                    suggestion = "Suggest talking to a therapist and possibly joining a support group.";
                    break;
                case "stress":
                    suggestion = "Advise time management strategies and possibly seeing a counselor.";
                    break;
                case "panic disorder":
                    suggestion = "Recommend therapy, such as cognitive-behavioral therapy (CBT), to address panic symptoms.";
                    break;
            }
        } else if (totalRating >= 16 && totalRating <= 20) {
            severity = "Severe";
            switch (type) {
                case "anxiety":
                    suggestion = "Recommend consulting a mental health professional and possibly medication.";
                    break;
                case "insomnia":
                    suggestion = "Strongly advise seeing a sleep specialist and discussing potential medication.";
                    break;
                case "depression":
                    suggestion = "Urge consulting a psychiatrist for comprehensive treatment including medication.";
                    break;
                case "stress":
                    suggestion = "Suggest a thorough evaluation by a mental health professional for tailored interventions.";
                    break;
                case "panic disorder":
                    suggestion = "Strongly advise consulting a mental health professional for a comprehensive treatment plan, possibly including medication.";
                    break;
            }
        }

        System.out.println(type + " Severity: " + severity);
        System.out.println("Explanation of the Condition: " + explanation);
        System.out.println("Suggestion: " + suggestion);
        System.out.println(" ");

    }
}