package auto.septech.utilities;

import java.util.Random;

public class RandomData {

	private static final char[] poolString = { 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G',
			'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r',
			'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z' };

	private static final char[] poolNumber = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	private Random rnd;

	public RandomData() {
		rnd = new Random();
	}

	public char getChar() {
		return poolString[rnd.nextInt(poolString.length)];
	}

	public char getNumber() {
		return poolNumber[rnd.nextInt(poolNumber.length)];
	}

	/**
	 * get random string
	 * @param length_string
	 * @return
	 */
	public String getStr(int length_string) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length_string; i++)
			sb.append(getChar());
		return new String(sb);
	}

	/**
	 * get random email
	 * @param length_string
	 * @param domain
	 * @return
	 */
	public String getEmail(int length_string, String domain) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length_string; i++)
			sb.append(getChar());
		return new String(sb + "@" + domain + ".auto");
	}

	/**
	 * get random nuber
	 * @param length_string
	 * @return
	 */
	public int getNumber(int length_string) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length_string; i++)
			sb.append(getNumber());

		String abc = new String(sb);
		int numbers = Integer.parseInt(abc);
		return numbers;
	}

	/**
	 * get random number
	 * @param minimum
	 * @param maximum
	 * @return
	 */
	public int getNumber(int minimum, int maximum) {
		return minimum + (int) (Math.random() * ((maximum - minimum) + 1));
	}

	/**
	 * get random latin string
	 * @return random string
	 */
	public String getRandomLatinString(Integer number){
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * get random Japan string
	 * @return random string
	 */
	public String getRandomJapanString(Integer number){
		String temp="いうえおかきくけこさしすせそたちつてとな"
				+ "にぬねのはひふへほまみむめもやゆよらりるれろわをんがぎ"
				+ "ぐげござじずぜぞだぢづでどばびぶべぼぱぴぷぺぽ きゃきゅ"
				+ "きょしゃしゅしょちゃちゅちょにゃにゅにょひゃひゅひょみゃ"
				+ "みゅみょりゃりゅりょぎゃぎゅぎょじゃじゅじょあいうえおかき"
				+ "くけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆ"
				+ "よらりるれろわをんがぎぐげござじずぜぞだぢづでどばびぶべぼぱぴぷぺ"
				+ "ぽ きゃきゅきょしゃしゅしょちゃちゅちょにゃにゅにょひゃひゅひょみゃみゅみょりゃり"
				+ "ゅりょぎゃぎゅぎょじゃじゅじょびゃびゅびょぴゃぴゅぴょアイウエオカキクケコサシス"
				+ "セソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲンガギグゲゴザジズゼ"
				+ "ゾダヂヅデドバビブベボパピプペポキャキュキョシャシュショチャチュチョニャニュニョヒャ"
				+ "ヒュヒョミャミュミョリャリュリョギャギュギョジャジュジョビャビュビョピャピュピョ";
		char[] chars = temp.toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * get a list of random numbers
	 * @return random numbers
	 */
	public String getRandomNumber(Integer number) {
		char[] chars = "0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * Process Random cucumber input
	 * ${} – everything inside will be parsed, strings are comma separated
             numerical value – create random alphanumeric string
       ! – use the string as it is
       N – random numbers
       S – random alphanumeric uppercase latin string
       s – random alphanumeric lowercase latin string
       J – random alphanumeric lowercase japan string
	 * @param value
	 * @return
	 */
	public String processRandomCucumber(String value){
		String retValue="";
		if(value.trim().startsWith("{")){
			Integer lenght=value.split(":").length;
			Integer index=1;
			for(String sub:value.split(":")){
				String temp = sub.substring(sub.indexOf("{")+1,sub.indexOf("}"));
				for (String parts: temp.split(",")){
					parts=parts.trim();
					if(parts.toUpperCase().startsWith("N")){
						retValue=retValue+getRandomNumber(Integer.valueOf(parts.substring(1)));
					}
					if(parts.startsWith("S")){
						retValue=retValue+getRandomLatinString(Integer.valueOf(parts.substring(1))).toUpperCase();
					}
					if(parts.startsWith("s"))
						retValue=retValue+getRandomLatinString(Integer.valueOf(parts.substring(1))).toLowerCase();
					if(parts.toUpperCase().startsWith("J"))
						retValue=retValue+getRandomJapanString(Integer.valueOf(parts.substring(1)));
					if(parts.startsWith("!"))
						retValue=retValue+parts.substring(1);
				}
				if(index<lenght)
					retValue=retValue+",";
				index++;
			}
		}
		else
			retValue=value;
		return retValue;
	}
}
