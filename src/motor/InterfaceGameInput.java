package motor;

public interface InterfaceGameInput {
	static enum PLAYER_INPUT {
		P1_UP,
		P1_DOWN,
		P1_RIGHT,
		P1_LEFT,
		P1_STOP,
		P2_UP,
		P2_DOWN,
		P2_RIGHT,
		P2_LEFT,
		P2_STOP
	}
	
	void assignControllers();
	void input(PLAYER_INPUT i);
}
