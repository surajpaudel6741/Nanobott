package nanobot.com.listeners;
import nanobot.com.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
public class taskGen extends TimerTask {
    Projects project = new Projects();
    public void run() {
        Main.runStarted = true;
        try {
            ArrayList<String> list = project.fileReader();
            EmbedBuilder builder = new EmbedBuilder();
            java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
            builder.setTitle("Project no ["+Main.listCount+"]");
            builder.setDescription("Date: "+ date+" \t\t\t Today's Task");
            builder.addField(Main.listCount+"->",list.get(Main.listCount),false);
            builder.setColor(Color.RED);
            builder.setFooter("By Nanobot");
            TextChannel txt = Main.client.getTextChannelById("966787364263444521");
            assert txt != null;
            txt.sendMessageEmbeds(builder.build()).queue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.listCount=Main.listCount+1;
    }

}
 class Projects {
    public ArrayList<String> fileReader() throws Exception {
        File file = new File("https://docs.google.com/document/d/1bDy3o9AWT-bzbWsx4RBfR_V5QsHiUDOwBb__UOvTTfs/edit?usp=sharing");
        FileReader fileReader = new FileReader(file);
        BufferedReader BFR = new BufferedReader(fileReader);
        ArrayList<String> list = new ArrayList<>();
        String line;
        while ((line=BFR.readLine())!=null){
            list.add(line);
        }
        fileReader.close();
        return list;
    }

}