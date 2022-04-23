package nanobot.com.listeners;
import nanobot.com.Main;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import java.util.*;

public class Talks extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        TextChannel textChannel = event.getChannel();

        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Main.prefix + "hello")) {
            event.getMessage().reply("Hi "+event.getAuthor().getName()).queue();
        }
        if (args[0].equalsIgnoreCase(Main.prefix + "start")) {
            if (textChannel.getId().equals("966787364263444521") && !Main.runStarted) {
                Timer timer = new Timer() {
                };
                Calendar date = Calendar.getInstance();
                date.set(
                        Calendar.DAY_OF_WEEK,
                        Calendar.SUNDAY
                );
                date.set(Calendar.HOUR, 0);
                date.set(Calendar.MINUTE, 0);
                date.set(Calendar.SECOND, 0);
                date.set(Calendar.MILLISECOND, 0);
                timer.schedule(
                        new taskGen(),
                        date.getTime(),
                        1000 * 10);
            } else {

                textChannel.sendMessage("Inappropriate Channel Or it is already running").queue();
            }
        }
        if (args[0].equalsIgnoreCase(Main.prefix + "submit")) {
            if(event.getMessage().getAttachments().isEmpty()){
                event.getChannel().sendMessage("Where is file?").queue();
            }else{
                if (Objects.requireNonNull(event.getMessage().getAttachments().get(0).getFileExtension()).equalsIgnoreCase("c")
                || Objects.requireNonNull(event.getMessage().getAttachments().get(0).getFileExtension()).equalsIgnoreCase("java")
                || Objects.requireNonNull(event.getMessage().getAttachments().get(0).getFileExtension()).equalsIgnoreCase("cpp")
                ) {
                event.getChannel().sendMessage("Yay you got 1 point").queue();
                }
            }

        }
        }


    }


