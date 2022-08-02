package model;

public class Message {
	public static final String[] statusName() {String[] statusName = {"攻撃力","防御力","素早さ","HP","MP"};return statusName;}
	public static final String atkMsg() {return " の こうげき";}
	public static final String damageMsg() {return " の ダメージ";}
	public static final String downMsg() {return " は たおれた";}
	public static final String runMsg() {return " は にげだした";}
	public static final String eatItemMsg() {return " を もぐもぐ";}
	public static final String upStatMsg() {return " あがった";}
	public static final String healMsg() {return " かいふくした";}
	public static final String getExpMsg() {return " の けいけんち を てにいれた";}
	public static final String lvUpMsg() {return " レベル に なった";}
	public static final String getMoneyMsg() {return " Javaを てにいれた";}
	public static final String reduceMoneyMsg() {return " Javaに なった";}
	public static final String gameOverMsg() {return "めのまえ が まっくら に なった";}
	public static final String encountEnemyMsg() {return " があらわれた";}
	public static final String notMp() {return "MP が たりません";}
	public static final String[] difficultys() {String[] difficultys = {"easy", "normal", "hard"};return difficultys;}
	public static final String stopExpMsg() {return "これいじょう つよくなれない";}
	public static final String[] enemyTypes() {String[] enemyTypes = {"DeepOnes", "Umibozu", "Minotaur", "Mimic", "Summoner", "Ogre"};return enemyTypes;}  
	public static final String[] bossTypes() {String[] bossTypes = {"Slime", "Unicorn", "DevilKing"};return bossTypes;}
}
