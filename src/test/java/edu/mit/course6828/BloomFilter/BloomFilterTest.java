package edu.mit.course6828.BloomFilter;

import org.junit.Assert;
import org.junit.Test;

import edu.mit.course6828.BloomFilter.BloomFilter;
import edu.mit.course6828.BloomFilter.BloomFilterImpl;
import edu.mit.course6828.BloomFilter.BloomFilterUtils;

public class BloomFilterTest {
	
	@Test
	public void testBasicBloomFilter() {
		
		int n = 1500000; // approximate number of elements in the dataset
		int m = 150000000;
		int k = BloomFilterUtils.calculateOptimalK(m, n);
		System.out.println("Value of optimal k is: "+ k);

		BloomFilter bloomFilter = new BloomFilterImpl(m, k);
		bloomFilter.add("Hello World");		
		boolean isContain = bloomFilter.contains("Hello World");
		Assert.assertTrue("BloomFilter cannot have False Negatives", (isContain == true));
		Assert.assertTrue("The chance this fails should be very rare", (bloomFilter.contains("Hello World 2") == false));
		Assert.assertTrue("The chance this fails should be very rare", (bloomFilter.contains("adfasdfa") == false));

	}
	
}
