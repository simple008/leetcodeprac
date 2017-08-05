package practice;

/**
 * Created by lpeiz on 2017/3/19.
 */
public class behavior {
    public static void  main(String []args){
        Human chinese =new Human();
        Human.chineseBrain perform=chinese.new chineseBrain();
    }
}
class Human{
    private String word="WE ";
    protected  void en(){
        System.out.println("yes, ");
    }
    class chineseBrain{
        String word="are ";
        chineseBrain(){
            Human.this.en();
//            String word="Chinese";
            System.out.println(word);
        }
    }
}
