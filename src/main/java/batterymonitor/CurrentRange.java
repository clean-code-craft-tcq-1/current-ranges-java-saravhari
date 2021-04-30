package batterymonitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CurrentRange {

	public static List<RangeAndReading> detectRangeAndReadingsCount(List<Integer> periodicCurrentSamples) {

		List<RangeAndReading> rangeAndReadingList = new ArrayList<>();

		if (periodicCurrentSamples == null || periodicCurrentSamples.isEmpty())
			return null;

		Collections.sort(periodicCurrentSamples);

		int i = 0, reading = 0, nextIndex = 0;
		for (Integer sample : periodicCurrentSamples) {
			nextIndex = (i + 1);
			if ((nextIndex < periodicCurrentSamples.size())
					&& ((sample).equals(periodicCurrentSamples.get(nextIndex) - 1)
							|| (sample).equals(periodicCurrentSamples.get(nextIndex)))) {
				reading++;
			} else {
				String range = periodicCurrentSamples.get(i - reading) + "," + periodicCurrentSamples.get(i);
				RangeAndReading rangeAndReading = new RangeAndReading(range, reading);
				rangeAndReadingList.add(rangeAndReading);
				reading = 0;
			}
			i++;
		}
		return rangeAndReadingList;
	}

}
