package com.test;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.impl.CalculatorServiceImpl;
import com.interfaces.DataService;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {
	@InjectMocks
	private CalculatorServiceImpl calculatorService;
	
	@Mock
	private DataService dataService;
	
	@Test
	public void testCalculateAvg_simpleInput() {
		when(dataService.getListOfNumbers()).thenReturn(new int[] {1,2,3,4,5});
		assertEquals(3.0, calculatorService.calculateAverage(), .0);
	}
	
	@Test
    public void testCalculateAvg_emptyInput() {
        when(dataService.getListOfNumbers()).thenReturn(new int[] {});
        assertEquals(0.0, calculatorService.calculateAverage(), .01);
    }
	
	@Test
    public void testCalculateAvg_singleInput() {
        when(dataService.getListOfNumbers()).thenReturn(new int[] { 1 });
        assertEquals(1.0, calculatorService.calculateAverage(), .01);
    }
}
