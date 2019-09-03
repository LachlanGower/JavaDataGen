import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Driver
{
	public static final int LOW = 500;//density (less edges than verts)
	public static final int MED = 2000;//density (same edges as verts)
	public static final int HI = 8500;//density (more edges as verts)

	public static void main(String[] args)
	{
		int density = MED;
		System.out.println("Working");
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(new File("MedDens2.in"));
			System.out.println("file created");

		} catch (FileNotFoundException e){}
		
		ArrayList<Integer> verts = new ArrayList<Integer>();
		System.out.println("file created");

		for(int vert = 1; vert <= 2000;vert++) {
			int vertName = (int) (Math.random()*10000) + 1;
			if(!verts.contains(vertName))
				verts.add(vertName);
			else
				vert--;
		}
		for(int vert : verts)
			pw.println("AV " + vert);
		ArrayList<String> edges = new ArrayList<String>();
		
		for(int edge = 1;edge < density;edge++) {
			System.out.println("creating edges" + edge);
			int vert1 = verts.get((int) (Math.random() * 2000));
			int vert2 = verts.get((int) (Math.random() * 2000));
			String edgeName = vert1 + " " + vert2 + " ";
			if(!edges.contains(edgeName))
				edges.add(edgeName);
			else
				edge--;
		}
		for(String edge : edges)
			pw.println("AE " + edge + (int) (Math.random() * 40) + 1);

		pw.flush();
		pw.close();
	}

}
