package PrivateClass;

class Person {
    private final String name;
    public Person(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}

class Teacher extends Person {
    public Teacher(String name) {
        super(name);
    }
}

class Student extends Person {
    public Student(String name) {
        super(name);
    }
}

interface Class {
    int getExamMark();
    int getFee();
    int getNumOfSessions();
    int getHeldSessions();
    boolean[] getPresence();
    void setRating(int rate);
    String toString();
}

abstract class AbstractClass implements Class {
    public AbstractClass(Teacher t, Student s, int fee, int numOfSessions) {
        this.student = s;
        this.teacher = t;
        this.fee = fee;
        this.numOfSessions = numOfSessions;
        this.presence = new boolean[numOfSessions];
    }
    protected Teacher teacher;
    protected Student student;
    protected int fee, numOfSessions, heldSessions, examMark, teacherRating, studentRating;
    protected boolean[] presence; // its size = numOfSessions

    public int getExamMark() {
        return this.examMark;
    }

    public int getFee() {
        return this.fee;
    }

    public int getNumOfSessions() {
        return this.numOfSessions;
    }

    public int getHeldSessions() {
        return this.heldSessions;
    }

    public boolean[] getPresence() {
        return this.presence;
    }
}

class StudentClass extends AbstractClass {
    public StudentClass(Teacher t, Student s, int fee, int numOfSessions) {
        super(t, s, fee, numOfSessions);
    }

    @Override
    public void setRating(int rate) {
        this.studentRating = rate;
    }

    @Override
    public String toString() {
        return this.teacher.getName();
    }
}

class TeacherClass extends AbstractClass {
    public TeacherClass(Teacher t, Student s, int fee, int numOfSessions) {
        super(t, s, fee, numOfSessions);
    }

    public void setHeldSessions(int sessionNumber) {
        if(sessionNumber > this.heldSessions && sessionNumber <= this.numOfSessions) {
            this.heldSessions = sessionNumber;
        }
    }

    public void setPresence(int sessionsNumber) {
        if(sessionsNumber > 0 && sessionsNumber <= this.numOfSessions) {
            this.presence[sessionsNumber - 1] = true;
        }
        this.setHeldSessions(sessionsNumber);
    }

    public boolean setExamMark(int mark) {
        if(this.heldSessions < this.numOfSessions)
            return false;
        this.examMark = mark;
        return true;
    }

    @Override
    public void setRating(int rate) {
        this.teacherRating = rate;
    }

    @Override
    public String toString() {
        return this.student.getName();
    }
}
