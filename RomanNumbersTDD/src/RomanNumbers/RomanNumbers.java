package RomanNumbers;

public class RomanNumbers {

	public String generate(int number) {
		int auxNumber = number;
		if (auxNumber <= 0 || auxNumber > 200) {
			throw new IllegalArgumentException("No se puede obtener numero romano de " + auxNumber);
		}

		String romanNumber = "";
		
		if(auxNumber == 200) {
			romanNumber += "C";
			auxNumber -= 100;
		}
		
		if(auxNumber >= 100 && auxNumber <= 199) {
			romanNumber += "C";
			auxNumber -= 100;	
		}

		if (auxNumber >= 50 && auxNumber <= 89) {
			romanNumber += "L";
			auxNumber -= 50;
		}

		int romanTensNumber = (int) auxNumber / 10;
		int unit = auxNumber % 10;

		if (auxNumber >= 0 && auxNumber <= 39) {
			for (int i = 1; i <= romanTensNumber; i++) {
				romanNumber += "X";
			}
		} else if (auxNumber <= 49) {
			romanNumber = "XL";
		} else if (auxNumber >= 90 && auxNumber <= 99) {
			romanNumber = "XC";
		}

		switch (unit) {
		case 1:
			romanNumber += "I";
			break;
		case 2:
			romanNumber += "II";
			break;
		case 3:
			romanNumber += "III";
			break;
		case 4:
			romanNumber += "IV";
			break;
		case 5:
			romanNumber += "V";
			break;
		case 6:
			romanNumber += "VI";
			break;
		case 7:
			romanNumber += "VII";
			break;
		case 8:
			romanNumber += "VIII";
			break;
		case 9:
			romanNumber += "IX";
			break;
		case 10:
			romanNumber += "X";
			break;
		default:
			romanNumber += "";
			break;
		}

		return romanNumber;
	}
}
