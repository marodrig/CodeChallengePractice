import java.util.*;

public class Solution {
    private Map<String, Integer> magazineMap = new HashMap<>();
    // private Map<String, Integer> noteMap = new HashMap<>();
    private String [] magazine;
    private String [] note;

    public Solution(String magazine, String note) {
        //Constructor for Solution class.
        this.magazine = magazine.split(" ");
        this.note = note.split(" ");
    }

    // Method used to decide if its possible to create ransom note.
    public boolean solve() {
        for(String word: this.magazine){
            if(this.magazineMap.isEmpty()){
                this.magazineMap.put(word, 1);
            }else if (this.magazineMap.containsKey(word)){
                this.magazineMap.put(word, (magazineMap.get(word) + 1));
            }else{
                this.magazineMap.put(word, 1);
            }
        }

        for(String word: this.note){
            boolean hashMapContainsWord = this.magazineMap.containsKey(word);
            int wordFrequency = this.magazineMap.get(word);
            if(hashMapContainsWord && wordFrequency > 0){
                this.magazineMap.put(word, wordFrequency - 1);
            }else if ( wordFrequency == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        boolean answer;

        // Eat whitespace to beginning of next line

        if (m >= n){
            scanner.nextLine();

            Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
            scanner.close();
            answer = s.solve();
        }else{
            answer = false;
        }
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
