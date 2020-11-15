package homework_testing;

public class MultiplicationTable { 
    public static String table(int x)
    {
        String tb = new String();
        if (x < 10) 
            tb = "   " + x;
        else if (x < 100)
            tb = "  " + x;
        else if (x >= 100)
            tb = " " + x;

        return tb;
    }

    public static String tableHead(int x)
    {
        String hd = new String();
        if (x < 10)
            hd = " " + x;
        if (x >= 10)
            hd = "" + x;

        return hd;
    }

    public static void main(String args[])
    {
        long begin = System.currentTimeMillis();
        int size = 12;
        
        System.out.print("  | ");
        for (int i = 1; i <= size; i++)
        {
            System.out.print(table(i));
        }
        System.out.println();

        System.out.print("--+-");
        for (int i = 1; i <= size; i++)
        {
            System.out.print("----");
        }
        System.out.println();

        for (int i = 1; i <= size; i++)
        {
            System.out.print(tableHead(i) + "| ");
            for (int j = 1; j <= size; j++)
            {
                for (int k = 1; k < i; k++)
                    System.out.print("    ");
                for (j = i; j <= size ; j++)
                    System.out.print(table(i*j));
            }
            System.out.println();
        }
        long end = System.currentTimeMillis(); 
        System.out.print("共耗时"+( end - begin )+"毫秒");
    }
}
