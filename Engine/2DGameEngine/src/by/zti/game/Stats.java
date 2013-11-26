package by.zti.game;


public class Stats {
	private int health;
	private float xp;
	private static final double LEVEL_CONSTANT = 25 + Math.pow(3.0, (3.0/2.0));
	
	public Stats(float xp){
		this.xp = xp;
		this.health = getMaxHelth();
	}
	
	public int getCurrentHealth(){
		int max = getMaxHelth();
		if(health>max){
			health = max;
		}
		return health;
	}
	
	public float getSpeed(){
		return 4f; //TODO алгоритм скорости
	}
	
	public int getLevel(){
		double x = xp + 105;
		double a = Math.sqrt(243 * (x*x) + 4050 * x + 17500);
		double c = (3 * x +25)/25;
		double d = Math.cbrt(a / LEVEL_CONSTANT + c);
		return (int)(d - 1.0/d*3) -2;
	}
	
	public int getMaxHelth(){
		return (int)getLevel() * 10;
	}
	
	public float getStrength(){
		return getLevel() * 4f;
	}
	
	public float getMagic(){
		return getLevel() * 4f;
	}
	
	public void addXp(float amount){
		xp += amount;
	}
}
