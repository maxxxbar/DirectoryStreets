import mainscreen.Main;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class App {

    public static void main(String[] args) {
        //System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Main.showResult(Main.getFileNameFromScanner());
    }

}

