import java.util.Random;

public class RandomArrayCreation {
public int[] randomArrayCreation(int size)
{
	Random random=new Random();
	int[] in=new int[size];
	for(int i=0;i<in.length;i++)
	{
		in[i]=random.nextInt(100);
		System.out.println("no."+(i+1)+" : "+in[i]);
	}
	return in;		
}
public static void main(String[] args) {
	new RandomArrayCreation().randomArrayCreation(1000);
}
}
