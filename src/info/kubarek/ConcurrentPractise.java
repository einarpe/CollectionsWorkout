package info.kubarek;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentPractise
{
    /** Value to be decremented and inremented in the same time. */
    volatile int value = 0;
    
    volatile boolean isSynchronized;
    
    public static void main(String[] args) throws Exception
    {
        assert args != null : "args cannot be null.";
        
        final int THREADZ = 1000;
        List<Thread> threads = new ArrayList<Thread>(THREADZ);
        for (int i = 0; i < THREADZ; i++)
        {
            Thread t = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        ConcurrentPractise cp = new ConcurrentPractise();
                        cp.isSynchronized = args.length > 0 ? Boolean.parseBoolean(args[0]) : false;
                        Thread a = new Thread(cp::adder);
                        Thread b = new Thread(cp::subtracter);
                        a.start();
                        b.start();
                        a.join();
                        b.join();
                        
                        if (cp.value != 0)
                            throw new Exception("Some value is " + cp.value + "!");
                    }
                    catch (Exception ex)
                    {
                        System.out.println(ex);
                    }
                }
            });
            threads.add(t);
        }
        
        System.out.println("Starting.");
        
        for (Thread x : threads)
            x.start();
        
        for (Thread x : threads)
            x.join();
        
        System.out.println("Done.");
    }
    
    int steps = 111;
    
    void adder()
    {
        for (int i = 0; i < steps; i++)
        {
            if (isSynchronized)
                synchronized(this) 
                {
                    value++;
                }
            else
                value++;
        }
    }
    
    void subtracter()
    {
        for (int i = 0; i < steps; i++)
        {
            if (isSynchronized)
                synchronized(this) 
                {
                    value--;
                }
            else
                value--;
        }
    }
    /*
     * Dodajmy komentarz na gałęzi master. 
     */
    
    /**
     * Kolejny komentarz.
     */
    

}
