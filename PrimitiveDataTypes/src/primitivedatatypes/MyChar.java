package primitivedatatypes;

public class MyChar {

    private char ch;

    public MyChar(char ch) {
        this.ch = ch;
    }

    public static void printLowerCaseAlphabets() {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.println(ch);
        }
    }

    public static void printUpperCaseAlphabets() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println(ch);
        }
    }

    public boolean isVowel() {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }

    public boolean isDigit() {
        if (ch >= 48 && ch <= 57)
            return true;

        return false;
    }

    public boolean isAlphabet() {
        if (ch >= 97 && ch <= 122)
            return true;
        if (ch >= 65 && ch <= 90)
            return true;
        return false;
    }

    public boolean isConsonant() {
        //Alphabet && not Vowel
        //! a,e,i,o,u
        if (isAlphabet() && !isVowel())
            return true;
        return false;
    }
}
