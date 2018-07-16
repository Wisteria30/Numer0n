package system;

import java.util.ArrayList;

public class GameSystem {
	// ルール
	public static void rule() {
		System.out.printf("*〜〜〜〜〜〜〜〜〜〜〜* ルール *〜〜〜〜〜〜〜〜〜〜〜*\n");
		System.out.printf("1.まず互いに自分の値を0~9の範囲で3つ\nそれぞれ被らないように設定します\n");
		System.out.printf("2.3つ相手の値を予想したものを入力する(call)かアイテムを使用(１回限り)します\n");
		System.out.printf("3.当たっているかを判定します\n");
		System.out.printf("4.次のプレイヤーが3,4を行います\n");
		System.out.printf("------------------------------------------------------\n");
		System.out.printf("itemの説明\nitemは1ゲームにつき各プレイヤーはHigh&LowかTarget\nのうちいずれかを一度だけ使用できます\n");
		System.out.printf("High&Low:相手の3つの値がそれぞれ\n0~4ならLow,5~9ならHighと表示されます\n");
		System.out.printf("Target:1つ数字を宣言してその数が\n相手の選んだ3つの数字に含まれているかを調べます。\nさらに入っていた場合はその位置がわかります\n");
		System.out.printf("------------------------------------------------------\n");
	}

	// 3桁の数字を入れるとこ
	public static ArrayList<Character> setNum() {
		ArrayList<Character> ans = new ArrayList<>();
		String tmp;
		while (true) {
			System.out.print("3桁かつ別々の数字を入力して下さい: ");
			tmp = Player.scanner.nextLine();
			if (tmp.length() == 3 && tmp.charAt(0) != tmp.charAt(1) && tmp.charAt(0) != tmp.charAt(2)
					&& tmp.charAt(1) != tmp.charAt(2)) {
				for (int i = 0; i < 3; i++) {
					ans.add(tmp.charAt(i));
				}
				return ans;
			}
		}
	}

	public static String setName() {
		System.out.print("あなたの名前を入力して下さい: ");
		return Player.scanner.nextLine();
	}

}
