import java.util.Scanner;
public class Building implements HowToBuild{
    public static void main(String[] args) {
        Building b = new Building();
        b.StartBuilding();
    }
    Scanner in = new Scanner(System.in);
    public void StartBuilding() {
        StageList list = new StageList();
        list.CreateList();
        System.out.println("Start a basement");
        Stage temp = list.next();
        boolean flag = true;
        while (flag) {
            System.out.println("Start a new stage? 1-Yes, 2-No");
            int ans = in.nextInt();
            if (ans == 1) {
                try {
                    temp = list.next();
                } catch (NullPointerException e) {
                    System.out.println("ooyy");
                    temp = list.prev();
                }
            }
            else {
                flag = false;
                try {
                    FinishBuilding(temp);
                } catch (NullPointerException e) {
                    System.out.println("ooyy");
                }
            }
        }
    }
    public void FinishBuilding(Stage l) {
            if (l.status != Status.done) {
                System.out.println("Ваша стройка не завершена");
                //a.status = Status.rejected;
            }
            else {
                System.out.println("Ура-ура, Ваша стройка завершена!");
                //a.status = Status.done;
            }
        }
    }
