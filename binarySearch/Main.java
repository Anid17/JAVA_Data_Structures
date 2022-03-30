package binarySearch;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		IP_Address[] ipAddresses = new IP_Address[10000];
		int i = 0;
		
		BufferedReader csvReader = new BufferedReader(new FileReader("src/sortedipaddresses.csv"));
		while (i < ipAddresses.length) {
			
			String row = csvReader.readLine();
			
			row = row.replace(", ", " ");
			
		    String[] rowSplit = row.split(",");
		   
		   
		    ipAddresses[i] = new IP_Address(Long.parseLong(rowSplit[0].substring(1, rowSplit[0].length()-1)), 
		    		Long.parseLong(rowSplit[1].substring(1, rowSplit[1].length()-1)),
					rowSplit[2].substring(1, rowSplit[2].length()-1),
					rowSplit[3].substring(1, rowSplit[3].length()-1),
					rowSplit[4].substring(1, rowSplit[4].length()-1),
					rowSplit[5].substring(1, rowSplit[5].length()-1));
		    i++;
	
		}
		
		csvReader.close();
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter IP address for searching: ");
		String address = reader.nextLine();
		reader.close();
		
		long number = convert(address);
		
		find(ipAddresses,number);
		
	}
	
	public static long convert(String address) {
		String[] ipAddress = address.split("\\.");
		long w = 16777216*Long.parseLong(ipAddress[0]);
		long x = 65536*Long.parseLong(ipAddress[1]);
		long y = 256*Long.parseLong(ipAddress[2]);
		long z = Long.parseLong(ipAddress[3]);
		long ipNumber = w + x + y + z;
		return ipNumber;
	}
	
	public static void find(IP_Address[] ipAddresses, Long number) {
		int searchResult = binarySearch.search(ipAddresses, number);
		if (searchResult == -1) {
			System.out.println("Not found!");
		}
		else {
			System.out.println("Contry Code: " + ipAddresses[searchResult].countryCode + ", " +
					   "Country Name: " + ipAddresses[searchResult].countryName + ", " + 
					   "Region Name: " + ipAddresses[searchResult].regionName + ", " + 
					   "City Name: " + ipAddresses[searchResult].cityName);
		}
	}

}
