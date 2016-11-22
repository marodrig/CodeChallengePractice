
    /*
    /A kidnapper wrote a ransom note but is worried it will be 
    /traced back to him. He found a magazine and wants to know if he can cut out whole 
    /words from it and use them to create an untraceable replica of his ransom note. 
    /The words in his note are case-sensitive and he must use whole words available in the magazine, 
    /meaning he cannot use substrings or concatenation to create the words he needs.
    /Given the words in the magazine and the words in the ransom note, print Yes if he can replicate 
    /his ransom note exactly using whole words from the magazine; otherwise, print No.

    Input Format

    /The first line contains two space-separated integers describing the respective values of  (the number of words in the magazine) and  (the number of words in the ransom note). 
    /The second line contains  space-separated strings denoting the words present in the magazine. 
    /The third line contains  space-separated strings denoting the words present in the ransom note.
    /
    */
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
