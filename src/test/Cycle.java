package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cycle {

	private byte[] Array;
	private static List<byte[]> ObtainedCycles = new ArrayList<byte[]>();
		
	private int findTheIndexOfTheMaximum(byte[] buffer) {
		int answ = 0;
		byte max = buffer[0];
		
		for(int i = 1; i < buffer.length; i++) {
			if(buffer[i] > max) {
				answ = i;
				max = buffer[i];
			}						
		}
		return answ;
	}
	
	public Cycle(byte[] array) {
		this.Array = array;
	}
	
	private byte[] theRedistributionOfTheCell(byte[] buffer) {
		byte[] ret = Arrays.copyOf(buffer, buffer.length);
		int index = findTheIndexOfTheMaximum(ret);
		
		byte cellForDistribution = ret[index];
		ret[index] = 0;
		
		while(cellForDistribution != 0) {
			if(++index >= ret.length) {
				index = 0;
			}
			ret[index] += 1;
			cellForDistribution -= 1;
		}
		return ret;
	}
	
	private boolean equals(byte[] array1, byte[] array2)
	{
		for(int i = 0; i < array1.length; i++)
		{
			if(array1 == null || array2 == null) {return false;}
			if(array1[i] != array2[i]) {return false;}			
		}
		return true;
	}

	private int findIdenticalArray(List<byte[]> list, byte[] buf) {
		
		for(int i = 0; i < list.size(); i++) {
			if(equals(list.get(i), buf)) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public ReturnClass findStepsAndLength() {
		int steps = 0;
		ObtainedCycles.add(Array);
		while(steps == 0) {
			byte[] buf = theRedistributionOfTheCell(ObtainedCycles.get(ObtainedCycles.size() - 1));
			steps = findIdenticalArray(ObtainedCycles, buf);
			ObtainedCycles.add(buf);
		}	
		ReturnClass returnClass = new ReturnClass(ObtainedCycles.size() - 1, ObtainedCycles.size() - steps);
		ObtainedCycles.clear();
		return returnClass;
	}
}
