import java.util.Scanner;
public class Encoder {
    static char[] r_char = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','(',')','*','+',',','-','.','/'};


    public static int findIndex(char characters) {
        for (int j = 0; j < r_char.length; j++) {
            if (r_char[j] == characters) {
                return j;
            }
        }
        return 0;
    }
    public static void main(String [] Args) {
        Encoder s = new Encoder();
        
        String text = s.plainText();
        String encodeText=s.encode(text);
        System.out.println(encodeText);
        String dencodText = s.decode(encodeText);
        System.out.println(dencodText);


    }

    public  String plainText() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your text: ");
		String plainText = scanner.nextLine();
		plainText = plainText.trim().toUpperCase();
		return plainText;
    }

    public  String encode (String text){
        Scanner scanner = new Scanner(System.in);
        String encodText="";
        System.out.println("Please enter your reference characters to encode:");
       
        String k = scanner.nextLine().toUpperCase();       
        int key = findIndex(k.charAt(0));       
        for (int i = 0; i < text.length(); i++){
            char pi = text.charAt(i);
           
                if (pi==' ') 
                {
                
                    encodText+=" ";
                }
                else{
                    if (findIndex(pi) - key < 0){
                    encodText+=(r_char[findIndex(pi) - key + 44]);
                    }
                    else
                    {
                        encodText+=(r_char[findIndex(pi) - key]);
                    }
                }
           
            }

          return k+encodText;  
    }

    public String decode (String encodedText){
        String dencodText="";
        char k = encodedText.charAt(0);
        int key = findIndex(k);  
        
        for (int i = 1; i < encodedText.length(); i++)
        {
            char pi = encodedText.charAt(i);
            if (pi==' ') 
            {
                dencodText+=" ";
            }
            else
            {
                if (findIndex(pi) + key > 44){
                
                dencodText+=(r_char[findIndex(pi) + key - 44]);
                }
                else
                {
                    dencodText+=(r_char[findIndex(pi) + key]);
                }
            }
            
        }return dencodText;

    }
        
    }

