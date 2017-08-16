import java.util.*;

public class BoardMain {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        BoardManager bm=new BoardManager();
        SetFunc mm=new SetFunc();

        Map<String,Map<String,String>> list=new HashMap<>();
        List<String> boardnumber=new ArrayList<>();
        List<String> comments=new ArrayList<>();

        //다형성을 이용한 switch문 제거
        BoardFunction[] bf=new BoardFunction[7];
        bf[0]=new BoardList();
        bf[1]=new GetPost();
        bf[2]=new AddPost();
        bf[3]=new ModifyPost();
        bf[4]=new DeletePost();
        bf[5]=new AddComment();
        bf[6]=new Exit();

        System.out.println("Welcome to the low-level Board World!");

        list= bm.getBoardList();
        boardnumber=bm.getBoardNumber();

        IOManager io= new IOManager(list,boardnumber);
        GetFunc gf=new GetFunc(list,boardnumber);
        while(true) {
            io.PrintFirst();
            int choice = input.nextInt();
            input.nextLine();
            if(choice<1||choice>7) {
                System.out.println("Enter the number between 1 to 7");
                continue;
            }
            //다형성을 이용한 switch문 제거
            //mm.checkNumber(bf[choice-1],io);
            mm.checkNumber(bf[choice-1],gf);
        }
    }
}
