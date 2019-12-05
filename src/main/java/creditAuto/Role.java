package creditAuto;

public enum Role {
	ADMIN(1),
	MANAGER(2),
	CUSTOMERADVISER(3);
	
	private int Id;
	
	Role(int i) {
		this.Id = i;
	}
	
	int getRole(){
		return this.Id;
	}
}
