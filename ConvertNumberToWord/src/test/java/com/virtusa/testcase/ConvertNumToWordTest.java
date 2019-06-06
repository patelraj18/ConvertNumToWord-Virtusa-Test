package com.virtusa.testcase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.virtusa.test.ConvertNumToWord;
import com.virtusa.test.ConvertNumToWordException;

public class ConvertNumToWordTest {

	@Test
    public void testSimpleInt() throws ConvertNumToWordException {
		ConvertNumToWord test = Mockito.mock(ConvertNumToWord.class);
        when(test.convert(0)).thenReturn("zero");
        assertEquals(test.convert(0), "zero");
    }
	
	@Test
    public void testNull() throws ConvertNumToWordException {
		ConvertNumToWord test = Mockito.mock(ConvertNumToWord.class);
        when(test.convert(123)).thenReturn("one hundred and twenty three");
        assertEquals(test.convert(123), "one hundred and twenty three");
    }
}
