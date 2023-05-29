package lesson18;

public class Main {
    public static void main(String[] args) {
        RazrabEmploe r1 = new RazrabEmploe("Vasya",24);
        RazrabEmploe r2 = new RazrabEmploe("Olya",18);

        TestEmploe t1 = new TestEmploe("Kuzya",45);
        TestEmploe t2 = new TestEmploe("Misha",23);

        Team<RazrabEmploe> razrabEmploeTeam = new Team<>();
        Team<TestEmploe> testEmploeTeam = new Team<>("Test Zevs");
        Team<TestEmploe> testEmploeTeam1 = new Team<>("Test Apolone");

        razrabEmploeTeam.addEmploe(r1);
        razrabEmploeTeam.addEmploe(r2);

        testEmploeTeam.addEmploe(t1);
        testEmploeTeam.addEmploe(t2);

        Game.printWinner(testEmploeTeam,testEmploeTeam1);
    }
}
