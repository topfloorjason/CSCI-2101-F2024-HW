package HW1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of Main");
        // Create an instance of the Pyramid class and call the Output method (see Pyramid.java for more info)
        Pyramid.Output();
        // Create an instance of the Adlibs class and call the story method (see Adlibs.java for more info)
        Adlibs adlibs = new Adlibs();
        String story = adlibs.story("Jason", 19, "Black");
        System.out.println(story);
        // Create an instance of the Replace class and call the charReplace method (see Replace.java for more info)
        Replace replace = new Replace();
                  
        String result = replace.charReplace("I MAKE BREAD", 2, 'T');
        System.out.println(result);
        }
    }