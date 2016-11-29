/**
 * Created by Tomek on 16.11.2016.
 */
public class Error {
    public static int er(){
        try{
            if(1==1) throw new Exception();
            return 1;
        }
        catch (Exception e){
            return 2;
        }
        finally {
            return 3;
        }
    }
}
