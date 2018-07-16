package system;

import java.util.ArrayList;

public class Turn {
	// フィールド
	private int count;
	private boolean turn;
	private ArrayList<Player> players = new ArrayList<>();

	// コンストラクタ
	public Turn() {
		count = 0;
		turn = true;
		players.add(new Player());
		players.add(new Player());
	}

	// 最初のイントロ
	public void intro() {
		while (true) {
			System.out.println("1:ルール説明,2:スタート");
			System.out.printf("1か2を選択してください:");
			String select = Player.scanner.nextLine();
			if (select.equals("1"))
				GameSystem.rule();
			else if (select.equals("2"))
				start();
		}
	}

	// ゲーム本編
	public void start() {
		boolean gameFlg = false;
		Player player;
		String select;
		// Playerクラスのcallメソッドでtrueになれば終了
		while (!gameFlg) {
			player = changePlayer();
			System.out.printf("%d ターン目:  %s\n", (count / 2) + 1, player.getName());
			System.out.println("1:call,2:High&Low,3.Target");
			System.out.print("行動を選択してください:");
			select = Player.scanner.next();
			if (select.equals("1")) {
				gameFlg = player.call(enemyPlayer());
			} else if (select.equals("2") && player.getSpCount() == 0) {
				player.highlow(enemyPlayer());
			} else if (select.equals("3") && player.getSpCount() == 0) {
				player.target(enemyPlayer());
			} else if (select.equals("2") || select.equals("3") && player.getSpCount() != 0) {
				System.out.println("使用回数が残っていません");
				continue;
			} else
				continue;
			// ターン変更
			changeTurn();
		}
		System.out.println(enemyPlayer().getName() + "さんの勝利です");
		System.exit(0);
	}

	// プレイヤー交代
	public Player changePlayer() {
		if (turn)
			return players.get(0);
		else
			return players.get(1);
	}

	// 敵プレイヤー
	public Player enemyPlayer() {
		if (turn)
			return players.get(1);
		else
			return players.get(0);
	}

	// ターン交代
	public void changeTurn() {
		turn = !turn;
		count++;
		System.out.println("==============================================");


	}
}
