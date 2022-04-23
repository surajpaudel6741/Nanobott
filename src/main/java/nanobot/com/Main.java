package nanobot.com;
import nanobot.com.listeners.Coder;
import nanobot.com.listeners.Talks;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
//replit and uptimerobot
public class Main {
    final public static String prefix = "_";
    public static int listCount=0;
    public static JDA client;
    public static boolean runStarted=false;
    public static void main(String[] args)throws Exception {
         client = JDABuilder.createDefault("OTQ5NjUwNzQxNzc2MjQ4ODcz.YiNdLA.ZZHNx7YHNyIShzsN4lc6iiKWXgk")
                .setActivity(Activity.watching("You"))
                 .enableIntents(GatewayIntent.GUILD_MEMBERS)
                 .setChunkingFilter(ChunkingFilter.ALL)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .build();
            client.addEventListener(new Talks());
            Coder[] coder = new Coder[100];

    }



}
