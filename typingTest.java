package Test;
import java.util.*;

public class typingTest{
    public static void run() {
        double nToSecs = 0.000000001;
        long now;
        long timeDiff;
        Scanner in = new Scanner(System.in);
        String[] officeQuotes = {"I'm not superstitious but I am a little stitious.",
                "Oh God, my mind is going a mile an hour.",
                "Whenever I'm about to do something I think 'Would an idiot do that?' And if they would, I do not do that thing.",
                "Would I rather be feared or loved? Easy. Both. I want people to be afraid of how much they love me.",
                "Shut up about the sun! Shut up about the sun!",
                "In the '60s, I made love to many, many women, often outdoors in the rain. It's possible a man could have slipped in there. There would be no way of knowing."};
        String[] bojackQuotes = {"There are some people you can't save. 'Cause those people will thrash and struggle and try to take you down with them",
                "BoJack, when you get sad, your un straight ahead and you keep running forward, no matter what... Don't you ever stop running and don't you ever look behind you... All that exists is what's ahead.",
                "Sometimes life's a b**** and then you keep living.",
                "Same things that always happens. You didn't know me and then you feel in love with me. And, now you know me.",
                "It gets easier. Everyday, it gets a little easier. But you gotta do it everyday — that's the hard part. But it does get easier.",
                "When you look at somebody through rose-colored glasses, all the red flags just look like flags.",
                "The rules are different for women. If you're a woman and you save the day, nobody loves you. The more powerful you are, the more they'll take your power away."};
        String[] avatarQuotes = {"Life happens wherever you are, whether you make it or not.",
                "Pride is not the opposite of shame, but it's source.",
                "It's easy to do nothing, it's hard to forgive.",
                "Drink cactus juice. It'll quench ya. Nothing is quenchier. It's the quenchiest!",
                "Sometimes life is like this tunnel. You can’t always see the light at the end of the tunnel, but if you keep moving, you will come to a better place.",
                "My first girlfriend turned into the Moon. That's rough, buddy.",
                "Secret Tunnel! Secret Tunnel! Through the mountains! Secret, secret, secret, secret tunnel",
                "Oh, no! I knew it was only a matter of time! Appa ate Momo! Momo, I’m coming for you, buddy!",
                "Look! There it is! [Everyone turns around excitedly, but it's not there.] That's what it will sound like when one of you spots it.",
                "Sick of tea? That's like being sick of breathing."};
        String[] brook99Quotes = {"Sarge, with all due respect, I am gonna completely ignore everything you just said.",
                "The English language can not fully capture the depth and complexity of my thoughts, so I’m incorporating emojis into my speech to better express myself. Winky face.",
                "Cool, cool, cool, cool, cool. No doubt, no doubt, no doubt.",
                "I’m playing Kwazy Cupcakes, I’m hydrated as hell, and I’m listening to Sheryl Crow. I’ve got my own party going on.",
                "Jake, piece of advice: Just give up. It’s the Boyle way. It’s why our family crest is a white flag.",
                "OK, no hard feelings, but I hate you. Not joking. Bye.",
                "Hello, unsolved case. Do you bring me joy? No, because you’re boring and you’re too hard. See ya.",
                "With all due respect, that pigeon is clearly a Ray J. Hi, Gina Linetti, the human form of the 100 Emoji.",
                "It’s Gina’s phone. Leave me a voice mail. I won’t check it ’cause it’s not 1993.",
                "The only thing I’m not good at is modesty, because I’m great at it.",
                "The doctor said all my bleeding was internal. That's where the blood's supposed to be."};
        String[][] allQuotes = {officeQuotes,bojackQuotes, avatarQuotes, brook99Quotes};

        System.out.println("Welcome to iCrastinate Pro Type, where you can test your typing speed with your favorite quotes from your favorite TV shows!");
        System.out.println("Feel free to correct your mistakes but understand that this will improve accuracy but decrease your speed!");
        boolean again = true;
        while(again) {
            System.out.println("Which show would you like? (1) The Office, (2) Bojack Horseman, (3)Avatar the Last Airbender, (4)Brooklyn Nine-Nine");
            int show = in.nextInt() - 1;
            in.nextLine();

            String[] chosen = allQuotes[show];
            int rand = (int) (Math.random() * chosen.length);
            String chosen1 = chosen[rand];
            int wordCount = 1;
            for (int i = 0; i < chosen1.length(); i++) {
                if (chosen1.substring(i, i + 1).equals(" ")) {
                    wordCount++;
                }
            }


            System.out.println("Now begin! Type this quote out!");
            System.out.println(chosen1);
            long start = System.nanoTime();
            double mistakeCount = 0;
            String test = in.nextLine();


            now = System.nanoTime();
            timeDiff = now - start;

            if(chosen1.equals(test))
                mistakeCount = 0;
            else {
                String[] chosen2 = chosen1.split(" ");
                String[] test1 = test.split(" ");
                int k = -1;
                for (int i = 0; i < chosen2.length; i++) {
                    k++;
                    boolean combined = false;
                    if (k == i && i >= test1.length){
                        mistakeCount += chosen2.length - test1.length;
                        System.out.println("too short");
                    }
                    else if(chosen2[i].equals(test1[k])){}
                    else{
                        for(int j = 0; j < chosen2[i].length(); j++){
                            if(i+1 < chosen2.length && test1[k].equals(chosen2[i] + chosen2[i+1])) { //two words combined
                                mistakeCount++;
                                combined = true;
                                i++;
                                break;
                            }
                            if(j >= test1[k].length())
                                mistakeCount++;
                            else if(!chosen2[i].substring(j,j+1).equals(test1[k].substring(j,j+1)))
                                mistakeCount++;
                        }

                        if(i==k && !combined && test1[k].length() > chosen2[i].length())
                            mistakeCount += test1[k].length() - chosen2[i].length();
                    }
                }
                if (chosen2.length < test1.length) {
                    for(int i = test1.length - 1; i >= chosen2.length; i--){
                        for(int j = 0; j < test1[i].length(); j++){
                            mistakeCount++;
                        }
                    }
                }

            }

            System.out.println("WPM: " + (int) (wordCount / (timeDiff * nToSecs) * 60));
            System.out.println("Acc: " + (int)(100 - 100*(mistakeCount / chosen1.length())) + "%");

            System.out.println("Would you like to take another test?(yes/no)");
            String input = in.nextLine();
            if(input.equals("no")) {
                System.out.println("Thank you for playing!");
                again = false;
            }
        }
    }
}
