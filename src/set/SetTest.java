package set;

/**
 * ClassName:SetTest
 * Package:set
 * Description:
 *
 * @Date:2020/8/12 10:31
 * @Author:xuan
 */
public class SetTest {
    public static void main(String[] args)
    {
        String [] random_s = new String [100];
        HashSet <String> string_set = new HashSet<String>();
        HashSet<String> result = new HashSet<String>();

        for(int i=0; i < 100; i++)
        {
            random_s[i] = randomString(2);
            if(i%20==0 && i!=0)
                System.out.println();
            System.out.print(random_s[i] +" ");
        }

        int previous_length =  0;
        for(int i=0; i<100; i++)
        {
            previous_length =  string_set.size();
            string_set.add(random_s[i]);
            if(string_set.size() == previous_length)
            {
                result.add(random_s[i]);
            }
        }
        System.out.println("\n总共有"+result.size()+"种重复的字符串\n分别是：");
        System.out.print(result);

    }

    private static String randomString(int length) {
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char) i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char) i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char) i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }

}
