package sprites;

public class ryuPlayer extends Sprites {
	public ryuPlayer() throws Exception {
		super(PLAYER_IMAGE); 
		this.x = 50;
		
	}
	@Override
	protected void kickAction() {
		int w = 70;
		kick[0] =  fullImage.getSubimage(40, 1044, w, 100);
		kick[1] =  fullImage.getSubimage(121, 1042, w, 100);
		kick[2] =  fullImage.getSubimage(203, 1038, w+50, 100);
		kick[3] =  fullImage.getSubimage(327, 1046, w, 100);
		kick[4] =  fullImage.getSubimage(410, 1045, w, 100);
		kick[5] =  fullImage.getSubimage(484, 1048, w+30, 100);
	}
	@Override
	protected  void defaultAction() {
		int w = 70;
		defaultMove[0] =  fullImage.getSubimage(65, 233, w, 100);
		defaultMove[1] =  fullImage.getSubimage(143, 235, w, 100);
		defaultMove[2] =  fullImage.getSubimage(226, 234, w, 100);
		defaultMove[3] =  fullImage.getSubimage(305, 234, w, 100);
		defaultMove[4] =  fullImage.getSubimage(378, 234, w, 100);
		defaultMove[5] =  fullImage.getSubimage(453, 240, w, 100);
	}
	@Override
	protected void hit() {
		int w = 70;
		// TODO Auto-generated method stub
		hitMove[0] = fullImage.getSubimage(243,2527,w,100);
		hitMove[1] = fullImage.getSubimage(330,2529,w,100);
		hitMove[2] = fullImage.getSubimage(243,2527,w,100);
		hitMove[3] = fullImage.getSubimage(330,2529,w,100);
		hitMove[4] = fullImage.getSubimage(243,2527,w,100);
		hitMove[5] = fullImage.getSubimage(330,2529,w,100);
	}


}
