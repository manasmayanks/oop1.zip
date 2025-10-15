public class Huntingtons {
    public static int maxRepeats(String dna) {
        int max = 0;
        int count = 0;
        for (int i = 0; i <= dna.length() - 3; i++) {
            if (dna.substring(i, i + 3).equals("CAG")) {
                count++;
                i += 2;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    public static String classify(int repeats) {
        if (repeats <= 9) return "not human";
        else if (repeats <= 35) return "normal";
        else if (repeats <= 39) return "high risk";
        else return "Huntington’s";
    }

    public static void main(String[] args) {
        String dna = StdIn.readAll().replaceAll("\\s", "");
        int repeats = maxRepeats(dna);
        System.out.println("max repeats = " + repeats);
        System.out.println(classify(repeats));
    }
}
