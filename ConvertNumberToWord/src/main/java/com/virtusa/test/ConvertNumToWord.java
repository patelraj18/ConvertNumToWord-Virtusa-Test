package com.virtusa.test;

import java.text.DecimalFormat;

public class ConvertNumToWord {
	private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	private ConvertNumToWord() {}

	private static String convertLessThanOneThousand(int number) {
		String rem;

		if (number % 100 < 20) {
			rem = numNames[number % 100];
			number /= 100;
		} else {
			rem = numNames[number % 10];
			number /= 10;

			rem = tensNames[number % 10] + rem;
			number /= 10;
		}
		if (number == 0)
			return rem;
		if(rem.isEmpty()) {
			return numNames[number] + " hundred" + rem;
		}else {
			return numNames[number] + " hundred and" + rem;
		}
		
	}

	public String convert(long number) throws ConvertNumToWordException {
		
		try {
			if(number%1 !=0) {
				throw new ConvertNumToWordException("Invalid input");
			}else {
				if (number == 0) {
					return "zero";
				}

				String input = Long.toString(number);

				String mask = "000000000000";
				DecimalFormat df = new DecimalFormat(mask);
				input = df.format(number);

				int billions = Integer.parseInt(input.substring(0, 3));
				int millions = Integer.parseInt(input.substring(3, 6));
				int hundredThousands = Integer.parseInt(input.substring(6, 9));
				int thousands = Integer.parseInt(input.substring(9, 12));

				String fomatBillions, formatMillions, formatHundredThousands, formatThousand;
				
				switch (billions) {
				case 0:
					fomatBillions = "";
					break;
				case 1:
					fomatBillions = convertLessThanOneThousand(billions) + " billion ";
					break;
				default:
					fomatBillions = convertLessThanOneThousand(billions) + " billion ";
				}
				String result = fomatBillions;

				switch (millions) {
				case 0:
					formatMillions = "";
					break;
				case 1:
					formatMillions = convertLessThanOneThousand(millions) + " million ";
					break;
				default:
					formatMillions = convertLessThanOneThousand(millions) + " million ";
				}
				result += formatMillions;

				switch (hundredThousands) {
				case 0:
					formatHundredThousands = "";
					break;
				case 1:
					formatHundredThousands = "one thousand ";
					break;
				default:
					formatHundredThousands = convertLessThanOneThousand(hundredThousands) + " thousand ";
				}
				result += formatHundredThousands;

				
				formatThousand = convertLessThanOneThousand(thousands);
				result += formatThousand;

				// remove extra spaces!
				return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
			}
		}catch(NumberFormatException e) {
			throw e;
		}
	}
}
