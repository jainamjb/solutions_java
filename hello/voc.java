public class voc
{
    public static void main(String args[])
    {
        char ch;
		int val=parseInt(args[]);
		ch=(char)val;
        if(ch=='a' || ch=='A' || ch=='e' || ch=='E' ||
        ch=='i' || ch=='I' || ch=='o' || ch=='O' ||
        ch=='u' || ch=='U')
        {
            System.out.print("This is a Vowel\n");
        }
        else
        {
            System.out.print("This is a consonant\n");
        }
    }
}