
/**
 * test stack and queue
 * 
 * Tam Duong 
 * 4/28/2014
 */
public class client
{
    public static void main(String[] args)
    {
        Stack<String> a = new NaughtyLinkedListStack<>();
        Queue<String> b = new NaughtyArrayQueue<>();
        
        System.out.println(System.currentTimeMillis());
        b.enqueue("o");
        b.enqueue("l");
        b.enqueue("l");
        b.enqueue("e");
        b.enqueue("h");
        System.out.println(b);
        System.out.println(b.dequeue());
        System.out.println(b);
        System.out.println(System.currentTimeMillis());
        
        System.out.println("\n");
        
        System.out.println(System.currentTimeMillis());
        a.push("rice");
        a.push("curry");
        a.push("duck");
        a.push("spoon");
        a.push("soup");
        a.push("me");
        a.push("AWESOME");
        
         while (!a.isEmpty()) {
            System.out.println(a.pop());
        }
        
        System.out.println(System.currentTimeMillis());
    }
}
