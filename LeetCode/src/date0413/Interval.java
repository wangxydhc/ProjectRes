package date0413;

import java.util.Comparator;

public class Interval implements Comparator<Interval>{
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public int compare(Interval o1, Interval o2) {
		int i1=o1.start;
		int i2=o2.start;
		if (i1>i2)
			return -1;
		if (i1<i2)
			return 1;
		return 0;
	}


}
