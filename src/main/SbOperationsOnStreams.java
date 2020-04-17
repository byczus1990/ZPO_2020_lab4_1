package main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SbOperationsOnStreams {

	
	private String fileName = "c://dane.txt";
    private Charset charset = Charset.forName("Cp1252");
	private List<String> plList = new ArrayList<>();
	private List<Integer> intList = new ArrayList<Integer>();
	private int czCount = 0, plCount = 0, deCount = 0, usCount = 0, sumOfHighest, sumOfLowest; 

	private void countNumberOfPeopleInEachCountry()
    {
    	try (Stream<String> stream = Files.lines(Paths.get(fileName), charset)) {			
    		
        	stream.forEach(line -> this.countNumbersOfPeopleInEachCountry(line) );

    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    }
	
	public String getNumberOfPeopleFromEachCountry()
	{
		countNumberOfPeopleInEachCountry();
		
		return "PL - " + getPlCount() + ", DE - " + getDeCount() + ", CZ - " + getCzCount() + ", US - " + getUsCount();
	}
	private void getPolishUsers()
    {
			
			try (Stream<String> stream = Files.lines(Paths.get(fileName), charset)) {			
	
				plList = stream
						.filter(line -> line.contains("PL"))
						.collect(Collectors.toList());
	
			} catch (IOException e) {
				e.printStackTrace();
			}
	   }
	
	private void getOnlyNumbersFromString()
	{
		for(int i = 0; i < plList.size(); i++)
		{
			String lString = plList.get(i).replaceAll("[\\D]", "");
			plList.set(i, lString);
		}
	}
	public String getSumOfHighestAndLowestEarnings()
	{
		getPolishUsers();
		getOnlyNumbersFromString();
		
		intList = plList.stream()
				.map(s -> Integer.parseInt(s))
				.sorted()
				.collect(Collectors.toList());
						
		return "Sum of highest earning is equal: " + getSumOfHighest() + "\n" 
				+ "Sum of lowest earning is equal: " + getSumOfLowest() + "\n";
	}
	public int getSumOfHighest()
	{
	 
		sumOfHighest = intList.get(intList.size()-1) + intList.get(intList.size()-2);

		return sumOfHighest;
	}
	
	public int getSumOfLowest()
	{
		 sumOfLowest = intList.get(0) + intList.get(1);

		 return sumOfLowest;
	}
	
	private void countNumbersOfPeopleInEachCountry(String line)
	{
		if(line.contains("PL"))
		{
			plCount++;
		}else if(line.contains("CZ"))
				{
					czCount++;
				}else if(line.contains("DE"))
						{
							deCount++;
						}else if(line.contains("US"))
								{
									usCount++;
								}
	}
	
	public int getCzCount() {
		return czCount;
	}
	
	public int getPlCount() {
		return plCount;
	}
	
	public int getDeCount() {
		return deCount;
	}
	
	public int getUsCount() {
		return usCount;
	}
}