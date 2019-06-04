public class StringParser {

    static String string = "asfa[ofsa[ofba[ofbaosfab[f";

    static String reverse(String str){

        String changedString = "";
        for (int i = 10; i > 2; i--){
            changedString = changedString + string.charAt(i);
        }
        return changedString;
    }

    public static void main(String[] args) {

        System.out.println("before operations: " + string);
        string = string.replace("[", "");
        System.out.println(reverse(string));
    }
}
