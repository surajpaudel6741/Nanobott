package nanobot.com;
import nanobot.com.listeners.Talks;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
//replit and uptimerobot
public class Main {
    public static String prefix = "_";
    public static int listCount=0;
    public static JDA client;
    public static boolean runStarted=false;
    public static void main(String[] args)throws Exception {
         client = JDABuilder.createDefault("OTQ5NjUwNzQxNzc2MjQ4ODcz.YiNdLA.ZZHNx7YHNyIShzsN4lc6iiKWXgk")
                .setActivity(Activity.watching("You"))
                .build();
            client.addEventListener(new Talks());
    }



}
