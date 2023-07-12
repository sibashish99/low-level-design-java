package com.java.demo;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpBehavior shortJump = new ShortJump();
        JumpBehavior LongJump = new LongJump();
        KickBehavior tornadoKick = new TornadoKick();
  
        
        Fighter ken = new Ken(tornadoKick,shortJump);
        ken.display();
  
  
        ken.punch();
        ken.kick();
        ken.jump();
  
     
        ken.setJumpBehavior(LongJump);
        ken.jump();
	}

}
