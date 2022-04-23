package nanobot.com.listeners;

import net.dv8tion.jda.api.entities.Member;

public class Coder {
    private Member member;
    private int points;

    public Coder(Member member, int points) {
        this.member = member;
        this.points = points;
    }

    // getter
    public Member getName() {
        return member;
    }

    public int getPoint() {
        return points;
    }

    // setter
    public void setName(Member member) {
        this.member = member;
    }

    public void setPoint(int points) {
        this.points = points;
    }
}
