package system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Player {
	// プレイヤーの名前
	private String name;
	// プレイヤーの決めた数字
	private List<Character> num;
	// 特殊技能の使用カウント
	private int spCount;
	// ヒストリー
	private Map<List<Character>, String> history;
	// 標準入力
	public static Scanner scanner = new Scanner(System.in);

	// コンストラクタ（初期化するやつ)
	public Player() {
		this.name = GameSystem.setName();
		num = GameSystem.setNum();
		spCount = 0;
		history = new LinkedHashMap<>();
	}

	// 実際に数字を当てる動作
	public boolean call(Player player) {
		// byteはjavaの予約語だから使えない
		int eat = 0, byted = 0;
		ArrayList<Character> ans = GameSystem.setNum();
		for (int i = 0; i < ans.size(); i++) {
			if (player.getNum().get(i) == ans.get(i))
				eat++;
			else if (player.getNum().contains(ans.get(i)))
				byted++;
		}
		String result = "[ " + eat + "EAT, " + byted + "BYTE ]";
		System.out.printf("%s さんは%sです\n", name, result);
		// ヒストリーに追加
		history.put(ans, result);
		if (eat == 3)
			return true;
		else
			return false;
	}

	// ５以上でHIGH、それより下でLOWを表示するヒント
	public void highlow(Player player) {
		System.out.println("*========* High&Low *========*");
		spCount++;
		for (Character tmp : player.getNum()) {
			if (Character.getNumericValue(tmp) < 5) {
				System.out.println("Low");
			} else {
				System.out.println("HIGH");
			}
		}
	}

	// 一つの値を確認
	public void target(Player player) {
		while (true) {
			String check;
			System.out.println("*========* Target *========*");
			spCount++;
			System.out.print("確認する値を入力して下さい: ");
			check = scanner.next();
			if (check.length() == 1) {
				for (int i = 0; i < player.getNum().size(); i++) {
					if (check.charAt(0) == player.getNum().get(i)) {
						System.out.println((i + 1) + "番目に" + check.charAt(0) + "があります");
						return;
					}
				}
				System.out.println(check.charAt(0) + "はありませんでした");
				break;
			}
		}
	}
	
	
	// ヒストリー参照
	public void showHistory() {
		System.out.println("あなたの今までの推論です");
		for(Map.Entry<List<Character>, String> entry: history.entrySet()) {
			System.out.println(entry.getKey()+ " : " + entry.getValue());
		}
		System.out.println("==============================================");
	}

	// ゲッター
	public String getName() {
		return name;
	}

	public List<Character> getNum() {
		return num;
	}

	public int getSpCount() {
		return spCount;
	}

}
