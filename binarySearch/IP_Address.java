package binarySearch;

public class IP_Address implements Comparable<Long>{

	long ipFrom;
	long ipTo;
	String countryCode;
	String countryName;
	String regionName;
	String cityName;
	

	public IP_Address(long ipFrom, long ipTo, String countryCode, String countryName, String regionName, String cityName) {
		this.ipFrom = ipFrom;
		this.ipTo = ipTo;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.regionName = regionName;
		this.cityName = cityName;
	}
	
	
	@Override
	public int compareTo(Long number) {
		if (this.ipFrom <= number && number <= this.ipTo) {
			return 0;
		}
		else if (this.ipFrom > number) {
			return -1;
		}
		else {
			return 1;
		}
	}
	

	@Override
	public String toString() {
		return "\"" + this.ipFrom + "\"" + "," + 
				"\"" + this.ipTo + "\"" + "," + 
				"\"" + this.countryCode + "\"" + "," + 
				"\"" + this.countryName + "\"" + "," + 
				"\"" + this.regionName + "\"" + "," + 
				"\"" + this.cityName + "\"" ;
	}

}