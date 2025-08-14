public class NeedleAndHashtag {
    public static void main(String[] args) {
        String haystack = "Find the needle in this haystack";
        String needle = "needle";
        if (haystack.contains(needle)) {
            System.out.println("Found the needle in the haystack!");
        } else {
            System.out.println("Needle not found.");
        }
        String phrase = "java programming is fun";
        String hashtag = "#" + phrase.replaceAll("\\s+", "");
        System.out.println("Hashtag: " + hashtag);
    }
}