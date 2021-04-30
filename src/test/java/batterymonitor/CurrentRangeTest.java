package batterymonitor;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CurrentRangeTest {

	@Test
	public void givenSamplesAsNull_whenChargingSession_thenReturnNull() {
		List<Integer> periodicCurrentSamples = null;

		assertNull(CurrentRange.detectRangeAndReadingsCount(periodicCurrentSamples));
	}

	@Test
	public void givenSamplesAsEmpty_whenChargingSession_thenReturnEmptyString() {
		List<Integer> periodicCurrentSamples = Arrays.asList();

		assertNull(CurrentRange.detectRangeAndReadingsCount(periodicCurrentSamples));
	}

	@Test
	public void givenSamplesHavingContinuousRange_whenChargingSession_thenReturnRangeAndReadings() {
		List<Integer> periodicCurrentSamples = Arrays.asList(10, 3, 3, 5, 4, 11, 12);

		List<RangeAndReading> rangeAndReadingList = CurrentRange.detectRangeAndReadingsCount(periodicCurrentSamples);

		RangeAndReading rangeAndReading = new RangeAndReading("3,5", 4);

		assertEquals(rangeAndReading.range, rangeAndReadingList.get(0).range);

		RangeAndReading secondRangeAndReading = new RangeAndReading("10,12", 3);

		assertEquals(secondRangeAndReading.range, rangeAndReadingList.get(1).range);
	}

}
