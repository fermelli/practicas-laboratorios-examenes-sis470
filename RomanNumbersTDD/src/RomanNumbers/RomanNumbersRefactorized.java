package RomanNumbers;

public class RomanNumbersRefactorized {

	public String generate(int number) {
		int auxNumber = number;
		if (auxNumber <= 0 || auxNumber > 200) {
			throw new IllegalArgumentException("No se puede obtener numero romano de " + auxNumber);
		}

		int hundreds = (int) auxNumber / 100;
		auxNumber = auxNumber % 100;
		int tens = (int) auxNumber / 10;
		auxNumber = auxNumber % 10;
		int units = auxNumber;

		String romanNumber = "";

		if (hundreds != 0) {
			for (int i = 1; i <= hundreds; i++) {
				romanNumber += "C";
			}
		}

		if (tens != 0) {
			if (tens >= 5 && tens < 9) {
				romanNumber += "L";
				tens -= 5;
			}

			if (tens == 4) {
				romanNumber += "XL";
			}
			
			if(tens == 9) {
				romanNumber += "XC";
			}

			if (tens <= 3) {
				for (int i = 1; i <= tens; i++) {
					romanNumber += "X";
				}
			}
		}

		switch (units) {
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
