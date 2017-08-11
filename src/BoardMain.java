import java.util.*;

public class BoardMain {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        IOManager io= new IOManager();
        BoardManager bm=new BoardManager();
        SetFunc mm=new SetFunc();

        Map<String,Map<String,String>> list=new HashMap<>();
        List<String> boardnumber=new ArrayList<>();
        List<String> comments=new ArrayList<>();

        //다형성을 이용한 switch문 축소
        BoardFunction[] bf=new BoardFunction[7];
        bf[0]=new BoardList();
        bf[1]=new GetPost();
        bf[2]=new AddPost();
        bf[3]=new ModifyPost();
        bf[4]=new DeletePost();
        bf[5]=new AddComment();
        bf[6]=new Exit();

        System.out.println("Welcome to the low-level Board World!");

        while(true) {
            list= bm.getBoardList();
            boardnumber=bm.getBoardNumber();
            mm.init(list,boardnumber);
            io.PrintFirst();
            int choice = input.nextInt();
            input.nextLine();
            if(choice<1||choice>8) {
                System.out.println("Enter the number between 1 to 6");
                continue;
            }
            //다형성을 이용한 switch문 축소
            mm.checkNumber(bf[choice-1]);
        }
    }
}
