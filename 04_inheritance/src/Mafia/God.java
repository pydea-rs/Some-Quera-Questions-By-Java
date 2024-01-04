package Mafia;
import javax.print.Doc;

abstract class Player {
    protected String name, voted;

    public Player(String name) {
        this.name = name;
    }

    public String vote() {
        return this.voted;
    }

    public abstract Player action();
}

class Mafia extends Player {
    protected Player nightVote;

    public Mafia(String name) {
        super(name);
    }

    @Override
    public Player action() {
        Godfather.addVote(nightVote.vote());
        return nightVote;
    }
}

class Godfather extends Mafia {
    private static Godfather godfather;
    private Player finalVote;
    private static String[] names;
    private static int size;

    public static Godfather godfather() {
        if(godfather == null)
            godfather = new Godfather();
        return godfather;
    }

    public static String[] addVote(String name) {
        String[] newNames = new String[size + 1];
        if (size > 0) System.arraycopy(names, 0, newNames, 0, size);
        newNames[size++] = name;
        names = newNames;
        return names;
    }

    private Godfather() {
        super("");
    }

    @Override
    public Player action() {
        return null;
    }

    public void setName(String name) {
        godfather.name = name;
    }
}

class Villager extends Player {

    public Villager(String name) {
        super(name);
    }

    @Override
    public Player action() {
        return null;
    }
}

class Doctor extends Villager {
    private static Doctor doctor;
    private Player saved;

    private Doctor() {
        super("");
    }

    @Override
    public Player action() {
        return null;
    }

    public static Doctor doctor() {
        if(doctor == null)
            doctor = new Doctor();
        return doctor;
    }
    public void setName(String name) {
        doctor.name = name;
    }
}
public class God {
    private static Player[] players;
    private static int size;
    public static String killedAtDay() {

    }
}
