import java.awt.font.FontRenderContext;

class Problem {
    public static void main(String[] args) {
        boolean modeFound = false;

        for(int i = 0; i < args.length; i++) {

            if(args[i].equals("mode")&&i%2==0) {
                System.out.println(args[i+1]);
                modeFound = true;
            }
        }
        if(!modeFound) {
            System.out.println("default");
        }
    }
}